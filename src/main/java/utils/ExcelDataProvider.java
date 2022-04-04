package utils;


import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;

public class ExcelDataProvider {

    static Workbook workbook = null;
    static Sheet sheet=null;

	

    public static String[][] readExcel(String filePath,String fileName,String sheetName) throws IOException {

        //Create an object of File class to open xlsx file

        File file =    new File(filePath+"/"+fileName);
        System.out.println(file);
        String [][] logindata = null;

        //Create an object of FileInputStream class to read excel file

        FileInputStream inputStream = new FileInputStream(file);

    

        //Find the file extension by splitting file name in substring  and getting only extension name

        String fileExtensionName = fileName.substring(fileName.indexOf("."));

        //Check condition if the file is xlsx file

        if(fileExtensionName.equals(".xlsx")){

            //If it is xlsx file then create object of XSSFWorkbook class
        	// maven dependency poi-ooxml

            workbook = new XSSFWorkbook(inputStream);

        }

        //Check condition if the file is xls file

        else if(fileExtensionName.equals(".xls")){

            //If it is xls file then create object of HSSFWorkbook class
          	// maven dependency poi
            workbook = new HSSFWorkbook(inputStream);

        }

        //Read sheet inside the workbook by its name

         sheet = workbook.getSheet(sheetName);

        //Find number of rows in excel file

      int rowCount = sheet.getLastRowNum()-sheet.getFirstRowNum();// 5-1=4

        //Create a loop over all the rows of excel file to read it
        logindata=new String[rowCount][sheet.getRow(1).getLastCellNum()]; // Object[4][2]

        for (int i = 1; i <rowCount+1; i++) { // rowcount+1=4+1=5 ;1<5 (1,2,3,4 except header row)

            Row row = sheet.getRow(i);

            //Create a loop to print cell values in a row

            for (int j = 0; j <row.getLastCellNum(); j++) { // 0<2

                //Print Excel data in console

               // System.out.print(row.getCell(j).getStringCellValue()+"|| ");

                // Fetch first row username
            	
            	DataFormatter formatter = new DataFormatter();
            	logindata[i-1][j] = formatter.formatCellValue(row.getCell(j));
            	
               // logindata[i-1][j]=row.getCell(j).getStringCellValue();
                System.out.print(logindata[i-1][j]+"||");
                // Fetch first row password
               // logindata[i][1]=row.getCell(i,j).getStringCellValue();

            }

            System.out.println();
        }


        return logindata;

    }
    
    public static void setCellValue(int rowNum,int cellNum,String cellValue,String filePath,String fileName,String sheetName) throws IOException {
        //Create an object of File class to open xlsx file

    	  String excelFilePath=filePath+"/"+fileName;
        File file =    new File(excelFilePath);
        System.out.println(file);
        
      
      

        //Create an object of FileInputStream class to read excel file

        FileInputStream inputStream = new FileInputStream(file);

        Workbook workbook = null;

        //Find the file extension by splitting file name in substring  and getting only extension name

        String fileExtensionName = fileName.substring(fileName.indexOf("."));

        //Check condition if the file is xlsx file

        if(fileExtensionName.equals(".xlsx")){

            //If it is xlsx file then create object of XSSFWorkbook class
        	// maven dependency poi-ooxml

            workbook = new XSSFWorkbook(inputStream);

        }

        //Check condition if the file is xls file

        else if(fileExtensionName.equals(".xls")){

            //If it is xls file then create object of HSSFWorkbook class
          	// maven dependency poi
            workbook = new HSSFWorkbook(inputStream);

        }

        //Read sheet inside the workbook by its name

        Sheet sheet = workbook.getSheet(sheetName);

    	
    	//creating a new cell in row and setting value to it      
    	sheet.getRow(rowNum).createCell(cellNum).setCellValue(cellValue);
        
    	FileOutputStream outputStream = new FileOutputStream(excelFilePath);
    	workbook.write(outputStream);
    }



}