package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{

	public LoginPage(WebDriver driver)
	{
		super(driver);
	}
	
	//Locators
	@FindBy(xpath="//input[@id='input-email']") WebElement txt_email;
	@FindBy(xpath="//input[@id='input-password']") WebElement txt_password;
	@FindBy(xpath="//input[@value='Login']") WebElement clickLogin;
	
	
	//Corresponding Methods
	public void setUsername(String username) {
		txt_email.sendKeys(username);
	}
	
	public void setPassword(String password) {
		txt_password.sendKeys(password);
	}
	
	public void clickLogin() {
		clickLogin.click();
	}
	
}
