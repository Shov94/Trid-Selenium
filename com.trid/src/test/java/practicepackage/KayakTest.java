package practicepackage;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class KayakTest {

	public static void main(String[] args) {
		String userMonthYear="November 2023";
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.kayak.co.in/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.findElement(By.xpath("//div[text()='Flights']")).click();
		driver.findElement(By.xpath("//input[@aria-label='Flight destination input']")).sendKeys("Bhub");
		Actions a=new Actions(driver);
		WebElement target=driver.findElement(By.xpath("//span[text()='Bhubaneswar, Odisha, India']"));
		a.moveToElement(target).click().perform();
		
		driver.findElement(By.xpath("//span[@aria-label='Start date calendar input']")).click();
		String monthYear="//div[text()='"+userMonthYear+"']";
		
		
		driver.findElement(By.xpath("//button[@aria-label='Search']")).click();
		
		
		
		driver.findElement(By.xpath("//div[@class='c1wE_-label']")).click();
		
		 int scroll = driver.findElement(By.xpath("//li[@aria-label='Slowest']")).getLocation().y;
		 
		 JavascriptExecutor j=(JavascriptExecutor) driver;
		 j.executeScript("window.scrollBy(o,"+scroll+")");
		

	}

}
