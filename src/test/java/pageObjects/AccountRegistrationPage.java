package pageObjects;


import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountRegistrationPage extends BasePage{
	
	
    
	public AccountRegistrationPage(WebDriver driver) {
		super(driver);
		
	}
	
	JavascriptExecutor js= (JavascriptExecutor) driver;
	
	
	//Elements
	@FindBy(name="firstname")
	WebElement txtfirstname;
	
	@FindBy(name="lastname")
	WebElement txtlastname;
	
	@FindBy(name="email")
	WebElement txtemail;
	
	@FindBy(name="password")
	WebElement txtpassword;
	
	@FindBy(xpath="//input[@name='agree']")
	WebElement boxPolicy;
	
	@FindBy(xpath="//button[normalize-space()='Continue']")
	WebElement btncontinue;
	
	@FindBy(xpath="//h1[text()='Your Account Has Been Created!']")
	WebElement msgConformation;
	
	//Actions
	public void setFirstName(String fname) {
		txtfirstname.sendKeys(fname);
	}
	
	public void setLastName(String lname) {
		txtlastname.sendKeys(lname);
	}
	
	public void setEmail(String email) {
		txtemail.sendKeys(email);
	}
	
	public void setPassword(String pwd) {
		txtpassword.sendKeys(pwd);
	}
	
	public void clickpolicyBox() {
		
		js.executeScript("arguments[0].click();", boxPolicy);
	}
	
	public void clickContinueBtn() {
		js.executeScript("arguments[0].click();", btncontinue);
	}
	
	public String  getconformationMsg() {
		try {
		return(msgConformation.getText());
		}
		catch(Exception e) {
			return(e.getMessage());
		}
	}
	
	
	
	
}
