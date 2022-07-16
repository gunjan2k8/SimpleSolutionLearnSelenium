package webtable;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;


public class WebTableClass1 {
			
		public static void main(String[] args) {
//		String path = System.getProperty("user.dir");
//		System.setProperty("webdriver.chrome.driver", path + "//drivers//chromedriver.exe");
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver(); 
		driver.get("https://www.w3schools.com/html/html_tables.asp");
		
		String str=driver.findElement(By.xpath("//table[@id='customers']/tbody/tr[6]/td[2]")).getText();
		System.out.println("sixth row and second column value "+str);
		
		// Method 1
		String before_xpath = "//table[@id='customers']/tbody/tr["; 
		String after_xpath = "]/td[2]"; // 2nd column		
		List<WebElement> rows = driver.findElements(By.xpath("//table[@id='customers']/tbody/tr"));
		int rowSize = rows.size();
		System.out.println("number of rows "+rowSize);
		for (int i = 2; i <= rowSize; i++) { // starting from 2nd row except header
		String firstNames = driver.findElement(By.xpath(before_xpath + i + after_xpath)).getText();
		System.out.println(firstNames);
	
		}
		
		driver.close();
		}

}

