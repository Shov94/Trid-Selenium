package practicepackage;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.trid.GenericUtilities.ExcelUtilities;

public class DataProviderGenericTest {
	
	@Test(dataProvider ="dataGeneric" )
	public void dataFetch(String bookName,String authorName,String price) {
		System.out.println(bookName+"-----"+authorName+"-----"+price);
	}
	
	@DataProvider
	public Object[][] dataGeneric() throws Throwable {
		
		ExcelUtilities exLib=new ExcelUtilities();
		Object[][] value = exLib.readUsingDataProviderExcel("DataProvider");
		return value;
	}

}
