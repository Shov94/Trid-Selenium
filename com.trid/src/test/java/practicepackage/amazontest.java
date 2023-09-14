package practicepackage;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.net.ssl.HttpsURLConnection;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class amazontest {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.amazon.in/");
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		List<WebElement> allLinks = driver.findElements(By.xpath("//a"));
		int count=allLinks.size();
		System.out.println(count);
		ArrayList<String> storeLinks=new ArrayList<String>();

		for (WebElement wb : allLinks) {

			String oneLink=wb.getAttribute("href");

			URL url=null;
			int code=0;

			try {
				url=new URL(oneLink);
				HttpsURLConnection https=(HttpsURLConnection) url.openConnection();
				code=https.getResponseCode();


				if(code>=400) {

					storeLinks.add(oneLink+"------>"+code);
				}


			} 

			catch (Throwable e) {
				storeLinks.add(oneLink+"----->"+code);
			}

		}

		System.out.println(storeLinks);
		driver.close();


	}

}
