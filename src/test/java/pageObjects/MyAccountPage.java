package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends BasePage {
	WebDriver driver;

	public MyAccountPage(WebDriver driver) {

		super(driver);
	}

	@FindBy(xpath = "//h2[normalize-space()='My Account']")
	WebElement msgHeading;

	@FindBy(xpath = "//*[contains(@class,'list-group')]//a[contains(text(),'Logout')]")
	WebElement btnLogout;

	public boolean isMyAccountPageExist() //My account page display status
	{
		try {
			return (msgHeading.isDisplayed());
		} catch (Exception e) {
			return (false);
		}
	}

	public void clickLogout() {
		btnLogout.click();
	}
}
