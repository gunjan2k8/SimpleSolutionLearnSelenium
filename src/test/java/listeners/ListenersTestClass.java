package listeners;
import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import logging.TestLogger;

@Listeners(utils.Listeners.class)

public class ListenersTestClass {
	
	private static Logger log = Logger.getLogger(TestLogger.class.getName());


	
	@Test(priority=0)
	public void TestCasePass() {
	//DOMConfigurator.configure("log4j.xml");
	String path = System.getProperty("user.dir");
	System.setProperty("webdriver.chrome.driver", path + "//drivers//chromedriver.exe");
	WebDriver driver = new ChromeDriver(); 
	driver.get("https://www.automationexercise.com/");
	log.info("Open automation exercise website");
	driver.manage().window().maximize();
	log.info("Maximize window size");
	driver.findElement(By.partialLinkText("Signup / Log")).click();
	driver.findElement(By.name("name")).sendKeys("gunjan");
	log.info("enter username");
	driver.findElement(By.xpath("//input[@data-qa='signup-email']")).sendKeys("gunjan2k8@gmail.com");
	log.info("enter email");
	driver.findElement(By.xpath("//button[@data-qa='signup-button']")).click();
	driver.close();
	}
	
	@Test(priority=1)
	public void TestToFail() {
		
		System.out.println("test to fail method calling");
		Assert.assertTrue(false);
		
	}
	

}
