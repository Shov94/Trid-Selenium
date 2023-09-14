package practicepackage;

import org.testng.annotations.Test;

public class TestNGPracticeTest {
	
	@Test
	public void a() {
//		int a=editProduct();
		System.out.println("a");
	}
	
	@Test
	public void b() {
		System.out.println("b");
	}
	
	@Test
	public void c() {
		System.out.println("c");
	}
	
	@Test
	public void f() {
		System.out.println("f");
	}
	
	@Test(dependsOnMethods ="f")
	public void g() {
		System.out.println("g");
	}
	
	@Test(dependsOnMethods ="c")
	public void d() {
		System.out.println("d");
	}
	@Test
	public void x() {
		System.out.println("x");
	}
	
	@Test
	public void z() {
		System.out.println("z");
	}
	@Test
	public void y() {
		System.out.println("y");
	}
	
	@Test
	public void u() {
		System.out.println("u");
	}
	

}
