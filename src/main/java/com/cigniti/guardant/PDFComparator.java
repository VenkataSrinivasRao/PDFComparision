package com.cigniti.guardant;

import java.io.File;

import de.redsix.pdfcompare.PdfComparator;

public class PDFComparator {
	boolean isEquals = false;
	
	String file1 = System.getProperty("user.dir")+File.separator+"test data"+ File.separator+ "final report" + File.separator;//+ "A80160_FINAL_report.pdf"
	String file2 = System.getProperty("user.dir")+File.separator+"test data"+ File.separator+ "old report" + File.separator;//+ "A80160_OLD_report.pdf"
	String file3 = System.getProperty("user.dir")+File.separator+"differences pdf folder"+ File.separator;//+ "A80160_Differencies"

	
	public boolean comparePDF(String inputFile1, String inputFile2, String outputFile) throws Exception {
		
		isEquals = new PdfComparator(file1+inputFile1, file2+inputFile2).compare().writeTo(file3+outputFile);

		return isEquals;
	}
	

}
