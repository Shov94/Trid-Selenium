package practicepackage;

import org.testng.annotations.Test;

import com.trid.GenericUtilities.BaseClass;

public class SupplierTestNGTest extends BaseClass {

	@Test
	public void createSupplier() {
		System.out.println("Supplier created----2");
	}

	@Test
	public void modifySupplier() {
		System.out.println("Supplier Modified");
	}
	
	@Test
	public void deleteSupplier() {
		System.out.println("Supplier deleted----3");
	}
}
