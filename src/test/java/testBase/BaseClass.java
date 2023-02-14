package testBase;


	import java.io.File;
import java.io.IOException;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.ResourceBundle; // ResourceBundle package

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
    import org.apache.logging.log4j.LogManager; // package for logmanager
    import org.apache.logging.log4j.Logger;  // package for logger
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

	
	public class BaseClass {
		
		public ResourceBundle rb;
		public Logger logger; // initiate logger instance

		public static WebDriver driver;
		@Parameters({"browser"})
		@BeforeClass(groups= {"sanity","regression","master"})
		public void setup(String br) {
			
			     rb= ResourceBundle.getBundle("config"); // Load config.properties file
			     logger= LogManager.getLogger(this.getClass()); // specify current class
			    //WebDriverManager.chromedriver().setup();
			    if(br.equals("crome")) {
				driver= new ChromeDriver();
			    }
			    else if(br.equals("edge")) {
			    	driver= new EdgeDriver();
			    }
			    else {
			    	driver= new FirefoxDriver();
			    }
			    driver.manage().deleteAllCookies();
			    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			    driver.get(rb.getString("appUrl")); // using resource bundle key
			    driver.manage().window().maximize();
		}
		
		@AfterClass(groups= {"sanity","regression","master"})
		public void teardown()  {
			
			driver.quit();
		}
		
		public String randomString() {
			String generatedString= RandomStringUtils.randomAlphabetic(5);
			return (generatedString);
		}
		
		public String RandomNumber() {
			String generatedString2= RandomStringUtils.randomNumeric(5);
			return generatedString2;
		}
		
		public String randomAlphanumeric() {
			String st= RandomStringUtils.randomAlphabetic(4);
			String num= RandomStringUtils.randomNumeric(3);
			return (st+"@"+num);
		}
		
		public String captureScreen(String tname) throws IOException {

			String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
					
			TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
			File source = takesScreenshot.getScreenshotAs(OutputType.FILE);
			String destination = System.getProperty("user.dir") + "\\screenshots\\" + tname + "_" + timeStamp + ".png";

			try {
				FileUtils.copyFile(source, new File(destination));
			} catch (Exception e) {
				e.getMessage();
			}
			return destination;

		}

		
		
}
