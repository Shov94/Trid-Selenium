package practicePOM;

import java.util.HashMap;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.trid.GenericUtilities.ExcelUtilities;
import com.trid.GenericUtilities.FileUtilities;
import com.trid.GenericUtilities.JavaUtilities;
import com.trid.GenericUtilities.WebUtilities;
import com.trid.ObjectRepository.CustomerPage;
import com.trid.ObjectRepository.HomePage;
import com.trid.ObjectRepository.LoginPage;
import com.trid.ObjectRepository.ProductCategoryPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CustometFromPos_POM {


	public static void main(String[] args) throws Throwable {
		//DatabaseUtilities dblib=new DatabaseUtilities();
				ExcelUtilities exLib=new ExcelUtilities();
				FileUtilities fLib=new FileUtilities();
				JavaUtilities jLib= new JavaUtilities();
				WebUtilities wLib=new WebUtilities();
				
				/*FileInputStream fis = new FileInputStream("src\\test\\resources\\CommonData.properties");
				Properties p= new Properties();
				p.load(fis);

				String USERNAME = p.getProperty("user");
				String PASSWORD = p.getProperty("pass");
				String URL = p.getProperty("url");
				String BROWSER=p.getProperty("browser");*/
				
				String BROWSER=fLib.readDataFromPropertyFile("browser");
				String URL=fLib.readDataFromPropertyFile("url");
//				String USERNAME=fLib.readDataFromPropertyFile("user");
//				String PASSWORD=fLib.readDataFromPropertyFile("pass");
//				
				String exData=exLib.readDataFromExcelFile("Customer", 0, 0);
				String productName=exLib.readDataFromExcelFile("Customer", 0, 6);
				String quantity=exLib.readDataFromExcelFile("Customer", 1, 6);
				String phone=exLib.readDataFromExcelFile("Customer", 2, 6)+jLib.getRandomNo();
				
				System.out.println(exData);
				System.out.println(productName);
				System.out.println(quantity);
				
				
				//Choose the browser
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
				wLib.maximizeBrowser(driver);
				driver.get(URL);
				wLib.pageLoadWait(driver, 10);
				lp.loginAsUser(driver);
				
				
				
				
				HashMap<String, String> map = exLib.readMultipleDataFromExcel(driver,"Customer", 1, 2);
				
				//Enter the login credentials for cashier
//				driver.findElement(By.name("user")).sendKeys(USERNAME);
//				driver.findElement(By.name("password")).sendKeys(PASSWORD);
//				driver.findElement(By.name("btnlogin")).click();
//				wLib.alertAccept(driver);
				// to add required quantity
				CustomerPage cp=new CustomerPage(driver);
				ProductCategoryPage pcp=new ProductCategoryPage(driver);
				pcp.clickOthers();
				pcp.addCustomerDetails(driver, map, exData, productName, quantity);
//				driver.findElement(By.partialLinkText("Others")).click();
//				String qty="//h6[text()='apple iphon 14']/ancestor::div[@class='products']/descendant::input[@name='quantity']";
//				driver.findElement(By.xpath(qty)).sendKeys(Keys.CONTROL+"a"+"delete");
//				Thread.sleep(2000);
//				driver.findElement(By.xpath(qty)).sendKeys("5");
//				driver.findElement(By.xpath("//h6[text()='apple iphon 14']/ancestor::div[@class='products']/descendant::input[@name='addpos']")).click();

				//to verify product and quantity
				// to click on add customer button
//				driver.findElement(By.xpath("//select[@class='form-control']/ancestor::div[@class='col-sm-12 text-primary btn-group']/descendant::a[@data-toggle='modal']")).click();
//
//				Thread.sleep(2000);
				//Random random=new Random();
				//int ran=random.nextInt(99);

				// to add necessary details to add Customer pop up
				/*FileInputStream fis1= new FileInputStream(".\\src\\test\\resources\\DATA.xlsx");
				Workbook wb = WorkbookFactory.create(fis1);
				Sheet sh = wb.getSheet("Customer");

				String firstname = sh.getRow(0).getCell(1).getStringCellValue();
				String lastname = sh.getRow(1).getCell(1).getStringCellValue();
				String phone = sh.getRow(2).getCell(1).getStringCellValue();
				*/
		        //int count=exLib.getLastRowNo("Customer");
		        
//				String firstname=exLib.readDataFromExcelFile("Customer", 0, 1);
//				String lastname=exLib.readDataFromExcelFile("Customer", 1, 1);
//				String phone=exLib.readDataFromExcelFile("Customer", 2, 1);
//		        
//				
//				
//				String wh = driver.getWindowHandle();
//
//				driver.switchTo().window(wh);
//
//				driver.findElement(By.xpath("(//div[@class='modal-body'])[5]/descendant::input[@name='firstname']")).sendKeys(firstname);
//
//				driver.findElement(By.xpath("(//div[@class='modal-body'])[5]/descendant::input[@placeholder='Last Name']")).sendKeys(lastname);
//				driver.findElement(By.xpath("(//div[@class='modal-body'])[5]/descendant::input[@placeholder='Phone Number']")).sendKeys(phone);
//				driver.findElement(By.xpath("(//div[@class='modal-body'])[5]/descendant::button[@type='submit']")).click();
//				wLib.alertAccept(driver);
//				driver.findElement(By.xpath("//img[@class='img-profile rounded-circle']")).click();
//				WebElement target = driver.findElement(By.xpath("//a[@data-target='#logoutModal']"));
//				wLib.moveToElement(driver, target);
				HomePage hp=new HomePage(driver);
				hp.logout(driver);
				
				
//				
//				driver.findElement(By.partialLinkText("Logout")).click();
				//login as admin
//				String USER = fLib.readDataFromPropertyFile("username");
//				String PASS = fLib.readDataFromPropertyFile("password");
//				driver.findElement(By.name("user")).sendKeys(USER);
//				driver.findElement(By.name("password")).sendKeys(PASS);
//				driver.findElement(By.name("btnlogin")).click();
//				wLib.alertAccept(driver);
				lp.loginAsAdmin(driver);
				//click on customer link
				hp.clickCustomer();
				
				//driver.findElement(By.xpath("//span[text()='Customer']")).click();
				//search  for created customer
//				driver.findElement(By.xpath("//input[@type='search']")).sendKeys(phone);
//				String actualname = driver.findElement(By.xpath("//table/tbody/tr[1]/td[3]")).getText();
//				if (actualname.contains(phone)) {
//					System.out.println("Created Customer is displayed");
//				}
//				else
//					System.out.println("Created Customer is not  displayed");
//
//				driver.close();
	}

}
