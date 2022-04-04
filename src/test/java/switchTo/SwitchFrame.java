package switchTo;

import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SwitchFrame {
	//https://blog.testproject.io/2020/06/18/selenium-switch-methods-chapter-5/
	
	public static void main(String[] args) throws InterruptedException {
	String path = System.getProperty("user.dir");
	System.out.println("path of project"+path);
	System.setProperty("webdriver.chrome.driver", path + "//drivers//chromedriver.exe");
	WebDriver driver = new ChromeDriver(); 
	driver.get("https://demoqa.com/alerts");
	driver.manage().window().maximize();
	
	//alert 
	
	driver.findElement(By.id("alertButton")).click();
	driver.switchTo().alert().accept(); // ok button
	
	driver.findElement(By.id("confirmButton")).click();
	driver.switchTo().alert().dismiss(); // click on cancel
	
	driver.findElement(By.id("promtButton")).click();
	Alert passed=driver.switchTo().alert();
	passed.sendKeys("gunjan");
	passed.accept();
	
	
	//switch to window
	
	JavascriptExecutor js= (JavascriptExecutor)driver;
	js.executeScript("window.scrollBy(0,250)", "");
	
	
	driver.findElement(By.xpath("//span[normalize-space()='Browser Windows']")).click();
	
	String currentwindow=driver.getWindowHandle(); //https://demoqa.com/browser-windows
	Thread.sleep(1000);
	driver.findElement(By.id("windowButton")).click();
	
	Set<String> windows=driver.getWindowHandles();// two browsers
	for(String window:windows) {
		//String title=null;
		if(!window.contains(currentwindow)) {
	driver.switchTo().window(window);
	System.out.println("i am on new window");
	Thread.sleep(1000);
		System.out.println(driver.getCurrentUrl());
		
		}
	
	}
	
	}
		
		
		
}
