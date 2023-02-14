package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends BasePage {

	public MyAccountPage(WebDriver driver) {
		super(driver);
	}
	
	//Elements
	@FindBy(xpath="//h2[normalize-space()='My Account']")
	WebElement headerMyaccount;
	
	@FindBy(linkText="Logout")
	WebElement linkLogOut;
	
	
	
	//Actions
	public boolean checkMyAccountPresent() {
		try {
		return (headerMyaccount.isDisplayed());
		}
		catch(Exception e) {
			return(false);
		}
	}
	
	public void clickLogOut() {
		linkLogOut.click();
	}
}
