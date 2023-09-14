package practicepackage;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class tourismlinktest {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://rmgtestingserver/domain/Online_Tourism_Management_System/");
		List<WebElement> allPresentLinks = driver.findElements(By.xpath("//a"));
		
		int countLinks=allPresentLinks.size();
		System.out.println(countLinks);
		
		ArrayList<String> storeLinks=new ArrayList<String>();
		
		for (WebElement wb:allPresentLinks) {
			
			String oneLink=wb.getAttribute("href");
			
			URL url=null;
			int statusCode=0;
			
			try {
				url=new URL(oneLink);
				HttpURLConnection conn=(HttpURLConnection) url.openConnection();
				statusCode=conn.getResponseCode();
				
				if(statusCode>=200) {
					
					storeLinks.add(oneLink+"*********"+statusCode);
				}
				
			} catch (Exception e) {
				storeLinks.add(oneLink+"*********"+statusCode);
			}	
		}
		System.out.println(storeLinks);

	}

}
