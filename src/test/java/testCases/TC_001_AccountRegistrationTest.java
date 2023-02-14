package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC_001_AccountRegistrationTest extends BaseClass {

	@Test(groups= {"regression","master"})
	void test_account_registration() {
		logger.info("****starting TC_001_AccountRegistrationTest ****");
		try {
		HomePage hp= new HomePage(driver);
		
		hp.clickMyAccount();
		logger.info("clicked my account link");
		hp.clickRegister();
		logger.info("clicked register link");
		
		AccountRegistrationPage rp= new AccountRegistrationPage(driver);
		logger.info("providing customer data");
		rp.setFirstName(randomString());
		rp.setLastName(randomString());
		rp.setEmail(randomString()+"@gmail.com"); //randomly generated the email
		rp.setPassword(randomAlphanumeric());
		rp.clickpolicyBox();
		rp.clickContinueBtn();
		logger.info("clicked continue button");
		
		String confmsg=rp.getconformationMsg();
		logger.info("validating expected message");
		Assert.assertEquals(confmsg,"Your Account Has Been Created!","Test failed");
		}
		catch(Exception e) {
			logger.error("test failed");
			Assert.fail();
		}
		logger.info("*****TC_001_AccountRegistrationTest*******");
	}
	
}
