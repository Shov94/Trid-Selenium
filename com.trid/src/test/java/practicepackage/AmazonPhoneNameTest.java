package practicepackage;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AmazonPhoneNameTest {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.amazon.in/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Phones" +Keys.ENTER);
		String phone="motorola";
		driver.findElement(By.xpath("//div[@id='brandsRefinements']/descendant::span[@class='a-expander-prompt']")).click();
		//System.out.println("hi");
		List<WebElement> all = driver.findElements(By.xpath("//ul[@class='a-unordered-list a-nostyle a-vertical a-spacing-medium']/ancestor::div[@id='brandsRefinements']"));
		for (WebElement webElement : all) {
			
			String one=webElement.getText();
			System.out.println(one);
			if(phone.equalsIgnoreCase(one)) {
			driver.findElement(By.xpath("//i[@class='a-icon a-icon-checkbox']/ancestor::div[@id='brandsRefinements']/descendant::span[text()='Samsung']")).click();
			}
		}
		
	}

}


