/**
 * Thomas Lewis
 * Computer Science II - CS2133
 * Christopher Crick
 * Ramanujan.java - Calculate pi to the nth Ramanujan's Series
 */
public class Ramanujan {
	public static void main(String[] args) {
		int k = Integer.parseInt(args[0]);
		double ramanPi = calcRaman(k);

		System.out.println("Pi according to " + k + " iterations of Ramanujan's Series: " + ramanPi );
		System.out.println("This is " + piCompare(ramanPi) + " percent off from Java's Pi value");
	}

	public static double piCompare(double ramanPi) {
		double percentage = ramanPi / Math.PI;
		percentage -= 1;
		percentage *= 100;
		return Math.abs(percentage);
		//Because 1-% can end negative, the abs of it is correct
	}

	public static double calcRaman(int k) {
		double rightFormula = 0;
		double leftFormula = ((2 * Math.sqrt(2)) / 9801);

		//Summation
		for(int i = 0; i < k; i++){
			double rightFormulaTop = ((Factorial.calculate(4 * i)) * (1103 + (26390 * i)));
			double rightFormulaBottom = (Math.pow(Factorial.calculate(i), 4) * Math.pow(396, (4 * i)));
			rightFormula += rightFormulaTop/rightFormulaBottom;
		}

		double product = rightFormula*leftFormula;
		return 1 / product;
	}
}
