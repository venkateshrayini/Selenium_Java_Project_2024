package testBase;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class BaseClass {

	public WebDriver driver;
	public Logger logger;
	public Properties p;
	
	@BeforeClass(groups= {"Sanity","Regression","Master"})
	@Parameters({"os", "browser"})
	public void setup(String os, String br) throws IOException
	
	{
		FileReader file= new FileReader("./src//test//resources//config.properties");
		p=new Properties();
		p.load(file);
	
		logger=LogManager.getLogger(this.getClass());//Log4j
		
		//os
		
		if(p.getProperty("execution_env").equalsIgnoreCase("remote")){
			
			DesiredCapabilities capabilities= new DesiredCapabilities();
			
			//Operating System - os
			
			switch(os.toLowerCase()) 
			{
			case "windows": capabilities.setPlatform(Platform.WIN11);break;
			case "mac":capabilities.setPlatform(Platform.MAC);break;
			default : System.out.println("No Matching OS is found");return;
			}
			
			
			switch(br.toLowerCase()) {
			case "chrome":capabilities.setBrowserName("chrome");break;
			case "edge":capabilities.setBrowserName("MicrosoftEdge");break;
			default : System.out.println("No Matching Browser is found");return;
			}
			
			driver=new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),capabilities);
			
		}
		
		
		if(p.getProperty("execution_env").equalsIgnoreCase("local")){
		
		switch(br.toLowerCase())
		{
		case "chrome": driver=new ChromeDriver(); break;
		case "edge": driver=new EdgeDriver(); break;
		default: System.out.println("No matching browser..");
					return;
		}
		
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get(p.getProperty("appURL"));
		driver.manage().window().maximize();
	}
	}
	
	@AfterClass(groups= {"Sanity","Regression","Master"})
	public void tearDown()
	{
		driver.close();
	}
	
	
	public String captureScreen(String tname) throws IOException {

		String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
				
		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
		
		String targetFilePath=System.getProperty("user.dir")+"\\screenshots\\" + tname + "_" + timeStamp + ".png";
		File targetFile=new File(targetFilePath);
		
		sourceFile.renameTo(targetFile);
			
		return targetFilePath;

	}
	
	//We are using to generate Random data at the time of Test case execution
	
		public String randomString() {
			String randomString = RandomStringUtils.randomAlphabetic(5);
			return randomString;
		}
		
		public String randomNumber() {
			String randomNumber= RandomStringUtils.randomNumeric(10);
			return randomNumber;
		}
		
		public String passowrd() {
			String randomString = RandomStringUtils.randomAlphabetic(5);
			String randomNumber= RandomStringUtils.randomNumeric(10);
			return (randomString+randomNumber);
		}
	
}
