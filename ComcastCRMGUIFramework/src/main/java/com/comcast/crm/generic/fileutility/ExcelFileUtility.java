
package com.comcast.crm.generic.fileutility;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelFileUtility {

	/*
	 * This method is used to get data from Excel file provided sheet name, row
	 * number, cell number
	 */
	public String getDataFromExcelFile(String sheetName, int rowNum, int cellNum) throws Exception {
		FileInputStream fInput = new FileInputStream("./testdata/TestscriptData.xlsx");
		Workbook wb = WorkbookFactory.create(fInput);
		String data = wb.getSheet(sheetName).getRow(rowNum).getCell(cellNum).getStringCellValue();
		wb.close();
		fInput.close();
		return data;
	}

	/*
	 * This method is used to write data back to the Excel file provided sheet name,
	 * row number, cell number and data
	 */
	public void setDataToExcel(String sheetName, int rowNum, int cellNum, String data) throws Exception {
		FileInputStream fInput = new FileInputStream("./testdata/TestscriptData.xlsx");
		Workbook wb = WorkbookFactory.create(fInput);
		wb.getSheet(sheetName).getRow(rowNum).createCell(cellNum).setCellValue(data);

		FileOutputStream fOut = new FileOutputStream("./testdata/TestscriptData.xlsx");
		wb.write(fOut);
		wb.close();
		fOut.close();
	}

	/*
	 * This method is used to get the count the number of row in the sheet provided
	 * sheet name
	 */
	public int getRowCount(String sheetName) throws Exception {
		FileInputStream fInput = new FileInputStream("./testdata/TestscriptData.xlsx");
		Workbook wb = WorkbookFactory.create(fInput);
		int rowNum = wb.getSheet(sheetName).getLastRowNum();
		wb.close();
		fInput.close();
		return rowNum;
	}
}
