package utils;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listeners implements  ITestListener{
	
	public void onFinish(ITestContext context) {					
        		
    }		

    public void onStart(ITestContext context) {					
        		
    }		
		

    public void onTestFailure(ITestResult result) {					
        System.out.println("The name of the testcase failed is :"+result.getName());
        		
    }		

    public void onTestSkipped(ITestResult result) {					
        System.out.println("The name of the testcase skipped is :"+result.getName());
        		
    }		

    public void onTestStart(ITestResult result) {					
        System.out.println(result.getName()+" test case started");					
        		
    }		

    public void onTestSuccess(ITestResult result) {					
        System.out.println("The name of the testcase success is :"+result.getName());
        		
    }		
	

}
