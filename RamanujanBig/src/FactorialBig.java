import java.math.BigInteger;

/**
 * Thomas Lewis
 * Computer Science II - CS2133
 * Christopher Crick
 * FactorialBig.java - Calculate a factorial to the Nth with recursion
 * Now with infinite more digits!
 */

public class FactorialBig {
	public static BigInteger calculate(BigInteger n) {
		if (n.equals(BigInteger.ZERO)) {
			return BigInteger.ONE;
		} else {
			return (n.multiply(calculate(n.subtract(BigInteger.ONE))));
		}
	}

	public static void main(String[] args) {
		int n = Integer.parseInt(args[0]);
		BigInteger k = BigInteger.valueOf(n);
		if (n < 0) {
			System.out.println("Please enter a positive number");
			return;
		}

		if (calculate(BigInteger.ZERO) == BigInteger.ONE) {
			System.out.println("Test 1 passed");
		} else {
			System.out.println("Test 1 failed");
		}

		if (calculate(BigInteger.valueOf(5)) == BigInteger.valueOf(120)) {
			System.out.println("Test 2 passed");
		} else {
			System.out.println("Test 2 failed");
		}

		System.out.println(calculate(k));
	}
}