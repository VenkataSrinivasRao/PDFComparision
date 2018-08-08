package com.cigniti.guardant.pdfcompare;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPageTree;
import org.apache.pdfbox.text.PDFTextStripper;

public class TextPdfBox {

	public static void main(String[] args) throws Exception {

		String file1 = "C:\\Users\\E003640\\Desktop\\Result\\A80160_FINAL_report.pdf";

		String file2 = "C:\\Users\\E003640\\Desktop\\Result\\A80160_OLD_report.pdf";

		String file3 = "C:\\Users\\E003640\\Desktop\\Result\\A80160_Differencies_pdf";

		File pdfdoc1 = new File(file1);
		File pdfdoc2 = new File(file1);
		File pdfdoc3 = new File(file1);

		PDDocument doc = PDDocument.load(pdfdoc1);
		PDDocument doc2 = PDDocument.load(pdfdoc2);

		System.out.println(doc);

		@SuppressWarnings("rawtypes")
		PDPageTree list =  doc.getDocumentCatalog().getPages();
		@SuppressWarnings("rawtypes")
		PDPageTree list2 = doc2.getDocumentCatalog().getPages();

		PDFTextStripper stripper = new PDFTextStripper();
		PDFTextStripper stripper2 = new PDFTextStripper();

		String pages = null;
		String pages2 = null;

		System.out.println("list1 size : " + list.getCount());
		System.out.println("list2 size : " + list2.getCount());

		if (list.getCount() == list2.getCount()) {

			for (int i = 1; i <= list.getCount(); i++) {
				stripper.setStartPage(i);
				stripper.setEndPage(i);

				stripper2.setStartPage(i);
				stripper2.setEndPage(i);

				// System.out.println("-----------"+stripper.getEndPage());

				pages = stripper.getText(doc);
				pages2 = stripper2.getText(doc2);

				String lines[] = pages.split("\\r?\\n");
				String lines2[] = pages2.split("\\r?\\n");

				System.out.println("Line in first page : " + lines.length);
				System.out.println("Line in second page : " + lines2.length);

				if (lines.length == lines2.length) {

					for (int a = 0; a < lines.length; a++) {
						// System.out.println(lines[a]);
						// System.out.println("************----------**********");
						String cols[] = lines[a].split("\\s+");
						String cols2[] = lines2[a].split("\\s+");
						if (cols.length == cols2.length) {
							for (int b = 0; b < cols.length; b++) {
								 System.out.println(cols[b].toString()+" - - - - "+cols2[b].toString());
								 System.out.println("Page : "+i+" Row : "+a+" Column : "+b);
								if (!cols[b].toString().equalsIgnoreCase(cols2[b].toString())) {
									System.out.println("Not matched : " + cols2[b].toString());
									 System.out.println("Page : "+i+" Row : "+a+" Column : "+b);
								}

							}
						} else {
							System.out.println("column are not equals");
						}
					}
					System.out.println("******");
				} else {
					System.out.println("Line are not equal ");
				}

			}
		} else {
			System.out.println("Page size is not equal");
		}

		doc.close();

	}

}
