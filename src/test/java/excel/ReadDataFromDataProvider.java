package excel;



import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import utils.ExcelDataProvider;

import java.io.IOException;
import java.time.Duration;
import java.util.Arrays;

public class ReadDataFromDataProvider {


         String filePath = System.getProperty("user.dir");
        
		WebDriver driver;
		
		@BeforeClass
		public void beforeClass() {
			
			System.setProperty("webdriver.chrome.driver", filePath + "//drivers//chromedriver.exe");
	    	driver = new ChromeDriver(); 
	    	driver.get("https://demoqa.com/automation-practice-form");
			
		}

    @DataProvider(name="testdata")
    public String[][] loginData() throws IOException {
        String[][] arrayObject = ExcelDataProvider.readExcel(filePath,"userdetails.xlsx","user");
//        for(String[] rc: arrayObject){  //using for each loop
//            System.out.println(Arrays.toString(rc));
//        }
        return arrayObject;
    }


    @Test(dataProvider="testdata")
    public void readData(String firstName1,String lastName1,String email1, String mobile1, String address1) throws IOException {
    	
    	int i=1;
    	
    	 WebElement firstName=driver.findElement(By.id("firstName"));
         WebElement lastName=driver.findElement(By.id("lastName"));
         WebElement email=driver.findElement(By.id("userEmail"));
         WebElement genderMale= driver.findElement(By.id("gender-radio-1"));
         WebElement mobile=driver.findElement(By.id("userNumber"));
         WebElement address=driver.findElement(By.id("currentAddress"));
         WebElement submitBtn=driver.findElement(By.xpath("//button[@id='submit']"));
         
         driver.manage().window().maximize();
         
         firstName.sendKeys(firstName1);
     	lastName.sendKeys(lastName1);
     	email.sendKeys(email1);
     	
     	//Click on the gender radio button using javascript
     	JavascriptExecutor js = (JavascriptExecutor) driver;
     	js.executeScript("arguments[0].click();", genderMale);
     	
     	mobile.sendKeys(mobile1);
     	address.sendKeys(address1);
     
     	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(120));
     	wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@id='submit']"))); 
     	((JavascriptExecutor)driver).executeScript("arguments[0].click();", submitBtn);
    
     	//Click on submit button
     	//submitBtn.click();
        WebElement confirmationMessage = driver.findElement(By.xpath("//div[text()='Thanks for submitting the form']"));

     	
     

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(120));
        
        //org.openqa.selenium.ElementNotInteractableException: element not interactable
        //solution
        //close the confirmation popup
        WebElement closebtn=driver.findElement(By.xpath("//button[@id='closeLargeModal']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", closebtn);
       // closebtn.click();
        
        
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(120));
         
         

    }
    
    
    
    
    

}