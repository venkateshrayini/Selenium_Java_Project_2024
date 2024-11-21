package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;
import utilities.DataProviders;

public class TC_003_LoginDDT extends BaseClass{

	@Test(dataProvider="LoginData",dataProviderClass=DataProviders.class, groups={"Master"})
	public void testLogin(String email, String pwd, String exp) {
		
		logger.info("****TC_003_LoginDDT Started Execution****");
		
		try {
		
		HomePage hp = new HomePage(driver);
		hp.clickMyAccount();
		hp.clickLogin();
		
		LoginPage lp = new LoginPage(driver);
		lp.setUsername(email);
		lp.setPassword(pwd);
		lp.clickLogin();
		
		MyAccountPage macc= new MyAccountPage(driver);
		boolean targetpage = macc.myaccounttext();
		
		if(exp.equalsIgnoreCase("valid")) {
			if(targetpage==true) {
				macc.clickLogout();
				Assert.assertTrue(true);
			}
			else {
				Assert.assertTrue(false);
			}
		}
		
		if(exp.equalsIgnoreCase("invalid")) {
			if(targetpage==true) {
				macc.clickLogout();
				Assert.assertTrue(false);
			}
			else {
				Assert.assertTrue(true);
			}
		}
		}
		catch(Exception e) {
			Assert.fail("An Exeception Occurred : "+e.getMessage());
		}
		
		logger.info("****TC_003_LoginDDT_Test Execution Finished****");
	}
}
