import javafx.util.converter.BigDecimalStringConverter;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;

/**
 * Thomas Lewis
 * Computer Science II - CS2133
 * Christopher Crick
 * RamanujanBig.java - Calculate pi to the nth Ramanujan's Series
 * Now with infinite more digits!
 *
 * BigInteger and BigDecimal are both far superior in terms of calculating pi because with an int or a long,
 * you can only go out to so many digits.  With BigInt/Dec, you can theoretically go out to infinite digits
 * but you'd run out of memory before it could reach all of them.  However, it can be a little slower to
 * calculate, and it also takes up a ton of space in the output.  Plus, if you don't limit your decimals
 * you can run into exceptions where there's never-ending decimals.
 */
public class RamanujanBig {
	public static void main(String[] args) {
		int k = Integer.parseInt(args[0]);
		BigDecimal ramanPi = calcRaman(k);

		System.out.println("Pi according to " + k + " iterations of Ramanujan's Series: " + ramanPi);
		System.out.println("This is " + piCompare(ramanPi) + " percent off from Java's Pi value");
	}

	public static BigDecimal piCompare(BigDecimal ramanPi) {
		BigDecimal percentage = ramanPi.divide(BigDecimal.valueOf(Math.PI), 100, RoundingMode.HALF_UP);
		percentage = percentage.subtract(BigDecimal.ONE);
		percentage = percentage.multiply(BigDecimal.valueOf(100));
		return percentage;
		//Because 1-% can end negative, the abs of it is correct
	}

	public static BigDecimal calcRaman(int k) {
		BigDecimal rightFormula = BigDecimal.ZERO;
		//(2 * sqrt2) / 9801 in BigDecimal form
		BigDecimal sqrt2 = BigDecimal.valueOf(findRoot(1, 2));
		BigDecimal leftEqTop = BigDecimal.valueOf(2).multiply(sqrt2);
		BigDecimal leftEqBtm = BigDecimal.valueOf(9801);
		BigDecimal leftFormula = leftEqTop.divide(leftEqBtm, 1000, RoundingMode.HALF_UP);


		//Summation
		for (int i = 0; i < k; i++) {
			//Factorial.calculate(4 * 1)
			BigInteger topLeftInt = FactorialBig.calculate(BigInteger.valueOf(4).multiply(BigInteger.valueOf(i)));
			BigDecimal topLeftDec = new BigDecimal(topLeftInt);

			//(1103 + (26390 * i))
			BigDecimal topRightDec = (BigDecimal.valueOf(1103).add(BigDecimal.valueOf(26390).multiply(BigDecimal.valueOf(i))));

			//Math.pow(Factorial.calculate(i), 4)
			BigInteger bottomLeftInt = FactorialBig.calculate(BigInteger.valueOf(i)).pow(4);
			BigDecimal bottomLeftDec = new BigDecimal(bottomLeftInt);

			//Math.pow(396, (4 * i))
			BigDecimal bottomRightDec = BigDecimal.valueOf(396).pow(4 * i);

			//Factorial.calculate(4 * 1) * (1103 + (26390 * i))
			BigDecimal topDec = topLeftDec.multiply(topRightDec);
			//Math.pow(Factorial.calculate(i), 4) * Math.pow(396, (4 * i))
			BigDecimal bottomDec = bottomLeftDec.multiply(bottomRightDec);
			//(Factorial.calculate(4 * 1) * (1103 + (26390 * i))) / (Math.pow(Factorial.calculate(i), 4) * Math.pow(396, (4 * i)))
			BigDecimal result = topDec.divide(bottomDec, 1000, RoundingMode.HALF_UP);

			//Holy crap that's a lot of work for some big ints.
			rightFormula = rightFormula.add(result);
		}

		BigDecimal product = rightFormula.multiply(leftFormula);
		return BigDecimal.ONE.divide(product, 1000, RoundingMode.HALF_UP);
	}

	public static double findRoot(double a, double b) {
		double epsilon = 0.00000001;
		double x = ((a + b) / 2);

		if (Math.abs(a - x) < epsilon) {
			return x;
		}

		if ((Math.pow(x, 2) - 2) * (Math.pow(a, 2) - 2) < 0) {
			return findRoot(a, x);
		} else {
			return findRoot(x, b);
		}
	}
}
