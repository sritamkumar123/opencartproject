package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

	public HomePage(WebDriver driver) {
		super(driver);
	}
	//elements
	@FindBy(xpath="//span[text()='My Account']")
	WebElement linkMyaccount;
	
	@FindBy(xpath="//a[text()='Register']")
	WebElement linkRegister;
	
	@FindBy(linkText="Login")
	WebElement linkLogIn;
	
	// action methods
	public void clickMyAccount() {
		linkMyaccount.click();
	}
	public void clickRegister() {
		linkRegister.click();
	}
	public void clickLogIn() {
		linkLogIn.click();
	}
}
