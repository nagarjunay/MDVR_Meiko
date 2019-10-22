package com.test.automation.FMSV12_Japan.excelReader;

/**
 * @author nagarjuna
 *
 */

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excel_Reader {

	public static Object[][] read_excel(String Sheet_Name) throws IOException {
		FileInputStream fis = new FileInputStream(
				"./src/main/java/com/test/automation/FMSV12_Japan/data/TestData.xlsx");
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheet = wb.getSheet(Sheet_Name);
		int row_num = sheet.getLastRowNum();
		int col_num = sheet.getRow(0).getLastCellNum();
		Object data[][] = new Object[row_num][col_num];
		for (int i = 0; i < row_num; i++) {
			for (int j = 0; j < col_num; j++) {
				data[i][j] = sheet.getRow(i + 1).getCell(j).toString();
			}
		}

		return data;

	}

}
