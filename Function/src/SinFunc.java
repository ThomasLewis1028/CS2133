/**
 * Thomas Lewis
 * Computer Science II - CS2133
 * Christopher Crick
 * SinFunc.java - Extend Function and implement evaluate to be called
 * by Function.java's tests.  Evaluates sin(x)
 */
public class SinFunc extends Function {
	private static Function func = null;

	@Override
	public double evaluate(double x) {
		return Math.sin(x);
	}

	public static void main(String[] args){
		func = new SinFunc();
		double sinValue = func.findRoot(3, 4, 0.00000001);
		System.out.println(sinValue);
	}
}