package testngtags;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ParametrisationClass {
	
	
	
	
	@Test
	@Parameters({"user","pass"})
	public void cat(String username, String password) {
	
		System.out.println(username);
		System.out.println(password);

		
}
	
}
