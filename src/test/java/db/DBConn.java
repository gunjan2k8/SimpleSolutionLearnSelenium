package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConn {
	public static void  main(String[] args) throws ClassNotFoundException, SQLException {	
		
		//Connection URL Syntax: "jdbc:mysql://ipaddress:portnumber/db_name"		
      // String dbUrl = "jdbc:mysql://127.0.0.1:3036/employee";			
       String dbUrl = "jdbc:mysql://192.168.29.51:3306/mydatabase";					


		//Database Username		
		String username = "root";	
        
		//Database Password		
		String password = "gunjan";				

		//Query to Execute		
		//String query = "select * from empsal;";	
		
		String query = "select * from table1;";	

        
		//Loading class `com.mysql.jdbc.Driver'. This is deprecated.
		//The new driver class is `com.mysql.cj.jdbc.Driver'. The driver is automatically registered via the SPI and manual loading of the driver class is generally unnecessary.

 	    //Load mysql jdbc driver		
   	  //  Class.forName("com.mysql.jdbc.Driver");	use it in old dependency	
   	    Class.forName("com.mysql.cj.jdbc.Driver");			

   
   		//Create Connection to DB		
    	Connection con = DriverManager.getConnection(dbUrl,username,password);
  
  		//Create Statement Object		
	   Statement stmt = con.createStatement();					

			// Execute the SQL Query. Store results in ResultSet	
 		ResultSet rs= stmt.executeQuery(query);							
 
 		// While Loop to iterate through all data and print results		
		while (rs.next()){
	        		String name = rs.getString(2);								        
                    String salary = rs.getString(3);					                               
                    System. out.println(name+"  "+salary);		
            }		
			 // closing DB Connection		
			con.close();			
}

}
