package com.cigniti.guardant;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class XcelReader2 {

//	String path = "C:\\Users\\E003640\\Desktop\\PDFfilepath.xlsx";
	
	public List<String> readData(String path) throws IOException
	
	{
		FileInputStream fis = null;
		Workbook wb = null;
		
		Sheet s = null;
		Row r = null;
		Cell c = null;
		Cell c1 = null;
		
		List<String> excelVal = new ArrayList<String>();
		File f = new File(path);

		try {

			 fis = new FileInputStream(f);
		} catch (Exception e) {

		}

		try {
			 wb = WorkbookFactory.create(fis);			
			 
		} catch (EncryptedDocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		 s = wb.getSheetAt(0);
		 int rowCount = s.getLastRowNum();
		 
		 for(int i=1;i<rowCount+1;i++){
			 String rowValue = "";
			 r = s.getRow(i);
			 for (int j = 0; j < 3; j++) {//r.getLastCellNum()
				c =  r.getCell(j);
				String cellValue =c.getStringCellValue();
				rowValue = rowValue+cellValue+ "~";
			 }
				fis.close();
			 excelVal.add(rowValue);
		 }
		return excelVal;
	}
	
	
	
}
