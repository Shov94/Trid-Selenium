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

public class FlipkartSamsungTest {

	public static void main(String[] args) throws Exception {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.flipkart.com/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//driver.findElement(By.xpath("//button[contains(text(),'✕')]")).click();
		driver.findElement(By.name("q")).sendKeys("samsung phones"+Keys.ENTER);
		Thread.sleep(3000);
		
		List<WebElement> allPhones = driver.findElements(By.xpath("//div[@class='_4rR01T']"));
		List<WebElement> allPrices = driver.findElements(By.xpath("//div[@class='_4rR01T']/ancestor::div[@class='_3pLy-c row']//descendant::div[@class='_30jeq3 _1_WHN1']"));
		int count=allPhones.size();
        for(int i=0;i<=count-1;i++) {
        	String onePhone=allPhones.get(i).getText();
        	String Price=allPrices.get(i).getText();
        	String onePrice=Price.replaceAll("₹", "");
        	System.out.println(onePhone+"----->"+onePrice);
        	
        }
	}

}
