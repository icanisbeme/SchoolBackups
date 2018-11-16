import static org.junit.Assert.*;
import org.junit.BeforeClass;
import org.junit.Test;


public class PersistentTest {

	public static Specification p;
	private static int sum;
	
	@BeforeClass
	public static void initialize(){
		sum = 0;
		p = new implementation();
	}
	
	@Test
	public void testAccumulate(){
		final int r = (int)(Math.random() * 100);
		sum += r;
		
		assertEquals(sum, p.accumulate(r));
	}
	
	@Test
	public void testReset() {
		sum = 0;
		p.reset();
		
		assertEquals(0, p.accumulate(0));
	}
	
	@Test
	public void testBattery(){
		for (int i =1; i <= 1000; i++){
			if (Math.random() < 0.95){
				testAccumulate();
			}else{
				testReset();
			}
		}
	}

}