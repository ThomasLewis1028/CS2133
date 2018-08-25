/**
 * Thomas Lewis
 * Computer Science II - CS2133
 * Christopher Crick
 * FibTest.java - Calculate Fibonacci sequence to the nth, with tests
 */
public class FibTest {
	public static void main(String[] args) {
		/**Array that holds 5 tests with the test number, n value, and desired output
		 * I pulled the values from an online Fibonacci calculator to ensure they were correct
		 */
		int[][] testArray = {{1, 1, 1}, {2, 2, 1}, {3, 5, 5}, {4, 10, 55}, {5, 25, 75025}};

		for (int i = 0; i < testArray.length; i++) {
			//fibIter tests
			if (fibIter(testArray[i][1]) == testArray[i][2]) {
				System.out.println("fibter Test " + (i + 1) + " passed");
			}else{
				System.out.println("fibter Test " + (i + 1) + " passed");
			}

			//fibRecur tests
			if (fibRecur(testArray[i][1]) == testArray[i][2]) {
				System.out.println("fibRecur Test " + (i + 1) + " passed");
			}else{
				System.out.println("fibRecur Test " + (i + 1) + " failed");
			}

		}

		//fibIter 0 to 40
		long fibIterStart = System.currentTimeMillis();
		if (fibIter(40) == 102334155) {
			long fibIterTime = System.currentTimeMillis() - fibIterStart;
			System.out.println("fibIter = 40 test completed in " + fibIterTime + " milliseconds");
		}

		//fibRecru 0 to 40
		long fibRecurStart = System.currentTimeMillis();
		if (fibRecur(40) == 102334155) {
			long fibRecurTime = System.currentTimeMillis() - fibRecurStart;
			System.out.println("fibRecur = 40 test complete in " + fibRecurTime + " milliseconds");
		}

		//If you still want to input things from the command line.
		if (args.length > 0) {
			int n = Integer.parseInt(args[0]);
			System.out.println("\n" + n + " Iterations \nfibIter: " + fibIter(n) + "\nfibRecur: " + fibRecur(n));
		}
	}

	public static int fibIter(int n) {
		int num1 = 1;
		int num2 = 1;
		int numsComb = 0;

		if (n < 3) {
			return 1;
		} else {
			for (int i = 3; i <= n; i++) {
				numsComb = num1 + num2;
				num1 = num2;
				num2 = numsComb;
			}
		}

		return numsComb;
	}

	public static int fibRecur(int n) {
		if (n == 1 || n == 2) {
			return 1;
		} else {
			return (fibRecur(n - 1) + fibRecur(n - 2));
		}
	}
}