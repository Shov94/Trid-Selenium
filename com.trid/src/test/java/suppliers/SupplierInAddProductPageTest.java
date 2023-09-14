package suppliers;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import com.trid.GenericUtilities.ExcelUtilities;
import com.trid.GenericUtilities.FileUtilities;
import com.trid.GenericUtilities.JavaUtilities;
import com.trid.GenericUtilities.WebUtilities;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SupplierInAddProductPageTest {

	public static void main(String[] args) throws Throwable {
		ExcelUtilities exLib=new ExcelUtilities();
		FileUtilities fLib=new FileUtilities();
		JavaUtilities jLib= new JavaUtilities();
		WebUtilities wLib=new WebUtilities();


		//Get the data from property file
		/*
				FileInputStream fis= new FileInputStream("src\\test\\resources\\CommonData.properties");
				Properties p= new Properties();
				p.load(fis);
				String USERNAME = p.getProperty("username");
				String PASSWORD = p.getProperty("password");
				String URL = p.getProperty("url");
				String BROWSER=p.getProperty("browser");


				//Random number

				Random random=new Random();
				int ran=random.nextInt(899)+100;
		 */

		String BROWSER=fLib.readDataFromPropertyFile("browser");
		String URL =fLib.readDataFromPropertyFile("url");
		String USERNAME =fLib.readDataFromPropertyFile("username");
		String PASSWORD =fLib.readDataFromPropertyFile("password");

		//Fetch the data from excel file for supplier
		/*FileInputStream fi=new FileInputStream("src\\test\\resources\\DATA.xlsx");
		Workbook wb = WorkbookFactory.create(fi);
		Sheet sh=wb.getSheet("Supplier");
		String company=sh.getRow(1).getCell(0).getStringCellValue()+ran;
		String province=sh.getRow(1).getCell(1).getStringCellValue();
		String city=sh.getRow(1).getCell(2).getStringCellValue();
		String phone=sh.getRow(1).getCell(3).getStringCellValue();

		 */


		String company=exLib.readDataFromExcelFile("Supplier", 1, 0)+jLib.getRandomNo();
		String province=exLib.readDataFromExcelFile("Supplier", 1, 1);
		String city=exLib.readDataFromExcelFile("Supplier", 1, 2);
		String phone=exLib.readDataFromExcelFile("Supplier", 1, 3);

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
		wLib.pageLoadWait(driver, 10);
		//Enter the login credentials
		driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys(USERNAME);
		driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys(PASSWORD);
		driver.findElement(By.xpath("//button[text()='Login']")).click();
		wLib.alertAccept(driver);

		driver.findElement(By.xpath("//span[text()='Supplier']")).click();
		driver.findElement(By.xpath("//i[@class='fas fa-fw fa-plus']")).click();

		//Enter the values in text fields
		driver.findElement(By.name("companyname")).sendKeys(company);
		driver.findElement(By.name("phonenumber")).sendKeys(phone);

		//Enter values in drop down

		WebElement pro=driver.findElement(By.name("province"));
		wLib.fromDropDown(province, pro);
		//Select s=new Select(pro);
		//s.selectByVisibleText(province);

		WebElement ci=driver.findElement(By.name("city"));
		wLib.fromDropDown(city, ci);
		//Select ss=new Select(ci);
		//ss.selectByVisibleText(city);

		//Save button
		driver.findElement(By.xpath("(//button[text()='Save'])[1]")).click();

		//Product link
		driver.findElement(By.xpath("//span[text()='Product']")).click();
		driver.findElement(By.xpath("//i[@class='fas fa-fw fa-plus']")).click();

		WebElement supplier=driver.findElement(By.name("supplier"));
		Select s1=new Select(supplier);
		List<WebElement> all = s1.getOptions();
		for (WebElement webElement : all) {

			String one = webElement.getText();
			if(one.contains(company)) {
				System.out.println("Supplier is present");
			}
		}

		driver.findElement(By.xpath("//input[@name='datestock']/../following-sibling::button[text()='Cancel']")).click();
		//Log-out
		driver.findElement(By.xpath("//img[@class='img-profile rounded-circle']")).click();
		WebElement logout = driver.findElement(By.xpath("//a[@data-target='#logoutModal']"));
		wLib.moveToElement(driver, logout);

		//Actions ac=new Actions(driver);
		//ac.moveToElement(logout).click().perform();


		driver.findElement(By.linkText("Logout")).click();



	}

}
