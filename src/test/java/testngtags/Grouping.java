package testngtags;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Grouping {
	
	
	@Test(groups={"sanity"})
	public void test1() {
        Reporter.log("sanity test case executed",true); //true will show in console 

		System.out.println("test1");
	}
	
	@Test(groups={"smoke","sanity"})
public void test2() {
        Reporter.log("sanity and smoke test case executed");

		System.out.println("test2");
		String test="testing";
		String test1="testing1";
		test.equals(test1); // not shown as failure in testng reporting
	
		Assert.assertEquals(test,test1);
	}
	
	//soft assertion
	
    @Test
    	public void softAssertion(){
	SoftAssert softAssertion= new SoftAssert();
	System.out.println("softAssert");
	softAssertion.assertTrue(false);
	softAssertion.assertTrue(true);
    softAssertion.assertAll(); 
	
}

	

}
