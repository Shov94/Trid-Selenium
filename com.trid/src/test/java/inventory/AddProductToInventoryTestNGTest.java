package inventory;

import java.util.HashMap;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.trid.GenericUtilities.BaseClass;
import com.trid.GenericUtilities.ExcelUtilities;
import com.trid.ObjectRepository.HomePage;
import com.trid.ObjectRepository.ProductPage;

public class AddProductToInventoryTestNGTest extends BaseClass {

	@Test
	public void checkProductInInventory() throws Throwable {
		ExcelUtilities exLib=new ExcelUtilities();
		HomePage hp=new HomePage(driver);
		hp.clickProduct();

		ProductPage pp=new ProductPage(driver);
		String expectedData=exLib.readDataFromExcelFile("Product1", 0, 0);

		String dateExcel=exLib.readDataFromExcelFile("Product1", 0, 6);
		String procode=exLib.readDataFromExcelFile("Product1", 0, 2);
		String supplier=exLib.readDataFromExcelFile("Product1", 2, 6);
		String category=exLib.readDataFromExcelFile("Product1", 3, 6);
		HashMap<String, String> map = exLib.readMultipleDataFromExcel(driver, "Product1", 1, 2);
		pp.addProduct(map, driver, expectedData, supplier, category, dateExcel);	
		pp.clickSaveBtn();

		hp.clickInventory();
		//Search bar
		driver.findElement(By.xpath("//input[@class='form-control form-control-sm']")).sendKeys(procode);

		//Compare
		String actual=driver.findElement(By.xpath("//table/tbody/tr[1]/td[1]")).getText();
		if(procode.contains(actual)) {
			System.out.println("Product is added to inventory");
		}
		else
			System.out.println("Not added");	
	}

}
