package testsuite;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestClass3 {
	
	
	@BeforeSuite
	public void beforeSuite() {
		System.out.println("beforeSuite  executed");
		
	}
	
	@BeforeTest
	public void beforeTest() {
		System.out.println("beforeTest  executed");
		
	}
	
	
	@AfterClass
	public void afterClass() {
		System.out.println("afterClass  executed");
		
	}
	
	@AfterMethod
	public void afterMethod() {
		System.out.println("afterMethod  executed");
		
	}
	

	@BeforeClass
	public void beforeClass() {
		System.out.println("beforeClass  executed");
		
	}
	
	@BeforeMethod
	public void beforeMethod() {
		System.out.println("beforeMethod  executed");
		
	}
	
	@Test
	public void login() {
		
		System.out.println("login  executed");
		
	}
	
	
	@Test(priority=2)
	public void addtocart() {
		
		System.out.println("addtocart executed");
		//Assert.fail("addtocart is failing");
		
	}
	
	@Test(dependsOnMethods="addtocart")
	public void payment() {
		
		System.out.println("payment executed");
		
	}
	
	@Test(dependsOnMethods="payment")
	public void checkout() {
		
		System.out.println("abc executed");
		
	}
	

}
