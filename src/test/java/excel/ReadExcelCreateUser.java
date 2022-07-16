package excel;

import java.io.IOException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;
import utils.ExcelUtils;

public class ReadExcelCreateUser {
	
	public static final String URL = "https://demoqa.com/automation-practice-form";
    public static final  String filePath = System.getProperty("user.dir");
    public static final String testfile = "userdetails.xlsx";
    
    

  //creating object of ExcelUtils class
    static ExcelUtils excelUtils = new ExcelUtils();
    
    //using the Constants class values for excel file path 
    static String excelFilePath =filePath+"/"+testfile;

    public static  void main(String args[]) throws IOException, InterruptedException {
        //set the Chrome Driver path        
      //  System.setProperty("webdriver.chrome.driver", filePath + "//drivers//chromedriver.exe");
        WebDriverManager.chromedriver().setup();

        //Creating an object of ChromeDriver
        WebDriver driver = new ChromeDriver();
        
        
        //launching the specified URL
        driver.get("https://demoqa.com/automation-practice-form");
        driver.manage().timeouts().implicitlyWait(200, TimeUnit.SECONDS);
        
   
        
        //calling the ExcelUtils class method to initialise the workbook and sheet
        excelUtils.setFilePath(excelFilePath,"user");
        driver.manage().window().maximize();

        //iterate over all the row to print the data present in each cell.
        for(int i=1;i<excelUtils.getRowCount()+1;i++) 
        {   
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
        
        
        	//Enter the values read from Excel in firstname,lastname,mobile,email,address
        	System.out.println(excelUtils.getCellValue(i,0));
        	System.out.println(excelUtils.getCellValue(i,1));
        	
        	WebDriverWait wait = new WebDriverWait(driver,100);
         	//wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.id("firstName"))); 
        	firstName.sendKeys(excelUtils.getCellValue(i,0));
        	
        	//wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.id("lastName"))); 
        	lastName.sendKeys(excelUtils.getCellValue(i,1));
        	
        	//wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.id("userEmail")));
        	email.sendKeys(excelUtils.getCellValue(i,2));
        	
        	//wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.id("userNumber")));
        	mobile.sendKeys(excelUtils.getCellValue(i,3));
        	
        	//wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.id("currentAddress")));
        	address.sendKeys(excelUtils.getCellValue(i,4));
        
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
            
            //check if confirmation message is displayed
            if (confirmationMessage.isDisplayed()) {
            	// if the message is displayed , write PASS in the excel sheet using the method of ExcelUtils
            	excelUtils.setCellValue(i,5,"PASS",excelFilePath);
            } else {
                //if the message is not displayed , write FAIL in the excel sheet using the method of ExcelUtils
                excelUtils.setCellValue(i,5,"FAIL",excelFilePath);
            }

          
            
            //org.openqa.selenium.ElementNotInteractableException: element not interactable
            //solution
            //close the confirmation popup
            WebElement closebtn=driver.findElement(By.xpath("//button[@id='closeLargeModal']"));
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", closebtn);
            
            //wait for page to come back to registration page after close button is clicked
            driver.manage().timeouts().implicitlyWait(200, TimeUnit.SECONDS);
            
            
        }
        //closing the driver
        driver.quit();
    }
}
