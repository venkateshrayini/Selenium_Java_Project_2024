package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{


	public HomePage(WebDriver driver)
	{
		super(driver);
	}
	
	//locators
	@FindBy(xpath="//span[normalize-space()='My Account']") WebElement btnMyAccount;
	@FindBy(xpath="//a[normalize-space()='Register']") WebElement btnRegister;
	@FindBy(xpath="//a[normalize-space()='Login']") WebElement btnLogin;
	
	//Methods
	public void clickMyAccount() {
		btnMyAccount.click();
	}
	
	public void clickRegester() {
		btnRegister.click();
	}
	
	public void clickLogin() {
		btnLogin.click();
	}
	
}
