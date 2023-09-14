package practicepackage;

import org.testng.annotations.Test;

public class DataProviderOtherClassTest {

	@Test(dataProviderClass = StoringInDataProviderTest.class , dataProvider = "data",priority = 1)
	public void getData(String state,String capital) {
		System.out.println(state+"-------"+capital);
	}
	
	@Test(dataProviderClass = StoringInDataProviderTest.class , dataProvider = "data1",priority = 1)
	public void getData(String state,String capital,String famous) {
		System.out.println(state+"-------"+capital+"-----"+famous);
	}
	
	@Test
	public void print() {
		System.out.println("state"+"-------"+"capital"+"-------"+"Famous for");
	}
}