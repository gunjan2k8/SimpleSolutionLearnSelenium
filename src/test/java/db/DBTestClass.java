package db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.annotations.Test;

import utils.DBUtils;

public class DBTestClass {
	
	DBUtils db = new DBUtils();
	
	@Test
    public void getEmployeesFromDataBase() throws ClassNotFoundException, SQLException {
		Connection con=db.dbConn();
        try {
    		String query = "select * from empsal;";	
    		
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
        } catch (SQLException ex) {
           ex.printStackTrace();
        }
        // closing DB Connection		
		con.close();	
    }

}
