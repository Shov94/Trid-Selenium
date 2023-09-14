package practicepackage;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.trid.GenericUtilities.IPathConstants;

public class DataProvider_ExcelTest {

	@Test(dataProvider = "dataFromExcel")
	public void fromExcel(String bookName,String authorName,String price) {

		System.out.println(bookName+"-----"+authorName+"-----"+price);
	}

	@DataProvider
	public Object[][] dataFromExcel() throws Throwable {
		FileInputStream fis=new FileInputStream(IPathConstants.excelPath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet("DataProvider");
		int lastRow = sh.getLastRowNum();
		int lastCell=sh.getRow(0).getLastCellNum();

		System.out.println(lastRow+"------"+lastCell);
		Object[][] obj=new Object [lastRow+1][lastCell]; 

		for(int i=0;i<=lastRow;i++) {
			for(int j=0;j<lastCell;j++) {

				obj[i][j]=sh.getRow(i).getCell(j).getStringCellValue();

			}
		}
		return obj;
	}

}
