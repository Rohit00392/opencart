package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.Homepage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;
import utilities.DataProviders;

public class TC_003_LoginDDT extends BaseClass {

	@Test(dataProvider ="LoginData",dataProviderClass=DataProviders.class)
	public void verify_LoginDDT(String email, String password, String exp) {

		logger.info("*****Starting TC_003_oginDDT***** ");
		try {
		Homepage hm = new Homepage(driver);
		hm.clickMyAccount();

		hm.clickLogin();// login page

		// login page access
		LoginPage lp = new LoginPage(driver);

		lp.setEmail(email);

		lp.setPassword(password);

		lp.clickLogin();// login button

		// My Account Page

		MyAccountPage mp = new MyAccountPage(driver);

		boolean targetpage = mp.isMyAccountPageExist();

		if (exp.equalsIgnoreCase("Valid")) {

			if (targetpage == true) {
				mp.clickLogout();
				Assert.assertTrue(true);
			} else {

				Assert.assertFalse(false);

			}
		}
		if (exp.equalsIgnoreCase("Invalid")) {
			if (targetpage == true) {
				mp.clickLogout();
				Assert.assertTrue(false);

			} else {

				Assert.assertTrue(true);

			}

		}
		}catch(Exception e) {
			Assert.fail();
		}
		logger.info("*****Finished TC_003_oginDDT***** ");
	}

}
