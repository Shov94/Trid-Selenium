package suppliers;

import org.testng.annotations.Test;

import com.trid.GenericUtilities.BaseClass;
import com.trid.ObjectRepository.HomePage;
import com.trid.ObjectRepository.SupplierPage;

public class ViewSupplierTestNGTest extends BaseClass {

	@Test(groups = "smoke")
	public void viewSupplier() throws Throwable {
		//Click on Suppliers link
		HomePage hp=new HomePage(driver);
		hp.clickSupplier();
		//driver.findElement(By.linkText("Supplier")).click();
		String expected="Supplier ";
		SupplierPage sp=new SupplierPage(driver);
		sp.validateSupplier(driver, expected);
//		String actual=driver.findElement(By.xpath("//h4[contains(text(),'Supplier')]")).getText();
//
//		if(expected.equalsIgnoreCase(actual)) {
//
//			System.out.println("Page displayed");
//		}
//		else
//			System.out.println("not displayed");
	}

}
