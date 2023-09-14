package practicePOM;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.trid.GenericUtilities.FileUtilities;
import com.trid.GenericUtilities.WebUtilities;
import com.trid.ObjectRepository.LoginPage;
import com.trid.ObjectRepository.ProductCategoryPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AddandRemoveProduct_POM {

	public static void main(String[] args) throws Throwable {
		//DatabaseUtilities dblib=new DatabaseUtilities();
				//ExcelUtilities exLib=new ExcelUtilities();
				FileUtilities fLib=new FileUtilities();
				//JavaUtilities jLib= new JavaUtilities();
				WebUtilities wLib=new WebUtilities();
				


				//Fetch data from Property file
				/*FileInputStream fis = new FileInputStream("src\\test\\resources\\CommonData.properties");
				Properties p= new Properties();
				p.load(fis);

				String USERNAME = p.getProperty("user");
				String PASSWORD = p.getProperty("pass");
				String URL = p.getProperty("url");
				String BROWSER=p.getProperty("browser");*/

				String BROWSER=fLib.readDataFromPropertyFile("browser");
				String URL =fLib.readDataFromPropertyFile("url");
				

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
				//Enter the login credentials for cashier
//				driver.findElement(By.name("user")).sendKeys(USERNAME);
//				driver.findElement(By.name("password")).sendKeys(PASSWORD);
//				driver.findElement(By.name("btnlogin")).click();
//				wLib.alertAccept(driver);
//				Thread.sleep(2000);

				//click on head set category
				String expected="Fantech EG1";
				String quan="5";
				ProductCategoryPage pcp=new ProductCategoryPage(driver);
				pcp.clickHeadset();
				pcp.addRequiredQuatity(driver, expected, quan);
				//driver.findElement(By.linkText("Headset")).click();

				
//				String xpath="//h6[text()='Fantech EG1']/ancestor::div[@class='products']/descendant::input[@name='quantity']";
//				driver.findElement(By.xpath(xpath)).sendKeys(Keys.CONTROL+"a"+"delete");
//				driver.findElement(By.xpath(xpath)).sendKeys("10");


				//driver.findElement(By.xpath("//h6[text()='Fantech EG1']/ancestor::div[@class='products']/descendant::input[@type='submit']")).click();
				// Verifying that selected product and added qty is displayed
			   String numPath="//td[normalize-space()='Fantech EG1']";
				String exs = driver.findElement(By.xpath(numPath)).getText();
				//System.out.println(exs);
				String text = driver.findElement(By.xpath("//tbody/tr/td[1]")).getText();
				String text1 = driver.findElement(By.xpath("//tbody/tr/td[2]")).getText();
				System.out.println(text+" : "+text1);

				if(expected.equalsIgnoreCase(exs)) {
					System.out.println("displayed");
				}
			else {
					System.out.println("not displayed");
				}

//				// to delete the added products
				pcp.clickDelete();
//				driver.findElement(By.xpath("//div[@class='btn bg-gradient-danger btn-danger']")).click();
	}

}
