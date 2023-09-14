package practicepackage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;

import com.mysql.jdbc.Driver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RmgYantraTest {

	public static void main(String[] args) throws Exception {
		String data="POSEIDON1124";
		Connection conn=null;
		try {
			WebDriverManager.chromedriver().setup();
			WebDriver driver=new ChromeDriver();
			driver.manage().window().maximize();
			driver.get("http://rmgtestingserver:8084/");
			driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
			RemoteWebDriver r=(RemoteWebDriver) driver;
			r.executeScript("document.getElementById('usernmae').value='rmgyantra'");
			r.executeScript("document.getElementById('inputPassword').value='rmgy@9999'");

			driver.findElement(By.xpath("//button[text()='Sign in']")).click();
			Thread.sleep(3000);
			driver.findElement(By.xpath("//a[text()='Projects']")).click();

			driver.findElement(By.xpath("//span[text()='Create Project']")).click();
			driver.findElement(By.name("projectName")).sendKeys("POSEIDON1124");
			driver.findElement(By.name("createdBy")).sendKeys("Abhimanyu");
			WebElement dropdown = driver.findElement(By.xpath("(//select[@name='status'])[2]"));
			Select s= new Select(dropdown);
			s.selectByVisibleText("Created");
			driver.findElement(By.xpath("//input[@value='Add Project']")).click();


			Driver drive=new Driver();
			DriverManager.registerDriver(drive);

			conn=DriverManager.getConnection("jdbc:mysql://rmgtestingserver:3333/projects", "root@%", "root");


			Statement state=conn.createStatement();
			String query="select * from project;";


			ResultSet result=state.executeQuery(query);
			boolean flag=false;
			while(result.next()) {
				String actual=result.getString(4);
				if(actual.equalsIgnoreCase(data)) {

					flag=true;
					break;
				}
			}
				if(flag) {
					System.out.println("Project created sucessfully");
				}
				else {
					System.out.println("Not created");
				}
		}

		catch (Exception e) {
			// TODO: handle exception
		}
		finally {
			conn.close();
		}



	}
}

