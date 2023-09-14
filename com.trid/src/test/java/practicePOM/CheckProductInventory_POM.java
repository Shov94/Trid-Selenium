package practicePOM;

import java.util.HashMap;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.trid.GenericUtilities.ExcelUtilities;
import com.trid.GenericUtilities.FileUtilities;
import com.trid.GenericUtilities.JavaUtilities;
import com.trid.GenericUtilities.WebUtilities;
import com.trid.ObjectRepository.HomePage;
import com.trid.ObjectRepository.LoginPage;
import com.trid.ObjectRepository.ProductPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CheckProductInventory_POM {
	
	public static void main(String[] args) throws Throwable {
		ExcelUtilities exLib=new ExcelUtilities();
		FileUtilities fLib=new FileUtilities();
		JavaUtilities jLib= new JavaUtilities();
		WebUtilities wLib=new WebUtilities();

		//Get the data from property file
		/*FileInputStream fis= new FileInputStream("src\\test\\resources\\CommonData.properties");
		Properties p= new Properties();
		p.load(fis);
		String USERNAME = p.getProperty("username");
		String PASSWORD = p.getProperty("password");
		String URL = p.getProperty("url");
		String BROWSER=p.getProperty("browser");
		 */

		String BROWSER=fLib.readDataFromPropertyFile("browser");
		String URL =fLib.readDataFromPropertyFile("url");
//		String USERNAME =fLib.readDataFromPropertyFile("username");
//		String PASSWORD =fLib.readDataFromPropertyFile("password");
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
		LoginPage lp= new LoginPage(driver);
		wLib.maximizeBrowser(driver);
		driver.get(URL);
		wLib.pageLoadWait(driver, 10);
		lp.loginAsAdmin(driver);

		//Enter the login credentials

//		driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys(USERNAME);
//		driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys(PASSWORD);
//		driver.findElement(By.xpath("//button[text()='Login']")).click();
//		wLib.alertAccept(driver);
		//Go to product page
		HomePage hp=new HomePage(driver);
		hp.clickProduct();
//		driver.findElement(By.xpath("//span[contains(text(),'Product')]")).click();
//		driver.findElement(By.xpath("//i[@class='fas fa-fw fa-plus']")).click();

		//Fetch the data from excel file
		/*FileInputStream fi=new FileInputStream("src\\test\\resources\\DATA.xlsx");
		Workbook wb = WorkbookFactory.create(fi);
		Sheet sh = wb.getSheet("Product");
		int count=sh.getLastRowNum();
		String procode=sh.getRow(0).getCell(1).getStringCellValue()+ran;
		String name=sh.getRow(1).getCell(1).getStringCellValue()+rr;
		String description=sh.getRow(2).getCell(1).getStringCellValue();
		String quantity=sh.getRow(3).getCell(1).getStringCellValue();
		String onhand=sh.getRow(4).getCell(1).getStringCellValue();
		String price=sh.getRow(5).getCell(1).getStringCellValue();
		 */
		ProductPage pp=new ProductPage(driver);
        String expectedData=exLib.readDataFromExcelFile("Product1", 0, 0);
		
		String dateExcel=exLib.readDataFromExcelFile("Product1", 0, 6);
		String quantity=exLib.readDataFromExcelFile("Product1", 1, 6);
		String supplier=exLib.readDataFromExcelFile("Product1", 2, 6);
		String category=exLib.readDataFromExcelFile("Product1", 3, 6);
		HashMap<String, String> map = exLib.readMultipleDataFromExcel(driver, "Product1", 1, 2);
		pp.addProduct(map, driver, expectedData, supplier, category, dateExcel);	
		pp.clickSaveBtn();
//		String procode=exLib.readDataFromExcelFile("Product", 0, 1)+jLib.getRandomNo();
//		String name=exLib.readDataFromExcelFile("Product", 1, 1)+jLib.getRandomNo();;
//		String description=exLib.readDataFromExcelFile("Product", 2, 1);
//		String quantity=exLib.readDataFromExcelFile("Product", 3, 1);
//		String onhand=exLib.readDataFromExcelFile("Product", 4, 1);
//		String price=exLib.readDataFromExcelFile("Product", 5, 1);
//
//
//		driver.findElement(By.name("prodcode")).sendKeys(procode);
//		driver.findElement(By.name("name")).sendKeys(name);
//		driver.findElement(By.xpath("//textarea[@name='description']")).sendKeys(description);
//		driver.findElement(By.name("quantity")).sendKeys(quantity);
//		driver.findElement(By.name("onhand")).sendKeys(onhand);
//		driver.findElement(By.name("price")).sendKeys(price);
//
//		//Select from drop down
//
//		WebElement category=driver.findElement(By.xpath("//div[@class='form-group']/ancestor::div[@class='modal-body']/descendant::select[@name='category']"));
//		wLib.fromDropDown("Others", category);
//		//Select s=new Select(category);
//		//s.selectByVisibleText("Others");
//
//		WebElement supplier=driver.findElement(By.name("supplier"));
//		wLib.fromDropDown("Strategic Technology Co.", supplier);
//		//Select s1=new Select(supplier);
//		//s1.selectByVisibleText("Strategic Technology Co.");
//		//Select from calendar
//		WebElement date=driver.findElement(By.xpath("//input[@name='datestock']"));
//		date.click();
//		date.sendKeys("28072023");
//		//Save button
//
//		driver.findElement(By.xpath("//input[@name='datestock']/../following-sibling::button[1]")).click();

		//Go to inventory
		hp.clickInventory();
		//driver.findElement(By.xpath("//span[text()='Inventory']")).click();
		//Search bar
//		driver.findElement(By.xpath("//input[@class='form-control form-control-sm']")).sendKeys(procode);
//
//		String actual=driver.findElement(By.xpath("//table/tbody/tr[1]/td[1]")).getText();
//		if(procode.equals(actual)) {
//			System.out.println("Product is added to inventory");
//		}
//		else
//			System.out.println("Not added");


		//Log-out
		hp.logout(driver);
//		driver.findElement(By.xpath("//img[@class='img-profile rounded-circle']")).click();
//		WebElement logout = driver.findElement(By.xpath("//a[@data-target='#logoutModal']"));
//		wLib.moveToElement(driver, logout);
//		driver.findElement(By.linkText("Logout")).click();

}
}
