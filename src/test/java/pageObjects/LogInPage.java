package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LogInPage extends BasePage {

	public LogInPage(WebDriver driver){
		super(driver);
	}
	
	//Elements
	@FindBy(id="input-email")
	WebElement txtEmail;
	
	@FindBy(id="input-password")
	WebElement txtpassword;
	
	@FindBy(xpath="//button[text()='Login']")
	WebElement btnsubmit;
	
	//Action
	public void setEmail(String email) {
		txtEmail.sendKeys(email);
	}
	
	public void setPAssword(String password) {
		txtpassword.sendKeys(password);
	}
	
	public void clickLogIn() {
		btnsubmit.click();
	}
}
