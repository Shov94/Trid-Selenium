package practicepackage;

import org.testng.annotations.DataProvider;

public class StoringInDataProviderTest {
	
	@DataProvider
	public Object[][] data() {
		
		Object[][] obj = new Object[2][2];
		obj[0][0]="Goa";
		obj[0][1]="Panaji";
		obj[1][0]="Telengana";
		obj[1][1]="Hyderabad";
		return obj;	
	}
	
	@DataProvider
	public Object[][] data1() {
		
		Object[][] obj = new Object[2][3];
		obj[0][0]="Odisha";
		obj[0][1]="Bhubaneswar";
		obj[0][2]="Temples";
		obj[1][0]="Karnataka";
		obj[1][1]="Bengaluru";
		obj[1][2]="Startups";
		return obj;	
	}

}
