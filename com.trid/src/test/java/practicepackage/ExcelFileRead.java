package practicepackage;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;


public class ExcelFileRead {

	public static void main(String[] args) throws Throwable {
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\DATA.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sheet = wb.getSheet("Product");
		int num = sheet.getLastRowNum();
		
		for(int i=0;i<=num;i++) {
			for(int j=0;j<=2;j++) {
		Row row = sheet.getRow(i);
		Cell cell = row.getCell(j);
		String value = cell.getStringCellValue();
		System.out.print(value+"        ");

			}
			System.out.println();
		}
	
		
		

	}

}
