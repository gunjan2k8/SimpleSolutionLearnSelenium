package webtable;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebTableClass2 {

	
	
	public static void main(String[] args) {
//		String path = System.getProperty("user.dir");
//		System.setProperty("webdriver.chrome.driver", path + "//drivers//chromedriver.exe");
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver(); 
		driver.get("https://money.rediff.com/gainers/bsc/daily/groupap");

        //No of Columns
        List<WebElement>  columns =  driver.findElements(By.xpath("//*[@id='leftcontainer']/table/thead/tr/th"));
        int columnCount = columns.size();
        System.out.println("No of columns in a table : " + columnCount);
        
        
        //No of Rows

        List<WebElement>  rows =  driver.findElements(By.xpath("//*[@id='leftcontainer']/table/tbody/tr/td[1]"));
       // List<WebElement>  rows =  driver.findElements(By.xpath("//*[@id=’leftcontainer’]/table/tbody/tr"));

        int rowCount = rows.size();
        System.out.println("No of rows in a table : " + rowCount);
        
//        Find the second row of a table
//        Find the table’s 2nd row and 2nd cell data.
        
        //To get 2nd row's 
        WebElement rowNo = driver.findElement(By.xpath("//*[@id=\'leftcontainer\']/table/tbody/tr[2]"));
        String rowvalue = rowNo.getText();
        System.out.println("row value is : "+rowvalue);
		
        
      //To get 2nd row's 2nd column data
        WebElement cellNo = driver.findElement(By.xpath("//*[@id=\'leftcontainer\']/table/tbody/tr[2]/td[2]"));
        String valueNo = cellNo.getText();
        System.out.println("Cell value is : "+valueNo);
        
        
        // click on second row link of 1st column
        String before_xpath = "//table/tbody/tr["; 
        String after_xpath = "]/td[1]";
        
        List<WebElement> rows1 = driver.findElements(By.xpath("//*[@id=\'leftcontainer\']/table/tbody/tr"));
        
        for (int i = 2; i <= rows1.size(); i++) {
        	String companyname = driver.findElement(By.xpath(before_xpath + i + after_xpath)).getText();
        	System.out.println(companyname);
        	// Now click the company name
        	if (companyname.contains("Nitin")) {
        	// click the link
        	driver.findElement(By.xpath("//tbody/tr[" + i + "]/td[1]/a")).click(); 
        	break;
        	}}
        
        
        
		//driver.close();
		}
	
}
