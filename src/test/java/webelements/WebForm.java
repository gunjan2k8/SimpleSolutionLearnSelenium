package webelements;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebForm {
	
	
	public static void main(String[] args) throws InterruptedException {
	String path = System.getProperty("user.dir");
	//System.setProperty("webdriver.chrome.driver", path + "//drivers//chromedriver.exe");
	WebDriverManager.chromedriver().browserVersion("98.0").setup();
	WebDriver driver = new ChromeDriver(); 

	driver.get("https://demoqa.com/automation-practice-form");
	driver.manage().window().maximize();
	
	
	//firstname textbox
	WebElement firstNameTxtbox=driver.findElement(By.id("firstName"));
	firstNameTxtbox.sendKeys("gunjan");
	
	//lastname textbox
	WebElement lastNameTxtbox=driver.findElement(By.id("lastName"));
	lastNameTxtbox.sendKeys("agarwal");
	
	//email textbox
		WebElement emailTxtbox=driver.findElement(By.id("userEmail"));
		lastNameTxtbox.sendKeys("gunjan2k8@gmail.com");
	
	//checkbox
		WebElement femaleCheckbox=driver.findElement(By.xpath("//label[@for='gender-radio-2']"));
		femaleCheckbox.click();
		
		
		//mobile textbox
		WebElement mobileTxtbox=driver.findElement(By.id("userNumber"));
		mobileTxtbox.sendKeys("1234567890");	
	

	//select calender date . 12 july 1905
		
		WebElement selectCal=driver.findElement(By.id("dateOfBirthInput"));
		selectCal.click();
		WebElement selectMonth=driver.findElement(By.className("react-datepicker__month-select"));
		selectMonth.click();
		Select sel =new Select(selectMonth);
		sel.selectByValue("6"); // select july
//		sel.selectByVisibleText("July");
//		sel.selectByIndex(6);
		
		WebElement selectYear=driver.findElement(By.className("react-datepicker__year-select"));
		selectYear.click();
		Select sel1 =new Select(selectYear);
		sel1.selectByValue("1905"); // select 1905
//		sel1.selectByVisibleText("1905");
//		sel1.selectByIndex(5);
		
		
		// now selecting 12th date
		WebElement calDate=driver.findElement(By.xpath("//div[contains(@aria-label,'Choose Wednesday, July 12th, 1905')]"));
		calDate.click();
	

		//subject textbox where auto complete is ON
		//https://www.browserstack.com/guide/selenium-scroll-tutorial
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,350)", "");
		
		//https://www.browserstack.com/guide/wait-commands-in-selenium-webdriver
		//https://www.seleniumeasy.com/selenium-tutorials/waits-and-timeout-selenium-4
		//driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS); // in selenium 3.141
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30)); // in selenium 4

		WebElement subjectTxtbox=driver.findElement(By.id("subjectsContainer"));
		subjectTxtbox.click();
				
		WebElement subjectTxtbox2=driver.findElement(By.id("subjectsInput")); // it has input tag
		subjectTxtbox2.sendKeys("computer");
		
		WebDriverWait wait = new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Computer Science')]")));
		WebElement subjectComputerSc=driver.findElement(By.xpath("//div[contains(text(),'Computer Science')]"));
		subjectComputerSc.click();
	
		
	
		//checkbox hobbies reading click
		WebElement hobbiesCheckbox=driver.findElement(By.xpath("//label[@for='hobbies-checkbox-2']"));
		hobbiesCheckbox.click();
		
		

		//click on choose file
		//refer link https://www.softwaretestinghelp.com/file-upload-in-selenium/
		WebElement chooseFile=driver.findElement(By.xpath("//input[@id='uploadPicture']"));
		chooseFile.sendKeys("C:\\Users\\gunja\\OneDrive\\Desktop\\simpleSolution12\\image.jpg");
		
		
		//address textbox
		WebElement addressTxtbox=driver.findElement(By.id("currentAddress"));
		addressTxtbox.sendKeys("my adddess is india");
		
		// to close google ad at the bottom
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[starts-with(@id,'google_ad')]"))); 
		WebElement m= driver.findElement(By.xpath ("//*[local-name()='svg']/*[localname()='path' and @d='M0,0l15,0l0,15l-15,0Z']"));
	      // Action class to move and click element
	      Actions a = new Actions(driver);
	      a.moveToElement(m).
	      click().build().perform();
		//driver.findElement(By.id(locatorToCloseAd)).click(); //Close Ad
		driver.switchTo().defaultContent();
		
		// select state from dropdown
		WebElement selectState=driver.findElement(By.xpath("//div[contains(text(),'Select State')]"));
		js.executeScript("arguments[0].click();",selectState);
		//selectState.click();
		WebElement selectState2=driver.findElement(By.id("react-select-3-input"));
		js.executeScript("arguments[0].value='har';",selectState2);
		//selectState2.sendKeys("har");
		WebElement selectHaryana=driver.findElement(By.xpath("//div[contains(text(),'Haryana')]"));
		js.executeScript("arguments[0].click();",selectHaryana);
		//selectHaryana.click();
		
		// select city from dropdown
		WebElement selectCity=driver.findElement(By.xpath("//div[@class=' css-1wa3eu0-placeholder']"));
		js.executeScript("arguments[0].click();",selectCity);
		//selectCity.click();
		WebElement selectCity2=driver.findElement(By.id("react-select-4-input"));
		js.executeScript("arguments[0].value='kar';",selectCity2);
		selectCity2.sendKeys("kar");
		WebElement selectKarnal=driver.findElement(By.xpath("//div[contains(text(),'Karnal')]"));
		js.executeScript("arguments[0].click();",selectKarnal);
		//selectKarnal.click();
		
		// click on submit button
		WebElement submitButton=driver.findElement(By.xpath("//button[@id='submit']"));
	//	submitButton.click();
		// can click on submit button using JavaScriptExceutor
		js.executeScript("arguments[0].click();",submitButton);
		
		
	// verify thanks page open
		WebElement thanksText=driver.findElement(By.xpath("//div[@id='example-modal-sizes-title-lg']"));
		String thanks=thanksText.getText();
	if(thanks.equals("Thanks for submitting the form")) {
		
		System.out.println("form submitted");
		
	}
	else {
		
		System.out.println("form not submitted");
		
	}
	
	Thread.sleep(100); /// only to see the thanks form
	// click on close button using JavaScriptExceutor
	WebElement closeButton=driver.findElement(By.xpath("//button[@id='closeLargeModal']"));
	//submitButton.click();
	// can click on submit button using JavaScriptExceutor
	js.executeScript("arguments[0].click();",closeButton);
	
	
	
	//driver.close();
	//driver.quit();
	
	}
	

}
