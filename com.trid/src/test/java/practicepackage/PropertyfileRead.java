package practicepackage;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class PropertyfileRead {

	public static void main(String[] args) throws Throwable {
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\CommonData.properties");
		Properties p=new Properties();
		p.load(fis);
		String username = p.getProperty("username");
		String password = p.getProperty("password");
		String url = p.getProperty("url");
		String browser=p.getProperty("browser");



		WebDriver driver;

		if(browser.equalsIgnoreCase("Chrome")){


			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		}
		else if(url.equalsIgnoreCase("firefox")) {

			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		}
		else {
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();		
		}


		driver.manage().window().maximize();
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);


		driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys(username);
		driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys(password);
		driver.findElement(By.xpath("//button[text()='Login']")).click();
		Alert a=driver.switchTo().alert();
		a.accept();



	}

}
