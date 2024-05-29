package pageObjects;

import org.openqa.selenium.WebElement;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AccountRegisterPage extends BasePage {
	WebDriver driver;

	public AccountRegisterPage(WebDriver driver) {
		super(driver);

	}

	@FindBy(id = "input-firstname")
	WebElement txtFirstName;

	@FindBy(id = "input-lastname")
	WebElement txtLastName;

	@FindBy(id = "input-email")
	WebElement txtEmail;

	@FindBy(id = "input-telephone")
	WebElement txtTelephone;

	@FindBy(id = "input-password")
	WebElement txtPassword;

	@FindBy(id = "input-confirm")
	WebElement txtConPassword;

	@FindBy(xpath = "//label[normalize-space()='Yes']")
	WebElement radSubscribeYes;

	@FindBy(xpath = "//label[normalize-space()='No']")
	WebElement radSubscribeNo;

	@FindBy(name = "agree")
	WebElement chqPolicy;

	@FindBy(xpath = "//*[contains(@value,'Continue')]")
	WebElement btnContinue;

	@FindBy(xpath = "//h1[normalize-space()='Your Account Has Been Created!']")
	WebElement msgConfirmation;

	public void setFirstName(String fname) {
		txtFirstName.sendKeys(fname);
	}

	public void setLastName(String Lname) {
		txtLastName.sendKeys(Lname);
	}

	public void setEmail(String email) {
		txtEmail.sendKeys(email);
	}

	public void setTelephone(String telephone) {
		txtTelephone.sendKeys(telephone);
	}

	public void setPassword(String password) {
		txtPassword.sendKeys(password);

	}

	public void setConfirmPassword(String confirmpassword) {
		txtConPassword.sendKeys(confirmpassword);

	}

	public void setSubscribeYes() {
		radSubscribeYes.click();
	}

	public void setSubscribeNo() {
		radSubscribeNo.click();
	}

	public void setPrivacy() {
		chqPolicy.click();

	}

	public void clickContinue() {

		WebDriverWait mywait = new WebDriverWait(driver, Duration.ofSeconds(10));
		mywait.until(ExpectedConditions.elementToBeClickable(btnContinue)).click();

	}

	public String getConfirmationMsg() {
		try {
			return (msgConfirmation.getText());
		} catch (Exception e) {
			return (e.getMessage());

		}
	}
}
