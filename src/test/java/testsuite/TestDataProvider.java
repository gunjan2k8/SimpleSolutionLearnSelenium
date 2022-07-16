package testsuite;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestDataProvider {
	
    
    @DataProvider(name = "passinguserdata")
    public Object[][] userdata(){
	 return new Object[][] {
		 {"andy.scotts127@yopmail.com","123@Test"},
		 {"gunjan2k8@gmail.com","Test@1234"},
		 {"gunjan2k8@gmail.com","Test@12345"}
		 };
    }
    
    

 
    
    @Test (dataProvider = "passinguserdata")
	public void login(String username,String password) throws InterruptedException{
		System.out.println(username);
		System.out.println(password);
		String path = System.getProperty("user.dir");
		System.out.println("path of project"+path);
		System.setProperty("webdriver.chrome.driver", path + "//drivers//chromedriver.exe");
		WebDriver driver = new ChromeDriver(); 
		driver.get("https://dev1-sgmsportal.cs165.force.com/s/login/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys(username);
        driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys(password);
        driver.findElement(By.xpath("//button[@class='slds-button slds-button--brand loginButton uiButton--none uiButton']")).click();
		String titlename=driver.getTitle();
		System.out.println("title name is "+titlename);
		//Assert.assertEquals(titlename,"HomeApplicantPage");
		driver.close();
		
		
	}
    
    ////////////////////////////////////////////////////////////////////////////
    
    
    @DataProvider(name = "passinguserdata1")
    public Object[][] userdata1(){
	 return new Object[][] {
		 {"gunjan","abc","abc@gmail.com","6545678641","abc address"},
		 {"alka","def","def@gmail.com","6545678642","def address"}
		 };
    }
    
    
    @Test (dataProvider = "passinguserdata1")
    public void userdata1(String firstName1, String lastName1,String userEmail1, String phone1, String address1 ){
    	
    	String URL = "https://demoqa.com/automation-practice-form";
    	String filePath=System.getProperty("user.dir");
        //set the Chrome Driver path        
        System.setProperty("webdriver.chrome.driver", filePath + "//drivers//chromedriver.exe");
        
        //Creating an object of ChromeDriver
        WebDriver driver = new ChromeDriver();
        
        //launching the specified URL
        driver.get("https://demoqa.com/automation-practice-form");
        driver.manage().timeouts().implicitlyWait(200, TimeUnit.SECONDS);
        
   

        driver.manage().window().maximize();

       
        	driver.navigate().refresh();
        	
            //Identify the WebElements for the student registration form
            WebElement firstName=driver.findElement(By.id("firstName"));
            WebElement lastName=driver.findElement(By.id("lastName"));
            WebElement email=driver.findElement(By.id("userEmail"));
            WebElement genderMale= driver.findElement(By.id("gender-radio-1"));
            WebElement mobile=driver.findElement(By.id("userNumber"));
            WebElement address=driver.findElement(By.id("currentAddress"));
            WebElement submitBtn=driver.findElement(By.xpath("//button[@id='submit']"));
            WebElement uploadPicture=driver.findElement(By.id("uploadPicture"));
        

        	
        	WebDriverWait wait = new WebDriverWait(driver,100);
        	firstName.sendKeys(firstName1);
                	lastName.sendKeys(lastName1);
        	        	email.sendKeys(userEmail1);
        	        	mobile.sendKeys(phone1);
        	        	address.sendKeys(address1);
        
        	//Click on the gender radio button using javascript
        	JavascriptExecutor js = (JavascriptExecutor) driver;

           // Thread.sleep(1000);
        	js.executeScript("arguments[0].click();", genderMale);
            uploadPicture.sendKeys("C:\\Users\\gunja\\Downloads\\User Acceptance Testing.pdf");
       
            //Thread.sleep(1000);
        	//Click on submit button
          wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@id='submit']"))); 
         	((JavascriptExecutor)driver).executeScript("arguments[0].click();", submitBtn);
         	
         	
        
        	//Verify the confirmation message
         	 wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='Thanks for submitting the form']")));
            WebElement confirmationMessage = driver.findElement(By.xpath("//div[text()='Thanks for submitting the form']"));
            
     

          
            
            //org.openqa.selenium.ElementNotInteractableException: element not interactable
            //solution
            //close the confirmation popup
            WebElement closebtn=driver.findElement(By.xpath("//button[@id='closeLargeModal']"));
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", closebtn);
            
            //wait for page to come back to registration page after close button is clicked
            driver.manage().timeouts().implicitlyWait(200, TimeUnit.SECONDS);
            
            
        
        //closing the driver
        driver.quit();
    	
    	
    }
    
	
	

}
