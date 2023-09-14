package practicepackage;

import org.testng.annotations.Test;

import com.trid.GenericUtilities.BaseClass;

public class ProductTestNGTest extends BaseClass{

	@Test
	public void createProduct() {
		System.out.println("Product added");
	}
	
	@Test
	public void modifyProduct() {
		System.out.println("Product modified");
	}
	
	@Test
	public void deleteProduct() {
		System.out.println("Product deleted----1");
	}
}
