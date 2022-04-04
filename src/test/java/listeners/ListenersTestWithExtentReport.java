package listeners;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import basetestclass.BaseTestClass;

@Listeners(utils.ListenerwithExtentreport.class)
public class ListenersTestWithExtentReport extends BaseTestClass {
	
private static Logger log = Logger.getLogger(ListenersTestWithExtentReport.class.getName());


	
	@Test(priority=0)
	public void TestCasePass() {
	driver.findElement(By.partialLinkText("Signup / Log")).click();
	driver.findElement(By.name("name")).sendKeys("gunjan");
	log.info("enter username");
	driver.findElement(By.xpath("//input[@data-qa='signup-email']")).sendKeys("gunjan2k8@gmail.com");
	log.info("enter email");
	driver.findElement(By.xpath("//button[@data-qa='signup-button']")).click();

   
	}
	
	@Test(priority=1)
	public void TestCaseFail() {
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

	@Test(priority=2)
	public void TestCaseSkip() {

			throw new SkipException("TestCaseSkip method skipped");
	}

	
}
