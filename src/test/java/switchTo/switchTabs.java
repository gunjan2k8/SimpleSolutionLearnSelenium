package switchTo;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.github.bonigarcia.wdm.WebDriverManager;

public class switchTabs {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriver driver;
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();        
        driver.get("https://demoqa.com/radio-button");
        String title = driver.getTitle();
        System.out.println("Title of URL::"+title); 
        driver.manage().window().maximize();
       
		List<String> tabs = new ArrayList<String>(driver.getWindowHandles());

    	//Set<String> windows=driver.getWindowHandles();// two tabs
    	driver.switchTo().window(tabs.get(0));

	}

}
