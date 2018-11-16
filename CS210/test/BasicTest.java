import static org.junit.Assert.*;
import org.junit.Test;

public class BasicTest {

	@Test //causes java to recognize the following method as a test
	public void testFactorial() {
		Specification p = new implementation();

		assertEquals(1, p.factorial(0));
		assertEquals(1, p.factorial(1));
		assertEquals(120, p.factorial(5));
		assertEquals(3628800, p.factorial(10));
	}

	@Test
	public void testFibonacci(){
		Specification p = new implementation();

		assertEquals(0, p.fibonacci(0));
		assertEquals(1, p.fibonacci(1));
		assertEquals(5, p.fibonacci(5));
		assertEquals(55, p.fibonacci(10));
	}

	@Test
	public void testAbs(){
		Specification p = new implementation();

		assertEquals(0, p.abs(0));
		assertEquals(5, p.abs(-5));
		assertEquals(100, p.abs(100));
		assertEquals(540, p.abs(-540));
	}

	@Test
	public void testParity(){
		Specification p = new implementation();

		assertEquals("even", p.parity(-10));
		assertEquals("even", p.parity(0));
		assertEquals("even", p.parity(16));
		assertEquals("even", p.parity(2));
		assertEquals("odd", p.parity(9));
		assertEquals("neither", p.parity(Math.PI));
	}

	@Test 
	public void testFailOnFlasePositiveCase(){
		Specification p = new implementation();
		assertEquals(true, p.failOnFlase(true));
	}

	@Test(expected  = IllegalStateException.class)
	public void testFailOnFalseNegativeCase(){
		Specification p = new implementation();
		p.failOnFlase(false);
	}

	@Test
	public void testAccumulate(){
		Specification p = new implementation();

		assertEquals(0, p.accumulate(0));
		assertEquals(4, p.accumulate(4));
		assertEquals(2, p.accumulate(-2));
		p.reset();
		assertEquals(0, p.accumulate(0));
	}

}
