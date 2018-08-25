public class Problem2 {
	public static void main(String[] args) {
		long fib1 = 1;
		long fib2 = 1;
		long fibEvenSum = 0;
		long fibTotal = 0;

		while (fibTotal < 4000000) {
			fibTotal = fib1 + fib2;
			fib1 = fib2;
			fib2 = fibTotal;

			if ((fibTotal % 2) == 0) {
				fibEvenSum += fibTotal;
			}
		}

		System.out.println(fibEvenSum);
	}
}
