package webtable;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ProKabadiTableTest {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.prokabaddi.com/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		String team="Bengaluru Bulls";
		driver.findElement(By.xpath("//button[@class='btn-close']")).click();
        driver.findElement(By.xpath("//span[text()='Standings']")).click();
      
       List<WebElement> all = driver.findElements(By.xpath("//p[@class='name']//ancestor::div[@class='row-head']/descendant::p[@class='count']"));
	
	   for(WebElement wb:all) {
		   
		   System.out.print("  "+wb.getText());
	   }
	
	
	
	}
	
}
