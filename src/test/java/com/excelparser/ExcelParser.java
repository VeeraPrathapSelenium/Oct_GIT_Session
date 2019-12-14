package com.excelparser;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelParser {
	
	public static XSSFWorkbook workbook;
	
	public static String testCase;
	
	public void loadExcelFile() throws IOException
	{
		System.out.println("Loading Excel File ....");
				File f=new File("./TestData/TestData.xlsx");
				
				FileInputStream fis=new FileInputStream(f);
				
				workbook=new XSSFWorkbook(fis);
	   System.out.println("Excel File Loaded Sucessfully ....!!!!");
	}
	
	public int getRowCount(String sheet)
	{	System.out.println("Total Number Of Rows : "+workbook.getSheet(sheet).getLastRowNum());
		return workbook.getSheet(sheet).getLastRowNum()-1;
		
	}
	public int getColumnsCount(String sheet)
	{
		System.out.println("Total Number Of Columns : "+workbook.getSheet(sheet).getRow(0).getLastCellNum());
		return workbook.getSheet(sheet).getRow(0).getLastCellNum()-1;
	}
	public int SearchTestCase(String sheetName,String testCaseName)
	{
		int rowfound=0;
		int totalRows= getRowCount(sheetName);
		
		for(int r=1;r<=totalRows;r++)
		{
			
			String crntTestCase=workbook.getSheet(sheetName).getRow(r).getCell(0).getStringCellValue();
			
			if(testCaseName.trim().equals(crntTestCase))
			{
				System.out.println("The Test Case : "+testCaseName+" is found at row number "+r);
				rowfound=r;
				break;
			}
			
		}
		
		
		if((rowfound==0))
		{
			System.out.println("The Test Case : "+testCaseName+ " is not found under the sheet "+ sheetName);
		}
		
		return rowfound;
	}
	
	public int SearchColumn(String sheetName,String column)
	{
		int colfound=0;
		int totalCols= getColumnsCount(sheetName);
		
		for(int c=1;c<=totalCols;c++)
		{
			
			String crntColumnName=workbook.getSheet(sheetName).getRow(0).getCell(c).getStringCellValue();
			
			if(crntColumnName.trim().equals(column))
			{
				System.out.println("The Coulumn : "+crntColumnName+" is found at Column number "+c);
				colfound=c;
				break;
			}
			
		}
		
		
		if((colfound==0))
		{
			System.out.println("The Column : "+colfound+ " is not found under the sheet "+ sheetName);
		}
		
		return colfound;
	}	
	
	
	
	public String getData(String sheetName,String column)
	{
		int row=SearchTestCase(sheetName,testCase);
		
		int col=SearchColumn(sheetName, column);
		
		String data="";
		if(row!=0 && col!=0)
		{
			switch (workbook.getSheet(sheetName).getRow(row).getCell(col).getCellTypeEnum()) {
			case STRING:
				data=workbook.getSheet(sheetName).getRow(row).getCell(col).getStringCellValue();
				break;
				
			case NUMERIC:
				data=String.valueOf(workbook.getSheet(sheetName).getRow(row).getCell(col).getNumericCellValue());
				break;

			default:
				break;
			}
		}
		
		if(data.isEmpty())
		{
			System.out.println("No Test Data Found for the Test case :"+testCase);
		}
		
		return data;
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
