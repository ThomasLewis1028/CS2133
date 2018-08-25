/**
 * Thomas Lewis
 * Computer Science II - CS2133
 * Christopher Crick
 * Poly.java - A function to create, evaluate, add, and print out
 * polynomials.
 */
public class Poly {
	private int[] coefficients;

	public static void main(String[] args) {
		//Take only arguments from the command line, use =X to set your X value
		if (args.length > 0) {
			//Use a regular expression to find =X
			if(args[args.length-1].matches("=(\\d)")){
				int coefficients[] = new int[args.length-1];
				//Remove = from the string leaving the xValue
				String xValue = args[args.length-1].replaceAll("=", "");

				for (int i = 0; i < args.length-1; i++) {
					coefficients[i] = Integer.parseInt(args[i]);
				}

				Poly polyCmdArgs = new Poly(coefficients);
				double polyCmdValue = polyCmdArgs.evaluate(Integer.parseInt(xValue));
				System.out.println("Polynomial: " + polyCmdArgs.toString()
						+ "\nHighest Degree: " + polyCmdArgs.degree());
				System.out.println("f(" + xValue + ") = " + polyCmdValue);
				return;	//End program if you input arguments
			}else {
				int coefficients[] = new int[args.length];
				for (int i = 0; i < args.length; i++) {
					coefficients[i] = Integer.parseInt(args[i]);
				}

				Poly polyCmdArgs = new Poly(coefficients);
				System.out.println("Polynomial: " + polyCmdArgs.toString()
						+ "\nHighest Degree: " + polyCmdArgs.degree());
				return;    //End program if you input arguments
			}
		}

		//2x^5 + 3x^4 - 8x^2 + 4
		int[] test1 = {4, 0, -8, 0, 3, 2};
		double test1Sol = 1406.625;
		Poly polyTest1 = new Poly(test1);
		double test1Value = polyTest1.evaluate(3.5);
		System.out.println("PolyTest1: " + polyTest1 + "\nHighest Degree: " + polyTest1.degree());
		if (test1Value != test1Sol) {
			System.out.println("Test 1 failed, value = " + test1Value);
		} else {
			System.out.println("Test 1 passed, f(3.5) = " + test1Value);
		}

		//6x^3 + 5x + 2
		int[] test2 = {2, 5, 0, 6};
		double test2Sol = 29.75;
		Poly polyTest2 = new Poly(test2);
		double test2Value = polyTest2.evaluate(1.5);
		System.out.println("\nPolyTest1: " + polyTest2 + "\nHighest Degree: " + polyTest2.degree());
		if (test2Value != test2Sol) {
			System.out.println("Test 2 failed, value = " + test2Value);
		} else {
			System.out.println("Test 2 passed, f(1.5) = " + test2Value);
		}

		//2x^9 + 3x^7 + 15x^6 + 106x^4 - 126x^3 - 78x^2 + 634x + 4561
		int[] test3 = {4561, 634, -78, -126, 106, 0, 15, 3, 0, 2};
		double test3Sol = 4431281;
		Poly polytest3 = new Poly(test3);
		double test3Value = polytest3.evaluate(5);
		System.out.println("\nPolyTest1: " + polytest3 + "\nHighest Degree: " + polytest3.degree());
		if (polytest3.evaluate(5) != test3Sol) {
			System.out.println("Test 3 failed, value = " + test3Value);
		} else {
			System.out.println("Test 3 passed, value f(5) = " + test3Value);
		}

		int[] test4Small = {1, 2, 3, 4, 5};
		int[] test4Large = {1, 2, 3, 4, 5, 12, 14, 16, 18};
		double test4Sol = 7.9140625;
		Poly polytest4Small = new Poly(test4Small);
		Poly polytest4Large = new Poly(test4Large);
		Poly polytest4Sum = polytest4Small.add(polytest4Large);
		double test4Value = polytest4Sum.evaluate(.5);
		System.out.println("\nPolytest4Sum: " + polytest4Sum + "\nHighest Degree: " + polytest4Sum.degree());
		if (polytest4Sum.evaluate(.5) != test4Sol) {
			System.out.println("Test 4 failed, value = " + test4Value);
		} else {
			System.out.println("Test 4 passed, f(.5) = " + test4Value);
		}


		int[] test5Small = {-1, 2, -3, 4, -5};
		int[] test5Large = {1, 2, 3, 4, 5, 12, 14, 16, 18};
		double test5Sol = 8008;
		Poly polytest5Small = new Poly(test5Small);
		Poly polytest5Large = new Poly(test5Large);
		Poly polytest5Sum = polytest5Large.add(polytest5Small);
		double test5Value = polytest5Sum.evaluate(2);
		System.out.println("\nPolytest5Sum: " + polytest5Sum + "\nHighest Degree: " + polytest5Sum.degree());
		if (polytest5Sum.evaluate(2) != test5Sol) {
			System.out.println("Test 5 failed, value = " + test5Value);
		} else {
			System.out.println("Test 5 passed, f(2) = " + test5Value);
		}
	}

	public Poly(int[] coefficients) {
		this.coefficients = coefficients;

	}

	public int degree() {
		return this.coefficients.length - 1;
	}

	public String toString() {
		String polyString = "";

		for (int i = this.coefficients.length - 1; i >= 0; i--) {
			if (this.coefficients[i] == 0) {
				continue;
			}

			if (i == 0) {    //Just add the number on i=0 for the x^0
				if (this.coefficients[i] < 0) {
					polyString += " - ";
					polyString += Math.abs(this.coefficients[i]);
				} else if (this.coefficients[i] > 0) {
					polyString += " + ";
					polyString += this.coefficients[i];
				}
			} else if (i == 1) {    //Drop the x^1 for just x
				if (this.coefficients[i] < 0) {
					polyString += " - ";
					polyString += Math.abs(this.coefficients[i]) + "x";
				} else if (this.coefficients[i] > 0) {
					polyString += " + ";
					polyString += this.coefficients[i] + "x";
				}
			} else if (i != this.coefficients.length - 1) {    //Add coefficient[i] + x^i
				if (this.coefficients[i] < 0) {
					polyString += " - ";
					polyString += Math.abs(this.coefficients[i]) + "x^" + i;
				} else if (this.coefficients[i] > 0) {
					polyString += " + ";
					polyString += this.coefficients[i] + "x^" + i;
				}
			} else {    //Left most coefficient
				polyString += this.coefficients[i] + "x^" + i;
			}

		}
		return polyString;
	}

	public Poly add(Poly a) {
		if(a.coefficients.length > this.coefficients.length){
			int[] polySum = new int[a.coefficients.length];

			for(int i = 0; i <= this.coefficients.length-1; i++){
				polySum[i] = this.coefficients[i] + a.coefficients[i];
			}

			for(int i = this.coefficients.length; i < a.coefficients.length; i++){
				polySum[i] = a.coefficients[i];
			}

			Poly newPoly = new Poly(polySum);
			return newPoly;
		}else{
			int[] polySum = new int[this.coefficients.length];

			for(int i = 0; i <= a.coefficients.length-1; i++){
				polySum[i] = this.coefficients[i] + a.coefficients[i];
			}

			for(int i = a.coefficients.length; i < this.coefficients.length; i++){
				polySum[i] = this.coefficients[i];
			}

			Poly newPoly = new Poly(polySum);
			return newPoly;
		}
	}

	public double evaluate(double x) {
		double value = 0;

		for (int i = 0; i < this.coefficients.length; i++) {
			//Multiply the current coefficient by x^i, add to value.
			value += this.coefficients[i] * Math.pow(x, i);
		}
		return value;
	}
}
