package com.qa.mercury.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;

import org.apache.commons.io.FileUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.qa.mercury.base.TestBase;

public class TestUtil extends TestBase{

	public static int PAGE_LOADTIMEOUT = 20;
	public static int IMPLICIT_TIMEOUT = 20;
	static String TESTDATA_FILE_PATH = "C:\\Users\\vishnu.vuppala\\eclipse-workspace\\mercurypackage\\src\\main\\java\\com\\qa\\mercury\\Testdata\\mercury.xlsx";
	static Workbook ws;
	Sheet sh;
	static Row row;
	static Cell cell;

	public static Object[][] readdata(String sheet) {
		File f = null;
		try {
			f = new File(TESTDATA_FILE_PATH);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		String extn = null;
		FileInputStream fis = null;
		try {
			String filename = f.getName();
			extn = filename.substring(filename.lastIndexOf("."));
			fis = new FileInputStream(f);
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		if (extn.equalsIgnoreCase(".xlsx")) {
			try {
				ws = new XSSFWorkbook(fis);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else if (extn.equalsIgnoreCase(".xls")) {
			try {
				ws = new HSSFWorkbook(fis);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		Sheet sh = ws.getSheet(sheet);

		int rowcount = sh.getLastRowNum();
		int colcount = sh.getRow(0).getLastCellNum();
		Object[][] obj = new Object[rowcount][1];
		
		for (int i = 0; i < rowcount; i++) {
			HashMap<Object, String> hs = new 	HashMap<Object, String>();
			row = sh.getRow(i + 1);
			for (int k = 0; k < colcount; k++) {
				cell = row.getCell(k);
				String key=sh.getRow(0).getCell(k).getStringCellValue();
				/*if (cell.getCellType() == CellType.STRING) {
					hs.put(key, cell.getStringCellValue());
				//	obj[i][k] = cell.getStringCellValue();
				} else if (cell.getCellType() == CellType.NUMERIC || cell.getCellType() == CellType.FORMULA) {
					hs.put(key, cell.getNumericCellValue());
					//obj[i][k] = (int) (cell.getNumericCellValue());
				} else if (cell.getCellType() == CellType.BLANK)
					hs.put(key, "");
					//obj[i][k] = "";
				else if (cell.getCellType() == CellType.BOOLEAN)
					hs.put(key, cell.getBooleanCellValue());
					//obj[i][k] = cell.getBooleanCellValue();
			}
			*/
				hs.put(key, cell.getStringCellValue());
			}
			obj[i][0]=hs;
		}
		return obj;
	}
	
	public static void takescreenshot() throws IOException
	{
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String workingpath=System.getProperty("user.dir");
		FileUtils.copyFile(src, new File(workingpath+"//screenshots//"+System.currentTimeMillis()+".png"));
	}
	
}