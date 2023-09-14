package practicepackage;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;



public class practiceProgramcmdTest {

	
		@Test
		public void cmdLine() {
			
			//String browser=System.getProperty("browser");
			String url = System.getProperty("url");
			String username = System.getProperty("username");
			String password = System.getProperty("password");
			WebDriver driver=new ChromeDriver();

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


