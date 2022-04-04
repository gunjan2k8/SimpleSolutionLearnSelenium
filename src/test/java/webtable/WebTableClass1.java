package webtable;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class WebTableClass1 {
			
		public static void main(String[] args) {
		String path = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", path + "//drivers//chromedriver.exe");
		WebDriver driver = new ChromeDriver(); 
		driver.get("https://www.w3schools.com/html/html_tables.asp");
		// Method 1
		String before_xpath = "//table/tbody/tr["; 
		String after_xpath = "]/td[2]"; // 2nd column
	//	List rows = driver.findElements(By.xpath("//table/tbody/tr")); will fetch all columns on whole page
		List rows = driver.findElements(By.xpath("/html/body/div[7]/div[1]/div[1]/div[3]/div/table/tbody/tr"));
		int rowSize = rows.size();
		System.out.println(rowSize);
		for (int i = 2; i <= rowSize; i++) { // starting from 2nd row except header
		String firstNames = driver.findElement(By.xpath(before_xpath + i + after_xpath)).getText();
		System.out.println(firstNames);
	
		}
		
		driver.close();
		}

}

