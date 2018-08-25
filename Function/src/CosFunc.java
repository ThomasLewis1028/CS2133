/**
 * Thomas Lewis
 * Computer Science II - CS2133
 * Christopher Crick
 * CosFunc.java - Extend Function and implement evaluate to be called
 * by Function.java's tests.  Evaluates cos(x)
 */
public class CosFunc extends Function {
	@Override
	public double evaluate(double x) {
		return Math.cos(x);
	}
}