package testsuite;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestClass {
	
	WebDriver driver;
	
	@BeforeMethod
	public void test3(){
		
		String path = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", path + "//drivers//chromedriver.exe");
		driver = new ChromeDriver(); 
		
	}
	
		@Test
		public void test1() {
		
		driver.get("https://demoqa.com/automation-practice-form");
		driver.close();
		//driver.quit();
		
		}
		
		
		@Test
		public void test2() {
		
			driver.get("https://www.google.com");
			driver.close();
			
			
		}
	
	
	

}
