package com.qa.AutomatedTesting2;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Row.MissingCellPolicy;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {
	private static XSSFSheet ExcelWSheet;
	private static XSSFWorkbook ExcelWBook;
	private static XSSFCell Cell;
	private static XSSFRow Row;
	
	public static void setExcelFile() {
		
		try {
			String Path = Constants.Path_TestData + Constants.File_TestData;
			FileInputStream ExcelFile= new FileInputStream(Path);
			System.out.println(Path);
			ExcelWBook = new XSSFWorkbook(ExcelFile);
			ExcelWSheet = ExcelWBook.getSheetAt(0);
		}
		catch(Exception e){
			e.printStackTrace();
		}}
		
	public static XSSFSheet getExcelWSheet() {
			return ExcelWSheet;
		}

	public static String getCellData(int rownum, int colnum) {
		try {
		Cell = ExcelWSheet.getRow(rownum).getCell(colnum);
		String CellData = Cell.getStringCellValue();
		return CellData;
		}
		catch(Exception e) {
			e.printStackTrace();
			return "";
		}
	}
		public static void setCellData(String result, int number1, int number2) {
			try {
				Row = ExcelWSheet.getRow(number1);
				Cell = Row.getCell(number2, MissingCellPolicy.RETURN_BLANK_AS_NULL);
				if(Cell == null) {
					Cell = Row.createCell(number2);
					Cell.setCellValue(result);
				}
				else {
					Cell.setCellValue(result);
				}
				FileOutputStream fileout = new FileOutputStream(Constants.Path_TestData + Constants.File_TestData);
				ExcelWBook.write(fileout);
				fileout.flush();
				fileout.close();	
			}
			catch(Exception e){
				e.printStackTrace();
			}
			
			
		}
}

