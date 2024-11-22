package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import testBase.BaseClass;

public class TC_005_LogoTest extends BaseClass{

	@Test(groups=("sanity"))
	public void testLogo() {
		
		logger.info("****TC_005_LogoTest Started Execution****");
		
		try {
		
		HomePage hp= new HomePage(driver);
		boolean status = hp.logoStatus();
		Assert.assertEquals(true, status);
		}
		catch(Exception e) {
			e.getMessage();
			Assert.fail();
		}
		
		logger.info("****TC_005_LogoTest Finishied Execution****");
	}
}
