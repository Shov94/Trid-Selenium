package practicepackage;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;


public class ExcelFileWrite {

	public static void main(String[] args) throws Throwable {
		FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\DATA.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		
		wb.getSheet("Sheet1").getRow(4).getCell(0).setCellValue("Beating the Street");
		wb.getSheet("Sheet1").getRow(4).getCell(1).setCellValue("Peter Lynch");
		FileOutputStream fos=new FileOutputStream(".\\src\\test\\resources\\DATA.xlsx");
		wb.write(fos);
		wb.close();
		
		
		

	}

}
