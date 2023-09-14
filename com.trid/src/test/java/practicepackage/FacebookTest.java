package practicepackage;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class FacebookTest {

	

		@Test
		public void cmdLine() {
			
			String browser=System.getProperty("browser");
			String url = System.getProperty("url");
			String username = System.getProperty("username");
			String password = System.getProperty("password");
			WebDriver driver=new ChromeDriver();

			driver.manage().window().maximize();
			driver.get(url);
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);


			driver.findElement(By.xpath("//input[@id='email']")).sendKeys(username);
			driver.findElement(By.xpath("//input[@id='pass']")).sendKeys(password);
			driver.findElement(By.xpath("//button[@data-testid=\"royal_login_button\"]")).click();
			


	}

}
