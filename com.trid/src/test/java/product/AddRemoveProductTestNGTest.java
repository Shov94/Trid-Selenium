package product;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.trid.GenericUtilities.BaseClass;
import com.trid.ObjectRepository.HomePage;
import com.trid.ObjectRepository.ProductCategoryPage;
import com.trid.ObjectRepository.ProductPage;

public class AddRemoveProductTestNGTest extends BaseClass{

	@Test
	public void addRemoveProduct() {
		HomePage hp= new HomePage(driver);

		hp.clickPOSBtn();
		//click on head set category
		String expected="Fantech EG1";
		String quan="5";
		ProductCategoryPage pcp=new ProductCategoryPage(driver);
		pcp.clickHeadset();
		pcp.addRequiredQuatity(driver, expected, quan);

//		String numPath="//td[normalize-space()='Fantech EG1']";
//		String exs = driver.findElement(By.xpath(numPath)).getText();

		String text = driver.findElement(By.xpath("//tbody/tr/td[1]")).getText();
		String text1 = driver.findElement(By.xpath("//tbody/tr/td[2]")).getText();
		System.out.println(text+" : "+text1);

		ProductPage pp=new ProductPage(driver);
		pp.validateProductInPOS(driver, expected);
//		if(expected.equalsIgnoreCase(exs)) {
//			System.out.println("displayed");
//		}
//		else {
//			System.out.println("not displayed");
//		}

		// to delete the added products
		pcp.clickDelete();

	}

}

