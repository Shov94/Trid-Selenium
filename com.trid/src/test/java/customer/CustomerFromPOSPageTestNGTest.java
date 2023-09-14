package customer;

import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.trid.GenericUtilities.BaseClass;
import com.trid.GenericUtilities.ExcelUtilities;
import com.trid.ObjectRepository.CustomerPage;
import com.trid.ObjectRepository.HomePage;
import com.trid.ObjectRepository.LoginPage;
import com.trid.ObjectRepository.ProductCategoryPage;

public class CustomerFromPOSPageTestNGTest extends BaseClass{


	@Test
	public void addCustomerFromPOS() throws Throwable {
		ExcelUtilities exLib=new ExcelUtilities();

		HomePage hp=new HomePage(driver);
		hp.logout(driver);
		LoginPage lp=new LoginPage(driver);


		lp.loginAsUser(driver);

		String exData=exLib.readDataFromExcelFile("Customer", 0, 0);
		String productName=exLib.readDataFromExcelFile("Customer", 0, 6);
		String quantity=exLib.readDataFromExcelFile("Customer", 1, 6);
		String name=exLib.readDataFromExcelFile("Customer", 0, 2);
		HashMap<String, String> map = exLib.readMultipleDataFromExcel(driver,"Customer", 1, 2);
		CustomerPage cp=new CustomerPage(driver);
		ProductCategoryPage pcp=new ProductCategoryPage(driver);
		
		pcp.clickOthers();
		pcp.addCustomerDetails(driver, map, exData, productName, quantity);

		hp.logout(driver);

		
		lp.loginAsAdmin(driver);
		//click on customer link
		
		hp.clickCustomer();
		Assert.fail();
		//search  for created customer
		cp.searchCustomer(name);
		cp.validateCustomerName(driver, name);
//		String actualname = driver.findElement(By.xpath("//table/tbody/tr[1]/td[1]")).getText();
//		if (actualname.contains(name)) {
//			System.out.println("Created Customer is displayed");
//		}
//		else
//			System.out.println("Created Customer is not  displayed");


	}

}
