package properties;


import java.io.*;
import java.util.Properties;

public class PropertiesTestClass {


 public static void main(String args[]) throws IOException {

 String projectdir=System.getProperty("user.dir");

 File fs = new File(projectdir+"/propfile.properties");

 FileInputStream is= new FileInputStream(fs);

 Properties prop = new Properties();
 prop.load(is);

 String url= prop.getProperty("url");
 System.out.println(url);



 }


}