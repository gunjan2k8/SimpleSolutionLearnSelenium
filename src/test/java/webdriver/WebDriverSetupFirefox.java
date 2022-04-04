package webdriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverSetupFirefox {
	
	
	public static void main(String[] args) {
	String path = System.getProperty("user.dir");
	System.setProperty("webdriver.gecko.driver", path + "//drivers//firefoxdriver.exe");
	WebDriver driver = new FirefoxDriver(); 
	driver.get("https://demoqa.com/automation-practice-form");
	driver.close();
	//driver.quit();
	
	
	
	}

}
