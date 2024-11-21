package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends BasePage{

	public MyAccountPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath="//h2[normalize-space()='My Account']") WebElement myaccounttxt;
	
	@FindBy(xpath="//a[@class='list-group-item'][normalize-space()='Logout']") WebElement btn_Logout;
	
	public boolean myaccounttext() {
		try {
		return myaccounttxt.isDisplayed();
		}
		catch(Exception e) {
			return false;
		}
	}
	
	public void clickLogout() {
		btn_Logout.click();
	}
}
