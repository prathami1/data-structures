import static org.junit.Assert.*;
import java.util.Random;
import org.junit.Test;


public class KahumoTest {

	public void compare(double[] r1, double[] r2) {
		assertTrue("Arrays not the same length", r1.length == r2.length);
		for (int i = 0; i < r1.length; i++) {
			double a1 = r1[i];
			double a2 = r2[i];
			assertEquals(a1, a2, 0.009);
		}
	}
	
	@Test
	public void test1() {
		double[] u = new double[] {1.0, 2.0, 4.0, 8.0, 16.0};
		compare(u, Kahumo.serve(31, 2, 5));
	}
	@Test
	public void test2() {
		double[] u = new double[] {2.0, 6.0, 18.0, 54.0, 162.0, 486.0};
		compare(u, Kahumo.serve(728, 3, 6));
	}
	@Test
	public void test3() {
		double[] u = new double[] {21.053, 31.579, 47.368};
		compare(u, Kahumo.serve(100, 1.5, 3));
	}
	@Test
	public void test4() {
		double[] u = new double[] {6.2, 6.2, 6.2, 6.2, 6.2};
		compare(u, Kahumo.serve(31, 1.0, 5));
	}
}
