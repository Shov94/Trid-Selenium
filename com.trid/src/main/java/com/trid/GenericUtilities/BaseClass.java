package com.trid.GenericUtilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.trid.ObjectRepository.HomePage;
import com.trid.ObjectRepository.LoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	public DatabaseUtilities dblib=new DatabaseUtilities();
	public ExcelUtilities exLib=new ExcelUtilities();
	public FileUtilities fLib=new FileUtilities();
	public JavaUtilities jLib= new JavaUtilities();
	public WebUtilities wLib=new WebUtilities();

	public static  WebDriver driver;
	public static WebDriver edriver;


	@BeforeSuite(alwaysRun = true)
	public void databaseConfiguration() throws Throwable {

		dblib.connectToDatabase();
		System.out.println("Connect to the Database");
	}

	//@Parameters("Browser")
	@BeforeClass(alwaysRun = true)
	public void openBrowserConfig() throws Throwable {

		String Browser=fLib.readDataFromPropertyFile("browser");

		if(Browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();

		}
		else if(Browser.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		}
		else {
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
		}
		edriver=driver;
		System.out.println("Launching the Browser");
		wLib.maximizeBrowser(driver);
	}

	@BeforeMethod(alwaysRun = true)
	public void loginToApplication() throws Throwable {
		//	String USERNAME=fLib.readDataFromPropertyFile("username");
		//	String PASSWORD=fLib.readDataFromPropertyFile("password");
		String URL=fLib.readDataFromPropertyFile("url");
		driver.get(URL);
		wLib.pageLoadWait(driver, 10);

		LoginPage lp=new LoginPage(driver);
		lp.loginAsAdmin(driver);
		System.out.println("Login to the Application");

	}

	@AfterMethod(alwaysRun = true)
	public void logoutFromApplication() throws Throwable{
		
		HomePage hp=new HomePage(driver);
		Thread.sleep(2000);
		hp.logout(driver);
		System.out.println("Logout from the Application");
	}

	@AfterClass(alwaysRun = true)
	public void closeBrowser() throws Throwable {
		Thread.sleep(2000);
		driver.quit();
		System.out.println("Closing the browser");
	}

	@AfterSuite(alwaysRun = true)
	public void closeDatabase() throws Throwable {
		dblib.closeDb();
		System.out.println("Close the Database");
	}


}
