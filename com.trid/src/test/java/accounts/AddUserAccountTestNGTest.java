package accounts;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.trid.GenericUtilities.BaseClass;
import com.trid.ObjectRepository.AccountsPage;
import com.trid.ObjectRepository.HomePage;


@Listeners(com.trid.GenericUtilities.ListenerClass.class)
public class AddUserAccountTestNGTest extends BaseClass {
	
	
	@Test(groups = "smoke")
	public void addUser() {
	//Click on accounts link
		HomePage hp= new HomePage(driver);
		hp.clickAccount();
		AccountsPage ap=new AccountsPage(driver);
		ap.clickAddLookup();
		
//		String actual=driver.findElement(By.xpath("//h5[text()='Add User Account']")).getAttribute("innerHTML");
		String popupmessage="Add User Account";
		ap.validateMessage(popupmessage);
//		
//		if(actual.equalsIgnoreCase(popupmessage)) {
//			
//			System.out.println("Pop up is displayed");
//		}
//		
//		else
//			System.out.println("Not Displayed");
		
        driver.navigate().refresh();
	}
}
