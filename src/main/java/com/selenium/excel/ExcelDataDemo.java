package com.selenium.excel;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataDemo {

	public static Map<String, Object> getData(String testCaseName) throws IOException {

		Map<String, Object> rowDataMap = new HashMap<>();

		// Read the excel file
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "/data/TestCase.xlsx");

		// Instantiate the workbook
		XSSFWorkbook workbook = new XSSFWorkbook(fis);

		// Get the total sheets count
		int noOfSheets = workbook.getNumberOfSheets();

		// loop all the sheets
		for (int i = 0; i < noOfSheets; i++) {
			XSSFSheet sheet = workbook.getSheetAt(i);

			Iterator<Row> rows = sheet.iterator();

			Row row = rows.next();

			Iterator<Cell> cells = row.cellIterator();
			
			while (rows.hasNext()) {
				Row r = rows.next();

				if (r.getCell(0).getStringCellValue().equalsIgnoreCase(testCaseName)) {
					Iterator<Cell> rCells = r.cellIterator();
					
					do {
						Cell cValue = rCells.next();
			
						if(cValue.getCellType() == CellType.STRING) 
							rowDataMap.put(cells.next().getStringCellValue(), cValue.getStringCellValue());
						else if(cValue.getCellType() == CellType.NUMERIC)
							rowDataMap.put(cells.next().getStringCellValue(), cValue.getNumericCellValue());
							
					} while (rCells.hasNext() && cells.hasNext());

					break;
				}
			}
		}
		
		return rowDataMap;
	}

	public static void main(String[] args) throws IOException {
			System.out.println(getData("Profile"));
	}

}
