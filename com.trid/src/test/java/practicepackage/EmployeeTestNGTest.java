package practicepackage;

import org.testng.annotations.Test;

import com.trid.GenericUtilities.BaseClass;

public class EmployeeTestNGTest extends BaseClass {
	
	@Test
	public void createEmployee() {
		
		System.out.println("Employee created---4");
	}

	@Test
	public void modifyEmployee() {
		
		System.out.println("Employee Modified---5");
	}
	
	@Test
	public void deleteEmployee () {
		
		System.out.println("Employee Deleted");
	}
}
