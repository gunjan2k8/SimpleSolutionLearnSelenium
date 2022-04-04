package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtils {
	
	public static Connection dbConn() throws ClassNotFoundException {
		//Connection URL Syntax: "jdbc:mysql://ipaddress:portnumber/db_name"		
	       String dbUrl = "jdbc:mysql://192.168.29.51:3306/employee";					


			//Database Username		
			String username = "root";	
	        
			//Database Password		
			String password = "gunjan";	
			
	 	    //Load mysql jdbc driver		
		   	  //  Class.forName("com.mysql.jdbc.Driver");	use it in old dependency	
		   	    Class.forName("com.mysql.cj.jdbc.Driver");			
		  
		    	Connection con= null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Connecting to Database...");
          //Create Connection to DB		
	    	con = DriverManager.getConnection(dbUrl,username,password);
            if (con != null) {
                System.out.println("Connected to the Database...");
            }
            
        } catch (SQLException ex) {
           ex.printStackTrace();
        }
        catch (ClassNotFoundException ex) {
           ex.printStackTrace();
        }
		return con;
}

}
