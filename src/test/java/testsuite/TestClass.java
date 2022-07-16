package testsuite;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestClass {
	
	WebDriver driver;
	
	@BeforeMethod
	public void test4(){
		
		String path = System.getProperty("user.dir");
		System.out.println("print path"+path);
		
		System.setProperty("webdriver.chrome.driver", path + "//drivers//chromedriver.exe");
		driver = new ChromeDriver(); 
		
	}
	
		@Test(groups= {"SmokeTest"})  
		public void test1() {
			String path = System.getProperty("user.dir");
			System.out.println("print path"+path);
			
			System.setProperty("webdriver.chrome.driver", path + "//drivers//chromedriver.exe");
			driver = new ChromeDriver(); 
		driver.get("https://demoqa.com/automation-practice-form");
		System.out.println("inside test1");
		driver.close();
		//driver.quit();
		
		}
		
		
		@Test(groups= {"SanityTest","regression","payments"}) 
		public void test2() {
		
			driver.get("https://www.google.com");
			System.out.println("inside test2");
			driver.close();
		}
	
		@Test(groups= {"SanityTest","SmokeTest"}) 
		public void test3() {
			String path = System.getProperty("user.dir");
			System.out.println("print path"+path);
			
			System.setProperty("webdriver.chrome.driver", path + "//drivers//chromedriver.exe");
			driver = new ChromeDriver(); 
			driver.get("https://www.google.com");
			System.out.println("inside test2");
			driver.close();
					
		}
	
	

}
