package practicepackage;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RedbusCalendar {

	public static void main(String[] args) {
		//String monthYear="January 2024";
		//int date=26;
		ChromeOptions op=new ChromeOptions();
		op.addArguments("--disable-notofications");
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver(op);
		driver.manage().window().maximize();
		driver.get("https://www.redbus.in/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	
		driver.findElement(By.id("onwardCal")).click();
		//String year="//div[@class='DayNavigator__IconBlock-qj8jdz-2 iZpveD']//ancestor::div[@class='sc-jzJRlG dPBSOp']//descendant::span[text()='30']";

	}

}
