package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC_002_LoginTest extends BaseClass{

	@Test(groups="Regression")
	public void loginTest() {
		
		logger.info("****TC_002_LoginTest Started****");
		try {
		HomePage hp = new HomePage(driver);
		hp.clickMyAccount();
		hp.clickLogin();
		
		LoginPage lp = new LoginPage(driver);
		lp.setUsername(p.getProperty("username"));
		lp.setPassword(p.getProperty("password"));
		lp.clickLogin();
		
		MyAccountPage macc= new MyAccountPage(driver);
		boolean targetpage = macc.myaccounttext();
		Assert.assertTrue(targetpage);
		}
		catch(Exception e) {
			Assert.fail();
		}
		logger.info("****TC_002_LoginTest Finished****");
	}
}
