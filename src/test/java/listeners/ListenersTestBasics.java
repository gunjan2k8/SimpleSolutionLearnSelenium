package listeners;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(utils.Listeners.class)

public class ListenersTestBasics {
	
	
	
	@Test
	public void testcase1() {
		
		Assert.fail();
		
	}
	

	@Test
	public void testcase2() {
		
		Assert.assertTrue(true);
		
	}


}
