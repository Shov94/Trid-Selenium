package suppliers;

import java.util.HashMap;

import org.testng.annotations.Test;

import com.trid.GenericUtilities.BaseClass;
import com.trid.ObjectRepository.HomePage;
import com.trid.ObjectRepository.ProductPage;
import com.trid.ObjectRepository.SupplierPage;

public class SupplierInProductListTestNGTest extends BaseClass {

	@Test
	public void SupplierPresentInProductPage() throws Throwable {


		//String company=exLib.readDataFromExcelFile("Supplier", 1, 0)+jLib.getRandomNo();
		String province=exLib.readDataFromExcelFile("Supplier", 1, 2);
		String city=exLib.readDataFromExcelFile("Supplier", 2, 2);
		//String phone=exLib.readDataFromExcelFile("Supplier", 1, 3);
		String expData=exLib.readDataFromExcelFile("Supplier", 0, 0);

		HomePage hp= new HomePage(driver);
		hp.clickSupplier();

		SupplierPage sp=new SupplierPage(driver);
		HashMap<String, String> map = exLib.readMultipleDataFromExcel(driver, "Supplier", 1, 2);
		sp.addSupplier(driver, map, province, city, expData);  
		hp.clickProduct();
		ProductPage pp=new ProductPage(driver);
		pp.clickAddIcon();
		String data=exLib.readDataFromExcelFile("Supplier", 0, 2);
		pp.fromSupplierDropDown(data,driver);
		//pp.clickCancelBtn();

	}

}
