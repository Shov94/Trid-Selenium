package practicepackage;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MakemytripCalendar {

	public static void main(String[] args) {
		String monthUser="November 2023";
		int dateUser=23;
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.makemytrip.com/");
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.navigate().refresh();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		//Actions a=new Actions(driver);
		//a.moveByOffset(40,40).click().perform();

		driver.findElement(By.xpath("//span[text()='Departure']")).click();
		String monthDate="//div[text()='"+monthUser+"']/ancestor::div[@class='DayPicker-Month']/descendant::p[text()='"+dateUser+"']";
		//String year="//span[text()='"+yearUser+"']";
		String next="//span[@aria-label='Next Month']";
		//String monthYear=driver.findElement(By.xpath("//div[@CLASS='DayPicker-Caption']//div")).getText();

		for(;;) 
		try {
				driver.findElement(By.xpath(monthDate)).click();
				break;	
			}
		catch (Exception e) {
			driver.findElement(By.xpath(next)).click();
		}
	}
}	




