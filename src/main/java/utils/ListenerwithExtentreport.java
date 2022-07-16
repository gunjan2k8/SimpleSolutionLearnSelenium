package utils;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ListenerwithExtentreport implements  ITestListener{
	
	 public static ExtentReports extentReports;
	 public static ExtentTest logger;
	 WebDriver driver = null;
	 private static Logger log = Logger.getLogger(ListenerwithExtentreport.class.getName());
	 
	
	public void onFinish(ITestContext context) {	
	    log.info("I am in onFinish method " + context.getName());
		extentReports.flush();
    }		

    public void onStart(ITestContext context) {	
    	DOMConfigurator.configure("log4j.xml");
    	 extentReports = new ExtentReports();
        ExtentSparkReporter reporter = new ExtentSparkReporter("./extent-reports/extent-report.html");
        reporter.config().setReportName(" Extent Report of automationexercise website");
        extentReports.attachReporter(reporter);
        extentReports.setSystemInfo("browser", "chrome");
        extentReports.setSystemInfo("system", "windows");
        extentReports.setSystemInfo("Author", "Gunjan");
        extentReports.setSystemInfo("Version", "1.1");
        System.out.println("i  am on start method");
        log.info("I am in onStart method " + context.getName());
        
        		
    }		
		

    public void onTestFailure(ITestResult result) {					
        log.info("I am in onTestFailure method " + result.getName());
        log.info("The name of the testcase failed is :" + result.getName());
        logger.log(Status.FAIL,MarkupHelper.createLabel(result.getName(),ExtentColor.RED));
        
        ITestContext context = result.getTestContext();
		WebDriver driver = (WebDriver) context.getAttribute("WebDriver");

        if(result.getStatus()==ITestResult.FAILURE)
        {
         TakesScreenshot ts=(TakesScreenshot)driver;
         File source=ts.getScreenshotAs(OutputType.FILE); // capture screenshot file
         File target=new File(System.getProperty("user.dir")+"/Screenshots/"+result.getName()+".png");
         
         try {
			FileUtils.copyFile(source,target);
		} catch (IOException e) {
			e.printStackTrace();
		}
         System.out.println("screenshot captured");
        }
        
        String screenshotPath=System.getProperty("user.dir")+"/Screenshots/"+result.getName()+".png";
        logger.addScreenCaptureFromPath(screenshotPath);
        logger.fail("Screenshot is attached"); 
        		
    }		

    public void onTestSkipped(ITestResult result) {					
    	 log.info("I am in onTestSkipped method " + result.getName());
         log.info("The name of the testcase skipped is :" + result.getName());   
         logger.log(Status.SKIP,MarkupHelper.createLabel(result.getName(),ExtentColor.ORANGE));
    }		

    public void onTestStart(ITestResult result) {					
    	  log.info("I am in onTestStart method " + result.getName());
          log.info("The name of the testcase start is :" + result.getName());
          logger=extentReports.createTest(result.getName()); 
    }		

    public void onTestSuccess(ITestResult result) {					
    	  log.info("I am in onTestSuccess method " + result.getName());
          log.info("The name of the testcase success is :" + result.getName());
        
          
          logger.log(Status.PASS,MarkupHelper.createLabel(result.getName(),ExtentColor.GREEN));
    }		
    
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {                  
        // TODO Auto-generated method stub              

    }  
    
    public void onTestFailedWithTimeout(ITestResult result) {
        onTestFailure(result);
      }

	
}
