/**
 * Thomas Lewis
 * Computer Science II - CS2133
 * Christopher Crick
 * Function.java - A function to be extended by other classes and
 * contains an abstract class double evaluate(double x) to be
 * implemented by other classes
 */
public abstract class Function {
	public static final double EPSILON = 0.00000001;

	public double findRoot(double a, double b, double epsilon) {
		double x = ((a + b) / 2);
		if (Math.abs(a - x) < epsilon) {
			return x;
		}

		if (evaluate(x) * evaluate(a) < 0) {
			return findRoot(a, x, epsilon);
		} else {
			return findRoot(x, b, epsilon);
		}
	}

	public abstract double evaluate(double x);

	public static void main(String[] args){
		SinFunc sine = new SinFunc();
		System.out.println("Root of sine between 3 and 4 = " + sine.findRoot(3, 4, EPSILON));

		CosFunc cosine = new CosFunc();
		System.out.println("Root of cosine between 1 and 3 = " + cosine.findRoot(1, 3, EPSILON));

		int[] coeffs1 = {-3, 0, 1};
		int[] coeffs2 = {-2, -1, 1};
		PolyFunc poly1 = new PolyFunc(coeffs1);
		PolyFunc poly2 = new PolyFunc(coeffs2);
		System.out.println("Root of polynomial " + poly1 + " =  " + poly1.findRoot(1, 2, EPSILON));
		System.out.println("Root of polynomial " + poly2 + " = " + poly2.findRoot(1, 2, EPSILON));
	}
}