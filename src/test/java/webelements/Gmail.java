package webelements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Gmail {
	
	public static void main(String[] args) throws InterruptedException {
	String path = System.getProperty("user.dir");
	System.out.println("path of project"+path);
	System.setProperty("webdriver.chrome.driver", path + "//drivers//chromedriver.exe");
	WebDriver driver = new ChromeDriver(); 
//	System.setProperty("webdriver.gecko.driver", path + "//drivers//geckodriver.exe");
//	WebDriver driver = new FirefoxDriver(); 
	driver.get("https://www.google.com/intl/en-GB/gmail/about/");
	driver.manage().window().maximize();
	driver.findElement(By.linkText("Sign in")).click();
	driver.findElement(By.xpath("//input[@class='whsOnd zHQkBf' and @autocomplete='username']")).sendKeys("gunjantester6");
	Thread.sleep(10000);
	driver.findElement(By.xpath("//button[@class='VfPpkd-LgbsSe VfPpkd-LgbsSe-OWXEXe-k8QpJ VfPpkd-LgbsSe-OWXEXe-dgl2Hf nCP5yc AjY5Oe DuMIQc qfvgSe qIypjc TrZEUc lw1w4b']")).click();
	Thread.sleep(10000);
	driver.findElement(By.xpath("//input[@class='whsOnd zHQkBf' and @autocomplete='current-password']")).sendKeys("gunjantester");
	Thread.sleep(10000);
	driver.findElement(By.xpath("//button[@class='VfPpkd-LgbsSe VfPpkd-LgbsSe-OWXEXe-k8QpJ VfPpkd-LgbsSe-OWXEXe-dgl2Hf nCP5yc AjY5Oe DuMIQc qfvgSe qIypjc TrZEUc lw1w4b']")).click();
	
	
	
	}

}
