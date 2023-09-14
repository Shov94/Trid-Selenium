package practicepackage;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class iPhoneAmazonTest {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.amazon.in/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("iPhone" +Keys.ENTER);
		
		List<WebElement> allName = driver.findElements(By.xpath("//span[@class='a-size-medium a-color-base a-text-normal']"));
		List<WebElement> allPrice = driver.findElements(By.xpath("//span[@class='a-size-medium a-color-base a-text-normal']/ancestor::div[@class='a-section a-spacing-small a-spacing-top-small']/descendant::span[@class='a-price-whole']"));
       int count=allName.size();
       for(int i=0;i<count-1;i++) {
    	   String onePhone=allName.get(i).getText();
       	String Price=allPrice.get(i).getText();
       	String onePrice=Price.replaceAll("₹", "");
       	System.out.println(onePhone+"----->"+onePrice);
    	   
       }
			
		}
	}


