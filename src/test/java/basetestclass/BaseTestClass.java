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

public class BaseTestClass{
	
	public WebDriver driver;
	private static Logger log = Logger.getLogger(BaseTestClass.class.getName());

	



	
}
