package product;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.trid.GenericUtilities.ExcelUtilities;
import com.trid.GenericUtilities.FileUtilities;
import com.trid.GenericUtilities.WebUtilities;

import io.github.bonigarcia.wdm.WebDriverManager;


public class AddaProductTest{

	public static void main(String[] args) throws Throwable {
		
		ExcelUtilities exLib=new ExcelUtilities();
		FileUtilities fLib=new FileUtilities();
		//JavaUtilities jLib= new JavaUtilities();
		WebUtilities wLib=new WebUtilities();
		
		
		//Get the data from property file
		/*FileInputStream fis= new FileInputStream("src\\test\\resources\\CommonData.properties");
		Properties p= new Properties();
		p.load(fis);
		String USERNAME = p.getProperty("username");
		String PASSWORD = p.getProperty("password");
		String URL = p.getProperty("url");
		String BROWSER=p.getProperty("browser");*/
		
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
		wLib.pageLoadWait(driver, 10);
		
		//Enter the login credentials
		
		driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys(USERNAME);
		driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys(PASSWORD);
		driver.findElement(By.xpath("//button[text()='Login']")).click();
		wLib.alertAccept(driver);
		
        
		//Go to product page
		driver.findElement(By.xpath("//span[contains(text(),'Product')]")).click();
		driver.findElement(By.xpath("//i[@class='fas fa-fw fa-plus']")).click();
		
		//Fetch the data from excel file
		/*FileInputStream fi=new FileInputStream("src\\test\\resources\\DATA.xlsx");
		Workbook wb = WorkbookFactory.create(fi);
		Sheet sh = wb.getSheet("Product");
	
		String procode=sh.getRow(0).getCell(1).getStringCellValue()+jLib.getRandomNo();
		String name=sh.getRow(1).getCell(1).getStringCellValue();
		String description=sh.getRow(2).getCell(1).getStringCellValue();
		String quantity=sh.getRow(3).getCell(1).getStringCellValue();
		String onhand=sh.getRow(4).getCell(1).getStringCellValue();
		String price=sh.getRow(5).getCell(1).getStringCellValue();*/
		
		/*	
		String procode=exLib.readDataFromExcelFile("Product", 0, 1)+jLib.getRandomNo();
		String name=exLib.readDataFromExcelFile("Product", 1, 1);
		String description=exLib.readDataFromExcelFile("Product", 2, 1);
		String quantity=exLib.readDataFromExcelFile("Product", 3, 1);
		String onhand=exLib.readDataFromExcelFile("Product", 4, 1);
		
		
		
		driver.findElement(By.name("prodcode")).sendKeys(procode);
		driver.findElement(By.name("name")).sendKeys(name);
		driver.findElement(By.xpath("//textarea[@name='description']")).sendKeys(description);
		driver.findElement(By.name("quantity")).sendKeys(quantity);
		driver.findElement(By.name("onhand")).sendKeys(onhand);
		
		//storing in hash map(excel)
		int count=exLib.getLastRowNo("Sheet1");
		HashMap<String,String> map=new HashMap<String,String>();

		for(int i=0;i<=count;i++) {
			String key=sh.getRow(i).getCell(0).getStringCellValue();
			String value=sh.getRow(i).getCell(1).getStringCellValue();
			map.put(key, value);
		}
		// Enter the values in text fields
		for (Entry<String, String> set: map.entrySet()) {	
			
			driver.findElement(By.name(set.getKey())).sendKeys(set.getValue());
			System.out.println(set);
		}
		*/
		
		
		//String expectedData=exLib.readDataFromExcelFile("Product1", 0, 0);
		
		
		exLib.readMultipleDataFromExcel(driver, "Product1", 1, 2);
		//String price=exLib.readDataFromExcelFile("Sheet1", 3, 6);
		//driver.findElement(By.name("price")).sendKeys(price);
		
		//Select from drop down
		
		
		WebElement category=driver.findElement(By.xpath("//div[@class='form-group']/ancestor::div[@class='modal-body']/descendant::select[@name='category']"));
		wLib.fromDropDown("Others", category);
		
		
		WebElement supplier=driver.findElement(By.name("supplier"));
		wLib.fromDropDown("Strategic Technology Co.", supplier);
		//Select s1=new Select(supplier);
		//s1.selectByVisibleText("Strategic Technology Co.");
		
		
		//Select from calendar
		WebElement date=driver.findElement(By.xpath("//input[@name='datestock']"));
		date.click();
		date.sendKeys("29072023");
		//Save button
		
		driver.findElement(By.xpath("//input[@name='datestock']/../following-sibling::button[1]")).click();
		
		//Log-out
		driver.findElement(By.xpath("//img[@class='img-profile rounded-circle']")).click();
		WebElement logout = driver.findElement(By.xpath("//a[@data-target='#logoutModal']"));
		wLib.moveToElement(driver, logout);
		//Actions ac=new Actions(driver);
		//ac.moveToElement(logout).click().perform();
		
		driver.findElement(By.linkText("Logout")).click();
		
	}

}
