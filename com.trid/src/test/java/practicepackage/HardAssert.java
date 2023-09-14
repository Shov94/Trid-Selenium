package practicepackage;

import static org.testng.Assert.*;
import org.testng.annotations.Test;

public class HardAssert {
	
	
	@Test
	public void hardAsser() {
		double a=10.5;
		System.out.println("1");
		System.out.println("2");
		assertEquals(a, 10,"Value Mismatched");
		System.out.println("3");
		System.out.println("4");
		
	}

	@Test
	public void hardAssert() {
		int a=10;
		System.out.println("5");
		System.out.println("6");
		assertEquals(a, 10);
		System.out.println("7");
		System.out.println("8");
	}

}
