package testCases;

import static org.testng.Assert.fail;

import org.testng.Assert;
import org.testng.annotations.*;

import pageObjects.HomePage;
import pageObjects.LogInPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC_002_LogInTest extends BaseClass{

	@Test(groups= {"sanity","master"})
	void tc_002_logInTest() {
		logger.info("**** starting TC_002_LogInTest");
		try {
		HomePage hp= new HomePage(driver);
		hp.clickMyAccount();
		hp.clickLogIn();
		
		LogInPage lp= new LogInPage(driver);
		lp.setEmail(rb.getString("email"));
		lp.setPAssword(rb.getString("password"));
		
		lp.clickLogIn();
		
		MyAccountPage macc= new MyAccountPage(driver);
		Assert.assertEquals(true,macc.checkMyAccountPresent());
		}
		catch(Exception e) {
			Assert.fail();
		}
		logger.info("***finished TC_002_LogInTest");
		
	}
	
}
