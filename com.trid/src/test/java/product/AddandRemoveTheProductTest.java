package product;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.trid.GenericUtilities.FileUtilities;
import com.trid.GenericUtilities.WebUtilities;

import io.github.bonigarcia.wdm.WebDriverManager;


public class AddandRemoveTheProductTest {

	public static void main(String[] args) throws Throwable {
		//DatabaseUtilities dblib=new DatabaseUtilities();
		//ExcelUtilities exLib=new ExcelUtilities();
		FileUtilities fLib=new FileUtilities();
		//JavaUtilities jLib= new JavaUtilities();
		WebUtilities wLib=new WebUtilities();



		String BROWSER=fLib.readDataFromPropertyFile("browser");
		String URL =fLib.readDataFromPropertyFile("url");
		String USERNAME =fLib.readDataFromPropertyFile("user");
		String PASSWORD =fLib.readDataFromPropertyFile("pass");


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
		wLib.maximizeBrowser(driver);
		driver.get(URL);
		wLib.pageLoadWait(driver, 10);
		//Enter the login credentials for cashier
		driver.findElement(By.name("user")).sendKeys(USERNAME);
		driver.findElement(By.name("password")).sendKeys(PASSWORD);
		driver.findElement(By.name("btnlogin")).click();
		wLib.alertAccept(driver);
		Thread.sleep(2000);

		//click on head set category
		driver.findElement(By.linkText("Headset")).click();

		String expected="Fantech EG1";
		String xpath="//h6[text()='Fantech EG1']/ancestor::div[@class='products']/descendant::input[@name='quantity']";
		driver.findElement(By.xpath(xpath)).sendKeys(Keys.CONTROL+"a"+"delete");
		driver.findElement(By.xpath(xpath)).sendKeys("10");


		driver.findElement(By.xpath("//h6[text()='Fantech EG1']/ancestor::div[@class='products']/descendant::input[@type='submit']")).click();
		// Verifying that selected product and added qty is displayed
		String numPath="//h4[text()='Point of Sale']/ancestor::div[@class='card shadow mb-4 col-md-12']/descendant::input[@name='quantity[]']";
		String exs = driver.findElement(By.xpath(numPath)).getAttribute("innerHTML");
		System.out.println(exs);
		String text = driver.findElement(By.xpath("//tbody/tr/td[1]")).getText();
		String text1 = driver.findElement(By.xpath("//tbody/tr/td[2]")).getText();
		System.out.println(text+" : "+text1);

		// to delete the added products
		driver.findElement(By.xpath("//div[@class='btn bg-gradient-danger btn-danger']")).click();

		if(expected.equalsIgnoreCase("")) {
			System.out.println("displayed");
		}
		else {
			System.out.println("not displayed");
		}


	}

}
