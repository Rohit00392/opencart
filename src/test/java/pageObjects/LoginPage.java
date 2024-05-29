package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {
	WebDriver driver;

	public LoginPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(id="input-email")
	WebElement txtEmailAddress;
	
	@FindBy(id="input-password")
	WebElement txtpassword;
	
	@FindBy(xpath = "//input[@value='Login']")
	WebElement btnLogin;
	
	public void setEmail(String email) {
		txtEmailAddress.sendKeys(email);
		
	}
	public void setPassword(String password) {
		txtpassword.sendKeys(password);
		
	}
	public void clickLogin() {
		btnLogin.click();
	}
	
}
