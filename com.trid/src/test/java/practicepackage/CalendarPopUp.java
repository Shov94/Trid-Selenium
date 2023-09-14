package practicepackage;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CalendarPopUp {

	public static void main(String[] args) {
		String monthYear="January 2024";
		int date=26;
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.goibibo.com/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);


		driver.findElement(By.xpath("//span[@class='logSprite icClose']")).click();
		driver.findElement(By.xpath("//span[text()='Departure']")).click();
		String actualDate="//div[text()='"+monthYear+"']/ancestor::div[@class='DayPicker-Month']/descendant::p[text()='"+date+"']";
		String next="//span[@aria-label='Next Month']";


		for(;;) {
			try {
				driver.findElement(By.xpath(actualDate)).click();
                break;
			}
			catch (Exception e) {
				driver.findElement(By.xpath(next)).click();	
			}

		}
		driver.findElement(By.xpath("//span[text()='Done']")).click();

	}

}
