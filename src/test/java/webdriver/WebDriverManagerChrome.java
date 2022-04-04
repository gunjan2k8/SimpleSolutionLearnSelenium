package webdriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebDriverManagerChrome {
	
	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().browserVersion("98.0").setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
	driver.get("https://demoqa.com/automation-practice-form");
	//driver.close();
	//driver.quit();
	
	}

}
