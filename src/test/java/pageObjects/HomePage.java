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
	@FindBy(xpath="//a[normalize-space()='Software']") WebElement btnSoftware;
	@FindBy(xpath="//a[normalize-space()='Samsung Galaxy Tab 10.1']") WebElement linkSamsungGalaxy;
	
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
	
	public void clickSoftware() {
		btnSoftware.click();
	}
	
	public void clickSamsungGalaxy() {
		linkSamsungGalaxy.click();
	}
}
