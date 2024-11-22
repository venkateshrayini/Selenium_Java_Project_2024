package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import testBase.BaseClass;

public class TC_006_TestBrands extends BaseClass{

	@Test(groups="Master")
	public void testBrands() {
		HomePage hp = new HomePage(driver);
		String act_text = hp.clickBrands();
		
		Assert.assertEquals(act_text, "Find Your Favorite Brand");
	}
	
}
