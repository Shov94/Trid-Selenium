package practicepackage;

import org.testng.annotations.Test;

import com.trid.GenericUtilities.BaseClass;

public class UserTestNGTest extends BaseClass {
	
	@Test
	public void createUser() {
		System.out.println("User Creaated");
	}

	@Test
	public void modifyUser() {
		System.out.println("User Modified");
	}
	
	@Test
	public void deleteUser() {
		System.out.println("User Deleted");
	}
}
