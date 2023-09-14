package practicepackage;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SoftAsser {

	
	@Test
	public void soft() {
		SoftAssert sa=new SoftAssert();
		
		    int b=9;
			System.out.println("1");
			System.out.println("2");
			Assert.assertEquals(b, 10,"Value Mismatched");
			System.out.println("3");
			System.out.println("4");
			
		}

	}

