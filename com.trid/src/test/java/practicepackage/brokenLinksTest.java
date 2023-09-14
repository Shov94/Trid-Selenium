package practicepackage;

import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class brokenLinksTest {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("http://rmgtestingserver:8888/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("test");
		driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("test");
		driver.findElement(By.xpath("//button[text()='Login']")).click();
		Alert a=driver.switchTo().alert();
		a.accept();

		List<WebElement> allLinks = driver.findElements(By.xpath("//a"));
		int count=allLinks.size();
		System.out.println(count);
		ArrayList<String> linkList=new ArrayList<String>();
		for (int i=0;i<count;i++) {
			String eachLink=allLinks.get(i).getAttribute("href");

			URL url=null;
			int statusCode=0;
			String message=null;
			try {

				url= new URL(eachLink);

			     URLConnection connection = url.openConnection();
			     HttpURLConnection con=(HttpURLConnection) connection;
				statusCode=con.getResponseCode();
				message=con.getResponseMessage();
				if(statusCode>=400) {
					linkList.add(eachLink+"----->"+statusCode+"*****"+message);
				}
			} catch (Throwable e) {
				linkList.add(eachLink+"----->"+statusCode+"*****"+message);
			}

		}
		System.out.println(linkList);
		driver.close();
	}

}
