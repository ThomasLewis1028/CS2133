/**
 * Created by Thomas on 9/10/2016.
 */
public class FunctionTest {
	public static double findRoot(double a, double b, double epsilon) {
		double x = ((a + b) / 2);

		if (Math.abs(a - x) < 0.00000001){
			return x;
		}

		if(x > 0 && a > 0 || x < 0 && a < 0){
			return findRoot(x, b, null);
		}else{
			return findRoot(a, x, null);
		}
	}
}
