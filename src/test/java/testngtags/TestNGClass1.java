package testngtags;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestNGClass1 {
	

	
//	@BeforeClass
//	public void defbeforeClass() {
//		
//		System.out.println("before class test method");
//	}
//	
//	@BeforeClass
//	public void abcbbeforeClass1() {
//		
//		System.out.println("before class test1 method");
//	}
//	
//	@AfterClass
//	public void defafterClass() {
//		
//		System.out.println("after class test method");
//	}
//	
//	@AfterClass
//	public void abcbafterClass1() {
//		
//		System.out.println("after class test1 method");
//	}
//	
//	
//	@BeforeMethod
//	public void beforeMethod() {
//		
//		System.out.println("before method test1 method");
//	}
	
	@BeforeTest
	public void beforeTest() {

		System.out.println("before test tag method");
		
	}
	
	@BeforeSuite
	public void beforeSuite() {

		System.out.println("before suite tag method");
		
	}
	

	
	@Test(priority=2,invocationCount=10)
	public void cat() {
	
		System.out.println("test1");
	}
	
	@Test(priority=-1)
	public void dog() {
	
		System.out.println("test2");
	}
	
	@Test
	public void deer() {
	
		System.out.println("test3");
	}
	
	
	@Test
	public void deer1() {
	
		Assert.assertTrue(true);
	}
	

}
