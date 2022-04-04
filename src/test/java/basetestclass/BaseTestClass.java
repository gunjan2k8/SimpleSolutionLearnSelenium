package basetestclass;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import listeners.ListenersTestWithExtentReport;
import utils.ListenerwithExtentreport;

public class BaseTestClass {
	
	public WebDriver driver;
	private static Logger log = Logger.getLogger(BaseTestClass.class.getName());

	
	@BeforeMethod
		public void setup(ITestContext context) {
		String path = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", path + "//drivers//chromedriver.exe");
		driver = new ChromeDriver(); 
		 context.setAttribute("WebDriver", driver);
		driver.get("https://www.automationexercise.com/");
		log.info("Open automation exercise website");
		driver.manage().window().maximize();
		log.info("Maximize window size");
	}


	
	@AfterMethod
	public void teardown() {
	    
		driver.close();
	}
}
