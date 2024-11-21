package pageObjects;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountRegestrationPage extends BasePage{

	public AccountRegestrationPage(WebDriver driver)
	{
		super(driver);
	}
	
	//Locators
	
	@FindBy(xpath="//input[@id='input-firstname']") WebElement txtFirstname;
	@FindBy(xpath="//input[@id='input-lastname']") WebElement txtLastName;
	@FindBy(xpath="//input[@id='input-email']") WebElement txtEmail;
	@FindBy(xpath="//input[@id='input-telephone']") WebElement txtPhonenumber;
	@FindBy(xpath="//input[@id='input-password']") WebElement txtPassword;
	@FindBy(xpath="//input[@id='input-confirm']") WebElement txtConformPassword;
	@FindBy(xpath="//input[@name='agree']") WebElement btnPrivacy;
	@FindBy(xpath="//input[@value='Continue']") WebElement btnContinue;
	@FindBy(xpath = "//h1[normalize-space()='Your Account Has Been Created!']") WebElement msgConfirmation;
	
	//Methods
	public void setFirstName(String firstname) {
		txtFirstname.sendKeys(firstname);
	}
	
	public void setLastName(String lastname) {
		txtLastName.sendKeys(lastname);
	}
	
	public void setEmail(String email) {
		txtEmail.sendKeys(email);
	}
	
	public void setPhoneNumber(String phone) {
		txtPhonenumber.sendKeys(phone);
	}
	
	public void setpassword(String password) {
		txtPassword.sendKeys(password);
	}
	
	public void setConformpassword(String password) {
		txtConformPassword.sendKeys(password);
	}
	
	public void btnPrivacy() {
		btnPrivacy.click();
	}
	
	public void btnContinue() {
		btnContinue.click();
	}
	
	public String getConfirmationMsg() {
		try {
			return (msgConfirmation.getText());
		} catch (Exception e) {
			return (e.getMessage());

		}

	}
	
}
