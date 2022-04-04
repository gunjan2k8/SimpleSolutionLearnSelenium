package webelements;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class RediffLogin {
	
	public static void main(String[] args) throws InterruptedException {
		
		
		String path = System.getProperty("user.dir");
		System.out.println("path of project"+path);
		System.setProperty("webdriver.chrome.driver", path + "//drivers//chromedriver.exe");
	//	WebDriverManager.chromedriver().browserVersion("98.0").setup();
		WebDriver driver = new ChromeDriver(); 
		driver.get("https://dev1-sgmsportal.cs165.force.com/s/login/");
		driver.manage().window().maximize();
		
		Thread.sleep(1000);
		
		driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("andy.scotts127@yopmail.com");
        driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("123@Test");
       driver.findElement(By.xpath("//button[@class='slds-button slds-button--brand loginButton uiButton--none uiButton']")).click();
		
		//driver.findElement(By.id("login1")).sendKeys("gunjan2k8@gmail.com");		
		//driver.findElement(By.name("login")).sendKeys("gunjan2k8@gmail.com");
		//driver.findElement(By.xpath("//input[@id='login1']")).sendKeys("gunjan2k8");
		//driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("gunjan2k8");
		
		//driver.findElement(By.cssSelector("input#login1")).sendKeys("gunjan2k8@gmail.com");

		//driver.findElement(By.id("password")).sendKeys("Test@1234");
		//driver.findElement(By.name("proceed")).click();
		//driver.findElement(By.className("donebtn")).click();
		//driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		String titlename=driver.getTitle();
		System.out.println("title name is "+titlename);
		
		
	}

}
