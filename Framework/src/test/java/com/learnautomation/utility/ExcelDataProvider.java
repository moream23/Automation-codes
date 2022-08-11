package com.learnautomation.utility;

import java.io.File;
import java.io.FileInputStream;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataProvider {
	//constructor
	XSSFWorkbook wb;
	public ExcelDataProvider() 
	{
	File src=new File("./Testdata/Testdata.xlsx");
	try {
		FileInputStream fis =new FileInputStream(src);
		 wb=new XSSFWorkbook(fis);
	} 
	catch (Exception e) {
		System.out.println("Unable to resd file"+e.getMessage());
	} 
   }
	// method overloading 
	public String getstringData(int sheetindex,int row,int colunm) 
	{
		return wb.getSheetAt(sheetindex).getRow(row).getCell(colunm).getStringCellValue();
	}
	public String getstringData(String sheetName,int row,int colunm) 
	{
		return wb.getSheet(sheetName).getRow(row).getCell(colunm).getStringCellValue();
	}
	public double getNumericData(String sheetName,int row,int colunm) 
	{
		return wb.getSheet(sheetName).getRow(row).getCell(colunm).getNumericCellValue();
	}
}

