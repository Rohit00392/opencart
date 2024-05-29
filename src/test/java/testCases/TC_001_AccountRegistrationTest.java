package testCases;

import org.testng.Assert;
import org.testng.annotations.*;

import pageObjects.AccountRegisterPage;
import pageObjects.Homepage;
import testBase.BaseClass;

public class TC_001_AccountRegistrationTest extends BaseClass {

	@Test(groups= {"regression","master"})
	public void verify_Account_Registration() {

		logger.info("***** Starting verify_Account_Registration ****** ");
		logger.debug("applications starts ....");
		try {
			Homepage hm = new Homepage(driver);
			hm.clickMyAccount();

			logger.info("click on MyAccount ");
			hm.clickRegister();
			logger.info("click on Register ");

			logger.info("Entering the customer details ");

			AccountRegisterPage ar = new AccountRegisterPage(driver);
			ar.setFirstName(randomString().toUpperCase());
			ar.setLastName(randomString().toUpperCase());
			ar.setEmail(randomAlphaNumeric() + "gmail.com");
			ar.setTelephone(randomnumber());
			String password = (randomAlphaNumeric());
			ar.setPassword(password);
			ar.setConfirmPassword(password);
			ar.setSubscribeYes();
			ar.setPrivacy();
			ar.clickContinue();
			logger.info("Click on COntinue button");
			String conf = ar.getConfirmationMsg();
			logger.info("Validating expected message");

			if (conf.equals("Your Account Has Been Created!")) {
				
				logger.info("test pass");
				Assert.assertTrue(true);
			} else {
				logger.info("test fail");
				Assert.fail();
			}
			// Assert.assertEquals(conf, "Your Account Has Been Created!");
		} catch (Exception e) {
			logger.error("test failed");
			Assert.fail();
		}
		logger.debug("applications Ends ....");
		logger.info("***** Finished verify_Account_Registration ****** ");
	}

}
