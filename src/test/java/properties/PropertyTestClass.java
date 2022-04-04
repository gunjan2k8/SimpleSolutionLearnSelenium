package properties;

import org.testng.annotations.Test;
import utils.PropertyUtils;
import java.io.File;

public class PropertyTestClass {

 String projectdir=System.getProperty("user.dir");

 File fs = new File(projectdir+"/propfile.properties");
 PropertyUtils pu = new PropertyUtils();

 @Test
 public void test() throws Exception {

 pu.setPropertyFile(projectdir+"/propfile.properties");
 String url=pu.gettingValueOfProperty("url");
 System.out.println(url);
 String username=pu.gettingValueOfProperty("username");
 System.out.println(username);
 String password=pu.gettingValueOfProperty("password");
 System.out.println(password);

 }


}