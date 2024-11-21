package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountRegestrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC_001_AccountRegestration extends BaseClass{

	@Test(groups="Sanity")
	public void accountRegestrations() {
		
		logger.info("***Started Account Regestration Test***");
		
		try {
	
			HomePage hp= new HomePage(driver);
			hp.clickMyAccount();
			hp.clickRegester();
			
			
			AccountRegestrationPage regpage= new AccountRegestrationPage(driver);
			regpage.setFirstName(randomString().toUpperCase());
			regpage.setLastName(randomString().toUpperCase());
			regpage.setEmail(randomString()+"@gmail.com");
			regpage.setPhoneNumber(randomNumber());
			
			String password = randomNumber();
			
			regpage.setpassword(password);
			regpage.setConformpassword(password);
			
			//regpage.clickSubscribe();
			
			regpage.btnPrivacy();
			regpage.btnContinue();
			
			String confmsg=regpage.getConfirmationMsg();
			Assert.assertEquals(confmsg, "Your Account Has Been Created!");
		}
		catch(Exception e) {
			logger.error("Test is failed...");
			logger.debug("Debug logs are attached...");
			Assert.fail();
		}
		finally {
			logger.info("***Finished Account Regestration Test***");
		}
		
		
	}
}
