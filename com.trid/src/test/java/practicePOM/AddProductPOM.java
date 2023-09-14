package practicePOM;

import java.util.HashMap;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.trid.GenericUtilities.ExcelUtilities;
import com.trid.GenericUtilities.FileUtilities;
import com.trid.GenericUtilities.WebUtilities;
import com.trid.ObjectRepository.HomePage;
import com.trid.ObjectRepository.LoginPage;
import com.trid.ObjectRepository.ProductPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AddProductPOM {


	public static void main(String[] args) throws Throwable {
		ExcelUtilities exLib=new ExcelUtilities();
		FileUtilities fLib=new FileUtilities();
		//JavaUtilities jLib= new JavaUtilities();
		WebUtilities wLib=new WebUtilities();
		
		
		String BROWSER=fLib.readDataFromPropertyFile("browser");
		String URL =fLib.readDataFromPropertyFile("url");
		//String USERNAME =fLib.readDataFromPropertyFile("username");
		//String PASSWORD =fLib.readDataFromPropertyFile("password");

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

		LoginPage lp=new LoginPage(driver);
		HomePage hp=new HomePage(driver);
		ProductPage pp=new ProductPage(driver);
		
		
		wLib.maximizeBrowser(driver);

		driver.get(URL);
		wLib.pageLoadWait(driver, 10);
		
		//Enter the login credentials
		
		lp.loginAsAdmin(driver);
		//wLib.alertAccept(driver);
		
        
		//Go to product page
		hp.clickProduct();
		
		//driver.findElement(By.xpath("//span[contains(text(),'Product')]")).click();
		//driver.findElement(By.xpath("//i[@class='fas fa-fw fa-plus']")).click();
		
		
		
		
		String expectedData=exLib.readDataFromExcelFile("Product1", 0, 0);
		
		String dateExcel=exLib.readDataFromExcelFile("Product1", 0, 6);
		//String quantity=exLib.readDataFromExcelFile("Product1", 1, 6);
		String supplier=exLib.readDataFromExcelFile("Product1", 2, 6);
		String category=exLib.readDataFromExcelFile("Product1", 3, 6);
		HashMap<String, String> map = exLib.readMultipleDataFromExcel(driver, "Product1", 1, 2);
		pp.addProduct(map, driver, expectedData, supplier, category, dateExcel);	
		pp.clickSaveBtn();
		//Select from drop down
		
		
//		WebElement category=driver.findElement(By.xpath("//div[@class='form-group']/ancestor::div[@class='modal-body']/descendant::select[@name='category']"));
//		wLib.fromDropDown("Others", category);
//		
//		
//		WebElement supplier=driver.findElement(By.name("supplier"));
//		wLib.fromDropDown("Strategic Technology Co.", supplier);
		
		
		
		//Select from calendar
//		WebElement date=driver.findElement(By.xpath("//input[@name='datestock']"));
//		date.click();
//		date.sendKeys(dateExcel);
		//Save button
		
		//driver.findElement(By.xpath("//input[@name='datestock']/../following-sibling::button[1]")).click();
		
		//Log-out
		hp.logout(driver);
//		driver.findElement(By.xpath("//img[@class='img-profile rounded-circle']")).click();
//		WebElement logout = driver.findElement(By.xpath("//a[@data-target='#logoutModal']"));
//		wLib.moveToElement(driver, logout);
//		//Actions ac=new Actions(driver);
//		//ac.moveToElement(logout).click().perform();
//		
//		driver.findElement(By.linkText("Logout")).click();
//		
	}


	}


