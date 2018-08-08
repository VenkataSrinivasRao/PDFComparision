package com.cigniti.guardant;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Map;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class XcelWriter2 {

	
	public void writeData(String path, Map<String,Boolean> map,int listSize) throws IOException, InvalidFormatException{
		
		
		FileInputStream fis = null;
		FileOutputStream fos = null;
//		Workbook wb = null;
		XSSFWorkbook wb = null;
		
		XSSFSheet s = null;
		XSSFRow r = null;
		XSSFCell c = null;
		XSSFCell c1 = null;
		
		
		
		File f = new File(path);
		
		try {

			 fis = new FileInputStream(f);
		} catch (Exception e) {

		}
		
		try {
			fos = new FileOutputStream(f);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		 try {
			wb = new XSSFWorkbook(fis);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 s = wb.getSheetAt(0);
//		 int rowCount = s.getLastRowNum();
		
		 for(int i=1;i<listSize+1;i++){
//			 String rowValue = "";
			 r = s.getRow(i);
//			 for (int j = 0; j < 3; j++) {//r.getLastCellNum()
				c =  r.getCell(0);
				String cellValue =c.getStringCellValue();
				r.createCell(3).setCellValue(map.get(cellValue));
		 }
				
		
				wb.write(fos);
				fos.close();
				
				
//				rowValue = rowValue+cellValue+ "~";
//			 }
				
//			 excelVal.add(rowValue);
//		 }
		 
		
	}
	
}
