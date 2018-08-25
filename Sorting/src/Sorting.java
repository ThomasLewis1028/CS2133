/**
 * Thomas Lewis
 * Computer Science II - CS2133
 * Christopher Crick
 * Sorting.java
 * 	Make a random set of numbers n between 0 and 1 and put them into two
 * 	arrays, then sort one array with bubble sort and one with merge sort,
 * 	then time each of them.  Each time they're completing, create n*10
 * 	more numbers and sort them the same.  If one of them takes too long,
 * 	report the fact, but keep going just to see how long it takes for the
 * 	other to run out of memory.
 *
 * 	Merge sort eventually ends up being much faster because nLogn time is
 * 	so much shorter.  For example, 10log10 is just 10, but with n^2 time
 * 	it's 10*10 which is 100, and grows exponentially faster.  Merge may
 * 	take up more code (at least for my implementation), but it saves a lot
 * 	more time in the long run, and as seen by this program, you're gonna
 * 	run out of memory before it takes longer than 20 seconds to complete
 * 	anything here.  On my machine it took 1,000,000 numbers for bubble sort
 * 	to take too long, and then with 10,000,000, Java ran out of memory on
 * 	the merge sort.
 */
public class Sorting {
	public static int n = 1;
	public static int multiplier = 10000000;

	public static long bubbleStartTime;
	public static long mergeStartTime;

	public static long bubbleEndTime;
	public static long mergeEndTime;

	public static long bubbleSortTime;
	public static long mergeSortTime;

	public static void main(String[] args) {
		while (true) {
			try {
				n *= multiplier;
				double[] arrayB = new double[n];	//Bubble array
				double[] arrayM = new double[n];	//Merge array

				for (int i = 0; i < n; i++) {
					double rand = Math.random();
					arrayB[i] = arrayM[i] = rand;
				}

				System.out.println(n + " numbers: ");

				if (bubbleSortTime < 20000) {
					bubbleStartTime = System.currentTimeMillis();
					bubbleSort(arrayB);
					bubbleSortTime = System.currentTimeMillis() - bubbleStartTime;
					System.out.println("Bubble time: " + bubbleSortTime + "ms");
				}

				if (mergeSortTime < 20000) {
					mergeStartTime = System.currentTimeMillis();
					mergeSort(arrayM);
					mergeSortTime = System.currentTimeMillis() - mergeStartTime;
					System.out.println("Merge time: " + mergeSortTime + "ms");
				}

				for(int i = 0; i < arrayM.length; i++){
					System.out.println(arrayM[i]);
				}

				arrayB = bubbleSort(arrayB);

				for(int i = 0; i < arrayM.length; i++){
					System.out.println(arrayB[i]);
				}

				break;
			}catch(OutOfMemoryError error){
				System.out.println("System ran out of memory with " + n + " items");
				System.exit(0);
			}
		}
	}

	public static double[] bubbleSort(double[] a) {
		boolean swapped = true;

		while (swapped) {
//			if (System.currentTimeMillis() - bubbleStartTime > 20000) {
//				System.out.println("Bubble sort took more than 20 seconds");
//				bubbleEndTime = System.currentTimeMillis();
//				return;
//			}

			swapped = false;

			for (int i = 0; i < a.length - 1; i++) {
				if (a[i] > a[i + 1]) {
					double temp = a[i];
					a[i] = a[i + 1];
					a[i + 1] = temp;
					swapped = true;
				}
			}
		}

		return a;
	}

	public static double[] mergeSort(double[] a) {
//		if (System.currentTimeMillis() - mergeStartTime > 20000) {
//			System.out.println("Merge sort took more than 20 seconds");
//			mergeEndTime = System.currentTimeMillis();
//			return null;
//		}
		boolean swapped = true;
		double[] mergeSorted = new double[a.length];

		if (a.length <= 1) {
			return a;
		}

		double[] a1 = new double[a.length / 2];
		double[] a2 = new double[a.length - (a.length / 2)];

		for(int i = 0; i < a1.length; i++){
			a1[i] = a[i];
		}
		for(int i = 0; i < a2.length; i++){
			a2[i] = a[a1.length+i];
		}

		mergeSort(a1);
		mergeSort(a2);

		mergeSorted = mergeArrays(a1, a2);

		return mergeSorted;
	}

	public static double[] mergeArrays(double[] a1, double[] a2) {
		double[] a = new double[a1.length + a2.length];
		int indexR = 0;
		int indexL = 0;

		for (int i = 0; i < a.length; i++) {
			if (indexR >= a2.length || (indexL < a1.length && a1[indexL] <= a2[indexR])) {
				a[i] = a1[indexL];
				indexL++;
			} else {
				a[i] = a2[indexR];
				indexR++;
			}
		}

		return a;
	}
}
