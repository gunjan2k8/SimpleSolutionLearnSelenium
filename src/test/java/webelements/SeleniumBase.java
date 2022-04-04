package webelements;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class SeleniumBase {
	
	public static void main(String[] args) {
	String path = System.getProperty("user.dir");
	System.out.println("path of project"+path);
	System.setProperty("webdriver.chrome.driver", path + "//drivers//chromedriver.exe");
	WebDriver driver = new ChromeDriver(); 
	driver.get("https://seleniumbase.io/demo_page");
	driver.manage().window().maximize();
	
	Boolean flag=driver.findElement(By.id("radioButton2")).isSelected();
	if(flag==true) {
		
		
	}
	else {
		
		driver.findElement(By.id("radioButton2")).click();
	}
	
	
	
	
	
	driver.findElement(By.id("checkBox2")).click();
	driver.findElement(By.id("checkBox3")).click();
	
	// drop down
	WebElement selctclass=driver.findElement(By.className("selectClass"));
	Select sel= new Select(selctclass);
	//sel.selectByVisibleText("Set to 75%");
	//sel.selectByValue("25%");
	sel.selectByIndex(1);
	
	
	String text=driver.findElement(By.id("pText")).getText();
	System.out.println(text);
	
	
	//driver.findElement(By.id("myLink1")).click();
	
List<WebElement> links=	driver.findElements(By.className("linkClass"));
for(WebElement link: links)
{
	System.out.println(link.getText());

}
	
	
	
	
	
	
	}

}
