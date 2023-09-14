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
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class irctclinktest {

	public static void main(String[] args) {
		ChromeOptions options=new ChromeOptions();
		options.addArguments("--disable-notifications");
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.get("https://www.irctc.co.in/nget/train-search");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		List<WebElement> allLinks = driver.findElements(By.xpath("//a"));
		int count=allLinks.size();
		System.out.println(count);
		ArrayList<String> linkList=new ArrayList<String>();
		for (int i=0;i<count;i++) {
			String eachLink=allLinks.get(i).getAttribute("href");

			URL url=null;
			int statusCode=0;
			try {

				url= new URL(eachLink);

				HttpsURLConnection connection= (HttpsURLConnection)url.openConnection();
				statusCode=connection.getResponseCode();
				if(statusCode>=400) {
					linkList.add(eachLink+"======>"+statusCode);
				}
			} catch (Throwable e) {
				linkList.add(eachLink+"----->"+statusCode);
			}

		}
		System.out.println(linkList);
		driver.close();

	}

}
