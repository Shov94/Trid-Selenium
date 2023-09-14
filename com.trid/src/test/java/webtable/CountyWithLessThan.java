package webtable;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CountyWithLessThan {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.icc-cricket.com/rankings/mens/team-rankings/t20i");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
 
		
		List<WebElement> allteam = driver.findElements(By.xpath("//table//tr[*]/td[3][@class='table-body__cell u-center-text' and text()>30]/preceding-sibling::td[@class='table-body__cell rankings-table__team']"));
		List<WebElement> allmatch = driver.findElements(By.xpath("//table//tr[*]/td[3][@class='table-body__cell u-center-text' and text()>30]"));
		//table//tr[*]/td[3][@class='table-body__cell u-center-text' and text()<40]
		for(int i=0;i<allteam.size()-1;i++) {
			
			String team=allteam.get(i).getText();
			String match=allmatch.get(i).getText();
			System.out.println(team+"===="+match);
		}
		
	}

}
