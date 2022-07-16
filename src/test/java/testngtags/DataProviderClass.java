package testngtags;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderClass {
	
	   @DataProvider(name="SearchProvider")
    public Object[][] getDataFromDataprovider(){
    return new Object[][] 
    	{
            { "gunjan", "pass1" },
            { "gunjan2", "pass2" },
            { "gunjan3", "pass3" }
        };

    }
	
	
	
	@Test(dataProvider="SearchProvider")
	public void cat(String username, String password) {
	
		System.out.println(username);
		System.out.println(password);

		
}

}
