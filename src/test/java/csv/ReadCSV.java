package csv;


import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import java.io.FileReader;
import java.io.IOException;

public class ReadCSV {


public static void readCSV(String filePath) throws CsvValidationException, IOException {

	
	 	CSVReader csvReader=new CSVReader(new FileReader(filePath));
	    String[] csvCell;
        
        
	    while ((csvCell = csvReader.readNext()) != null) {
            String CustName = csvCell[0];
            String CustEmail = csvCell[1];
            String CustPassword = csvCell[2];
            String CustConfirmPassword = csvCell[3];
            System.out.println("customer name is"+CustName);
            System.out.println("customer email is"+CustEmail);
            System.out.println("customer password is"+CustPassword);
            System.out.println("customer confirm password is"+CustConfirmPassword);

    }}

    //Main function is calling readExcel function to read data from csv file

    public static void main(String args[]) throws IOException, CsvValidationException{

        String filePath = System.getProperty("user.dir");
        System.out.println(filePath);
        String CSV_PATH =filePath+"/Book1.csv";
        //Call read file method of the class to read data
        readCSV(CSV_PATH);

    }

}