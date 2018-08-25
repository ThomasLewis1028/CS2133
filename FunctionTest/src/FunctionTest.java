/**
 * Created by Thomas on 9/10/2016.
 */
public class FunctionTest {
	public static double findRoot(double a, double b, double epsilon) {
		double x = ((a + b) / 2);

		if (Math.abs(a - x) < epsilon) {
			return x;
		}

		if (Math.sin(x) * Math.sin(a) < 0) {
			return findRoot(a, x, epsilon);
		} else {
			return findRoot(x, b, epsilon);
		}
	}

	public static void main(String[] args) {
		System.out.println(findRoot(3, 4, 0.00000001));
	}
}
