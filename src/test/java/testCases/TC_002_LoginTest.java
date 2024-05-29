package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.Homepage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC_002_LoginTest extends BaseClass {

	@Test(groups= {"sanity","master"})
	public void verifyLogin() {
		logger.info("***** Starting TC_002_LoginTest testCase *****");
		logger.debug("capturing application debug logs");
		try {
			Homepage hm = new Homepage(driver);
			hm.clickMyAccount();
			logger.info("Clicked on myaccount link on the homepage");
			hm.clickLogin();// login page
			logger.info("Clicked on login link under Homepage");

			// login page access
			LoginPage lp = new LoginPage(driver);
			logger.info("Enter valid email and password");
			lp.setEmail(p.getProperty("email"));

			lp.setPassword(p.getProperty("password"));

			lp.clickLogin();// login button
			logger.info("Clicked on login button");

			// My Account Page

			MyAccountPage mp = new MyAccountPage(driver);

			boolean targetpage = mp.isMyAccountPageExist();
		
			if (targetpage == true) {
				logger.info("Test is passed");
				Assert.assertTrue(true);
			} else {
				logger.error("Test is failed");
				Assert.fail();
			}
		
		} catch (Exception e) {
			Assert.fail();
		}
		logger.info("***** Finish TC_002_LoginTest testCase *****");
	}

}
