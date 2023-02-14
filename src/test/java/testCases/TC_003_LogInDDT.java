package testCases;

import org.testng.Assert;
import org.testng.annotations.*;

import pageObjects.HomePage;
import pageObjects.LogInPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;
import utilities.DataProviders;

public class TC_003_LogInDDT extends BaseClass {

	@Test(dataProvider="LoginData", dataProviderClass=DataProviders.class)
	public void test_logInDDT(String email, String password, String exp) {
		logger.info("****TC_003_LogInDDT start*****");
		
		try {
		HomePage hp= new HomePage(driver);
		hp.clickMyAccount();
		hp.clickLogIn();
		
		LogInPage lp= new LogInPage(driver);
		lp.setEmail(email);
		lp.setPAssword(password);
		
		lp.clickLogIn();
		
		MyAccountPage macc= new MyAccountPage(driver);
		boolean targetpage=macc.checkMyAccountPresent();
		
		if(exp.equals("valid")) {
			if(targetpage==true) {
				macc.clickLogOut();
				Assert.assertTrue(true);
			}
		}
		else {
			Assert.fail();
		}
		
		if(exp.equals("Invalid")) {
			if(targetpage==true) {
				macc.clickLogOut();
				Assert.assertTrue(false);
			}
		}
		else {
			Assert.assertTrue(true);
		}
		}
		catch(Exception e) {
			Assert.fail();
		}
		
		logger.info("***Finished TC_003_LogInDDT start*****");
		
	}
}
