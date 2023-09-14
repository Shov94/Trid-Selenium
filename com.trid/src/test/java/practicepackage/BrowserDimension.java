package practicepackage;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserDimension {
	   public static void main(String[] args) {
	     WebDriverManager.chromedriver().setup();
	      WebDriver driver = new ChromeDriver();
	      String url = "https://www.tutorialspoint.com/index.htm";
	      driver.get(url);
	      // maximize the browser
	      driver.manage().timeouts().implicitlyWait(12, TimeUnit.SECONDS);
	      // fetching the current window size with getSize()
	      System.out.println(driver.manage().window().getSize());
	      //Create object of Dimensions class
	      Dimension dm = new Dimension(450,630);
	      //Setting the current window to that dimension
	      driver.manage().window().setSize(dm);
	      driver.close();
	      }
	}
