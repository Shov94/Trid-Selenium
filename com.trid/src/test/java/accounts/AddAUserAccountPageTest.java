package accounts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.trid.GenericUtilities.BaseClass;
import com.trid.GenericUtilities.FileUtilities;
import com.trid.GenericUtilities.WebUtilities;

import io.github.bonigarcia.wdm.WebDriverManager;



public class AddAUserAccountPageTest extends BaseClass{

	public static void main(String[] args) throws Throwable {
		//DatabaseUtilities dblib=new DatabaseUtilities();
		//ExcelUtilities exLib=new ExcelUtilities();
		FileUtilities fLib=new FileUtilities();
		//JavaUtilities jLib= new JavaUtilities();
		WebUtilities wLib=new WebUtilities();
		
		
		/*FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\CommonData.properties");
		Properties p=new Properties();
		p.load(fis);
		String USERNAME = p.getProperty("username");
		String PASSWORD = p.getProperty("password");
		String URL = p.getProperty("url");
		String BROWSER=p.getProperty("browser");*/

		//Get data from property file
		String BROWSER=fLib.readDataFromPropertyFile("browser");
		String URL =fLib.readDataFromPropertyFile("url");
		String USERNAME =fLib.readDataFromPropertyFile("username");
		String PASSWORD =fLib.readDataFromPropertyFile("password");


		WebDriver driver;

		if(BROWSER.equalsIgnoreCase("Chrome")){
			
		    WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
			
		}
		else if(BROWSER.equalsIgnoreCase("firefox")) {
			
//			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
			
		}
		else {
			
//			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();	
			
		}
        wLib.maximizeBrowser(driver);
        
		driver.get(URL);
		
		wLib.pageLoadWait(driver, 50);
		
		//Enter the login credentials
		
		driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys(USERNAME);
		
		driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys(PASSWORD);
		
		driver.findElement(By.xpath("//button[text()='Login']")).click();
		
		wLib.alertAccept(driver);
		

		//Click on accounts link
		driver.findElement(By.linkText("Accounts")).click();
		
		driver.findElement(By.xpath("//i[@class='fas fa-fw fa-plus']")).click();
		
		driver.findElement(By.id("exampleModalLabel"));
		
		String actual=driver.findElement(By.xpath("//h5[text()='Add User Account']")).getAttribute("innerHTML");
		
		String popupmessage="Add User Account";
		
		if(actual.equalsIgnoreCase(popupmessage)) {
			
			System.out.println("Pop up is displayed");
		}
		
		else
			System.out.println("Not Displayed");
		
        driver.close();
	}

}
