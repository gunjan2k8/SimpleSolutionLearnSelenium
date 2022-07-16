package listeners;

import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import basetestclass.BaseTestClass;
import io.github.bonigarcia.wdm.WebDriverManager;
import utils.ListenerwithExtentreport;

@Listeners(utils.ListenerwithExtentreport.class)
public class ListenersTestWithExtentReport extends BaseTestClass{
	
private static Logger log = Logger.getLogger(ListenersTestWithExtentReport.class.getName());

@BeforeMethod
public void setup(ITestContext context) {
	
//String path = System.getProperty("user.dir");
//System.setProperty("webdriver.chrome.driver", path + "//drivers//chromedriver.exe");
WebDriverManager.chromedriver().setup();
driver = new ChromeDriver(); 
 context.setAttribute("WebDriver", driver);
driver.get("https://www.automationexercise.com/");
log.info("Open automation exercise website");
driver.manage().window().maximize();
log.info("Maximize window size");
}
	
	@Test(priority=0)
	public void TestCase1() throws InterruptedException {
	driver.findElement(By.partialLinkText("Signup / Log")).click();
	ListenerwithExtentreport.logger.log(Status.INFO, "enter username");
	//Thread.sleep(100);
	driver.findElement(By.name("name")).sendKeys("gunjan");
	log.info("enter username");
	ListenerwithExtentreport.logger.log(Status.INFO, "name is entered");
	
	ListenerwithExtentreport.logger.log(Status.INFO, "enter email address");
	
	driver.findElement(By.xpath("//input[@data-qa='signup-email']")).sendKeys("gunjan2k8@gmail.com");
	log.info("enter email");
	ListenerwithExtentreport.logger.log(Status.INFO, "email address is entered");
	ListenerwithExtentreport.logger.log(Status.INFO, "click on signup button");
	driver.findElement(By.xpath("//button[@data-qa='signup-button']")).click();
	ListenerwithExtentreport.logger.log(Status.INFO, "signup button clicked");

   
	}
	
	@Test(priority=1,enabled=false)
	public void TestCase2() {
	driver.findElement(By.partialLinkText("Signup / Log")).click();
	
	// code change to fail this test case
	driver.findElement(By.name("name")).sendKeys("gunjan");
	String emailtext=driver.findElement(By.name("name")).getAttribute("value");
	Assert.assertEquals(emailtext,"gunjanme");
	
	
	log.info("enter username");
	driver.findElement(By.xpath("//input[@data-qa='signup-email']")).sendKeys("gunjan2k8@gmail.com");
	log.info("enter email");
	driver.findElement(By.xpath("//button[@data-qa='signup-button']")).click();

	}

	@Test(priority=2,enabled=false)
	public void TestCase3() {

			throw new SkipException("TestCaseSkip method skipped");
	}


	@AfterMethod
	public void teardown() {
	    
		driver.close();
	}
	
}
