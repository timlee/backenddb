package com.example.db;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class CreateXlsheet {
	
	public static void main(String[] args) throws IOException {
		
	
		XSSFWorkbook workbook=new XSSFWorkbook();
		XSSFSheet sheet=workbook.createSheet();
		XSSFRow row=sheet.createRow(0);
		XSSFCell cell=row.createCell(0);
		
		cell.setCellValue("test application");
		
		FileOutputStream fos=new FileOutputStream("D:\\f19\\excel\\sample.xlsx");
		workbook.write(fos);
		
		
	}

}
