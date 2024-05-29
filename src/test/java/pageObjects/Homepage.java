package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Homepage extends BasePage {
	WebDriver driver;

	public Homepage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//span[normalize-space()='My Account']")
	WebElement lnkMyAcc;
	@FindBy(xpath = "//*[@class='dropdown-menu dropdown-menu-right']//a[normalize-space()='Register']")
	WebElement lnkRegister;

	@FindBy(xpath = "//*[contains(@class,'dropdown-menu dropdown-menu-right')]//a[contains(text(),'Login')]")
	WebElement lnkLogin;

	public void clickMyAccount() {

		lnkMyAcc.click();

	}

	public void clickRegister() {
		lnkRegister.click();
	}

	public void clickLogin() {
		lnkLogin.click();
	}
}
