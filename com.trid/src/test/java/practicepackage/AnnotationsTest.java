package practicepackage;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class AnnotationsTest {

	@BeforeSuite
	public void databaseCon() {
	System.out.println("Database Connection");	
	}
	
	@BeforeClass
	public void openBrowser() {
	System.out.println("Open Browser");		
		
	}
	@BeforeMethod
	public void login() {
	System.out.println("Login to Application");		
		
	}
	@Test
	public void customer() {
		
	System.out.println("Test-1");	
	}
	
	@Test
	public void employee() {
		System.out.println("Test-2");
	}
	
	@AfterMethod
	public void logout() {
		
	System.out.println("Logout from Application");	
	}
	
	@AfterClass
	public void closeBrowser() {
	System.out.println("Close the Browser");	
		
	}
	
	@AfterSuite
	public void closeDatabase() {
	System.out.println("Close the Connection");
	}
}

