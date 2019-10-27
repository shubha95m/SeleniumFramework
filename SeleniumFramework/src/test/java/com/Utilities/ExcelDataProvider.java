package com.Utilities;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataProvider  {
	
//	XSSFWorkbook wb;
//	
//	public void ExcelDataProvider () {
//		
//		File src = new File("./TestData/DataProvider.xlsx");
//		
//		FileInputStream fis;
//		
//		try {
//			fis = new FileInputStream(src);
//			
//			wb = new XSSFWorkbook(fis);
//			
//		} catch (Exception e) {
//			System.out.println("unable to read excel file: " +e.getMessage());
//		}
//		
//	}

	
//	public String getStringData(String sheetName, int row, int column) {
//		
//		return wb.getSheet(sheetName).getRow(row).getCell(column).getStringCellValue();
//		
//	}
//	
//	public String getStringData(int sheetIndex, int row, int column) {
//		
//		return wb.getSheetAt(sheetIndex).getRow(row).getCell(column).getStringCellValue();
//		
//	}
//	
//	public double getIntegerData(String sheetName, int row, int column) {
//		
//		return wb.getSheet(sheetName).getRow(row).getCell(column).getNumericCellValue();
//		
//	}
	
XSSFWorkbook wb;
	
	public ExcelDataProvider() {
	
		try {
			wb=new XSSFWorkbook(new FileInputStream(new File(System.getProperty("user.dir")+"/TestData/DataProvider.xlsx")));
		}catch (Exception e) {
			
			System.out.println("Unable to read Excel Data "+e.getMessage());
		}
		
	}
	
	public String getCellData(String sheetName,int row, int col)
	{
		XSSFCell cell=wb.getSheet(sheetName).getRow(row).getCell(col);
		
		String data=null;
		
		if(cell.getCellTypeEnum()==CellType.STRING)
		{
			data=cell.getStringCellValue();
		}
		else if(cell.getCellTypeEnum()==CellType.NUMERIC)
		{
			data= String.valueOf((int)cell.getNumericCellValue());
		}
		else if(cell.getCellTypeEnum()==CellType.BLANK)
		{
			data="";
		}
		return data;
	}
	
	
	public int getRows(String sheetName)
	{
			return wb.getSheet(sheetName).getPhysicalNumberOfRows();
	}
	

	public int getColumns(String sheetName)
	{
			return wb.getSheet(sheetName).getRow(0).getPhysicalNumberOfCells();
	}

}
