package practicepackage;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderTest {
	
	
	@Test(dataProvider = "data")
	public void getData(String state,String capital) {
		
		System.out.println(state+"----------"+capital);
	}
	@DataProvider
	public Object[][] data() {
		
		Object[][] obj = new Object[2][2];
		obj[0][0]="Goa";
		obj[0][1]="Panaji";
		obj[1][0]="Bihar";
		obj[1][1]="Patna";
		return obj;	
	}
	
	
	
	
	
	
	
	
	
}
