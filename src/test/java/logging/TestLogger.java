package logging;


import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class TestLogger {
	
	private static Logger log = Logger.getLogger(TestLogger.class.getName());
	
	@Test
	public void testcase() {
		
		
	DOMConfigurator.configure("log4j.xml");
	String path = System.getProperty("user.dir");
	System.setProperty("webdriver.chrome.driver", path + "//drivers//chromedriver.exe");
	WebDriver driver = new ChromeDriver(); 
	driver.get("https://www.automationexercise.com/");
		
	log.info("Open automation exercise website");
	log.debug("Open automation exercise website debug message");
	log.trace("Open automation exercise website trace message");
	log.error("error message");
	driver.manage().window().maximize();
	log.info("Maximize window size");
	driver.findElement(By.partialLinkText("Signup / Log")).click();
	driver.findElement(By.name("name")).sendKeys("gunjan");
	log.debug("enter username");
	driver.findElement(By.xpath("//input[@data-qa='signup-email']")).sendKeys("gunjan2k8@gmail.com");
	log.debug("enter email");
	driver.findElement(By.xpath("//button[@data-qa='signup-button']")).click();
	log.info("click signup button");
	
	   log.debug("Sample debug message");  
       log.info("Sample info message");  
       log.warn("Sample warn message");  
       log.error("Sample error message");  
       log.fatal("Sample fatal message"); 
       log.trace("Sample trace message"); 

       
	driver.close();
	}

	

}
