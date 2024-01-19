package Util;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import pageObject.TestBase;

public class TestUtil extends TestBase{
	public static long PAGE_LOAD_TIMEOUT = 20;
	public static long IMPLICIT_WAIT = 6;
	
	public static Object[][] getTestData(String sheetName)
	{
		FileInputStream file=null;
		XSSFWorkbook workbook=null;
		
		try {
			file=new FileInputStream("src/main/java/testdata/controller.xlsx");
			workbook=new XSSFWorkbook(file);
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		
		Sheet sheet=workbook.getSheet(sheetName);
		int rowCount=sheet.getLastRowNum();
		int colCount=sheet.getRow(0).getLastCellNum();
		
		Object[][] data=new Object[rowCount][colCount];
		
		for(int i=1;i<=rowCount;i++)
		{
			Row row=sheet.getRow(i);
			for(int j=0;j<colCount;j++)
			{
				Cell cell=row.getCell(j);
				data[i-1][j]=cell.toString();
			}
		}
		
		try {
			file.close();
			workbook.close();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		
		return data;
	}

}
