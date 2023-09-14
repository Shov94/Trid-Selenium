package suppliers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.trid.GenericUtilities.FileUtilities;
import com.trid.GenericUtilities.WebUtilities;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ViewSuppliersListTest {

	public static void main(String[] args) throws Throwable {
		//ExcelUtilities exLib=new ExcelUtilities();
		FileUtilities fLib=new FileUtilities();
		//JavaUtilities jLib= new JavaUtilities();
		WebUtilities wLib=new WebUtilities();



		//Get data from property file
		/*FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\CommonData.properties");
		Properties p=new Properties();
		p.load(fis);
		String USERNAME = p.getProperty("username");
		String PASSWORD = p.getProperty("password");
		String URL = p.getProperty("url");
		String BROWSER=p.getProperty("browser");

		 */
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
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		}
		else {
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();		
		}


		wLib.maximizeBrowser(driver);
		driver.get(URL);
		wLib.pageLoadWait(driver, 10);;
		//Enter the login credentials
		driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys(USERNAME);
		driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys(PASSWORD);
		driver.findElement(By.xpath("//button[text()='Login']")).click();
		wLib.alertAccept(driver);

		//Click on Suppliers link
		driver.findElement(By.linkText("Supplier")).click();
		String expected="Supplier ";
		String actual=driver.findElement(By.xpath("//h4[contains(text(),'Supplier')]")).getText();

		if(expected.equalsIgnoreCase(actual)) {

			System.out.println("Page displayed");
		}
		else
			System.out.println("not displayed");

		//Logout
		driver.findElement(By.xpath("//img[@class='img-profile rounded-circle']")).click();
		WebElement logout = driver.findElement(By.xpath("//a[@data-target='#logoutModal']"));
		wLib.moveToElement(driver, logout);
		driver.findElement(By.linkText("Logout")).click();

	}

}
