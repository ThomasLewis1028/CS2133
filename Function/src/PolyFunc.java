/**
 * Thomas Lewis
 * Computer Science II - CS2133
 * Christopher Crick
 * PolyFunc.java - A function to create, evaluate, add, and print out
 * polynomials.  Creates, prints,
 */
public class PolyFunc extends Function {
	private int[] coefficients;

	/**@param coefficients set the private coefficients
	 * value to the value given to it when a PolyFunc object is created.
	 */
	public PolyFunc(int[] coefficients) {
		this.coefficients = coefficients;
	}

	/**@return the largest coefficient, that being length-1
	 */
	public int degree() {
		return this.coefficients.length - 1;
	}

	/**@return the written value of the polynomials, ie 2x^2 + 4x - 5
	 */
	public String toString() {
		String polyString = "";

		for (int i = this.coefficients.length - 1; i >= 0; i--) {
			if (this.coefficients[i] == 0) {
				//Skip the current value to avoid getting 0x^3 and the like
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

	/**@param a Add Poly a to another Poly this, this.add(a)
	 * @return a new Poly object that is the sum of Poly this and Poly a
	 */
	public PolyFunc add(PolyFunc a) {
		if(a.coefficients.length > this.coefficients.length){
			int[] polySum = new int[a.coefficients.length];

			for(int i = 0; i <= this.coefficients.length-1; i++){
				polySum[i] = this.coefficients[i] + a.coefficients[i];
			}

			for(int i = this.coefficients.length; i < a.coefficients.length; i++){
				polySum[i] = a.coefficients[i];
			}

			PolyFunc newPoly = new PolyFunc(polySum);
			return newPoly;
		}else{
			int[] polySum = new int[this.coefficients.length];

			for(int i = 0; i <= a.coefficients.length-1; i++){
				polySum[i] = this.coefficients[i] + a.coefficients[i];
			}

			for(int i = a.coefficients.length; i < this.coefficients.length; i++){
				polySum[i] = this.coefficients[i];
			}

			PolyFunc newPoly = new PolyFunc(polySum);
			return newPoly;
		}
	}

	/**@param x Multiply coefficients[i] by value x to receive a solution to the polynomial
	 * @return the value of inserting a number x into the polynomial
	 */
	public double evaluate(double x) {
		double value = 0;

		for (int i = 0; i < this.coefficients.length; i++) {
			//Multiply the current coefficient by x^i, add to value.
			value += this.coefficients[i] * Math.pow(x, i);
		}
		return value;
	}
}
