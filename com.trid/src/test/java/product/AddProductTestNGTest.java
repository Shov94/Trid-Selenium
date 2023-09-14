package product;

import java.util.HashMap;

import org.testng.annotations.Test;

import com.trid.GenericUtilities.BaseClass;
import com.trid.ObjectRepository.HomePage;
import com.trid.ObjectRepository.ProductPage;

public class AddProductTestNGTest extends BaseClass {
	
	@Test
	public void addProduct() throws Throwable {

		ProductPage pp=new ProductPage(driver);
        HomePage hp=new HomePage(driver);
		//Go to product page
		hp.clickProduct();
		
		
		String expectedData=exLib.readDataFromExcelFile("Product1", 0, 0);
		
		String dateExcel=exLib.readDataFromExcelFile("Product1", 0, 6);
		//String quantity=exLib.readDataFromExcelFile("Product1", 1, 6);
		String supplier=exLib.readDataFromExcelFile("Product1", 2, 6);
		String category=exLib.readDataFromExcelFile("Product1", 3, 6);
		HashMap<String, String> map = exLib.readMultipleDataFromExcel(driver, "Product1", 1, 2);
		pp.addProduct(map, driver, expectedData, supplier, category, dateExcel);	
		pp.clickSaveBtn();
	
	}

}
