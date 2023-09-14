package practicepackage;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BookingCalendar {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.booking.com/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		
		driver.findElement(By.xpath("//button[text()='Check-in Date']")).click();
		
	}

}
