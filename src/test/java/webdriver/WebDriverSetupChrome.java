package webdriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverSetupChrome {
	
	
	public static void main(String[] args) {
	String path = System.getProperty("user.dir");
	System.setProperty("webdriver.chrome.driver", path + "//drivers//chromedriver.exe");
	WebDriver driver = new ChromeDriver(); 
	driver.get("https://demoqa.com/automation-practice-form");
	driver.close();
	//driver.quit();
	
	}

}
