package com.cigniti.guardant.pdfcompare;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.cigniti.guardant.PDFComparator;
import com.cigniti.guardant.XcelReader;
import com.cigniti.guardant.XcelWriter;

public class PdfComparision {

	// String file1 = System.getProperty("user.dir")+File.separator+"test data"+
	// File.separator+ "final report" + File.separator;//+
	// "A80160_FINAL_report.pdf"
	// String file2 = System.getProperty("user.dir")+File.separator+"test data"+
	// File.separator+ "old report" + File.separator;//+ "A80160_OLD_report.pdf"
	// String file3 = System.getProperty("user.dir")+File.separator+"differences
	// pdf folder"+ File.separator;//+ "A80160_Differencies"
	//
	//

	String path = "C:\\Users\\E003640\\Desktop\\PDFfilepath.xlsx";

	@Test
	public void testPDFComparision() throws Exception {

		XcelReader xr = new XcelReader();
		XcelWriter xr1 = new XcelWriter();
		Map<String,Boolean> mapFinal = new HashMap<String,Boolean>();
		List<String> excelValues = xr.readData(path);
		List<String> excelVal2 = excelValues;

		for (int i = 0; i < excelValues.size(); i++) {

			String[] col1DatatArray = excelValues.get(i).split("~");
			boolean flag = new PDFComparator().comparePDF(col1DatatArray[0], col1DatatArray[1], col1DatatArray[2]);
			System.out.println(flag);
			System.out.println("completed !");

			mapFinal.put(col1DatatArray[0], flag);
			if (!flag) {
				System.out.println("Differences found! in PDF files " + col1DatatArray[0] + "," + col1DatatArray[1]
						+ ", Please refer the file " + col1DatatArray[2]);
			} else {
				System.out.println("Similar PDF files    " + col1DatatArray[0] + ",   " + col1DatatArray[1]);
			}

		}
		
		xr = null;
		
		System.out.println(mapFinal.toString());
			xr1.writeData(path, mapFinal, mapFinal.size());
		
//		}

	}

}
