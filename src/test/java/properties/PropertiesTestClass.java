package properties;


import java.io.*;
import java.util.Properties;

public class PropertiesTestClass {


 public static void main(String args[]) throws IOException {

 String projectdir=System.getProperty("user.dir");

 //File fs = new File(projectdir+"/propfile.properties");
 File fs = new File(projectdir+"/Properties/newproperties.properties");
 FileInputStream is= new FileInputStream(fs);

 Properties prop = new Properties();
 prop.load(is);

 String url= prop.getProperty("urlname");
 System.out.println(url);
 

 String user= prop.getProperty("username");
 System.out.println(user);
 

 String pass= prop.getProperty("password");
 System.out.println(pass);



 }


}