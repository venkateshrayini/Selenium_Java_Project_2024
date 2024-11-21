package testCases;

import org.testng.annotations.Test;

import pageObjects.HomePage;
import testBase.BaseClass;

public class TC_004_Software extends BaseClass{

	@Test(groups= {"regression"})
	public void test_Software() {
		
		logger.info("****TC_004_Software is started****");
		
		try {
		HomePage hp= new HomePage(driver);
		
		hp.clickSoftware();
		hp.clickSamsungGalaxy();
		
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		logger.info("****TC_004_Software is Finishied****");
	}
	
}
