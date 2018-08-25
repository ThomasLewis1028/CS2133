/**
 * Created by Thomas on 10/28/2016.
 */
public class Problem50 {
	public static void main(String[] args) {
		long sum = 0L;
		int count = 0;
		int prime = 1;

		while (count < 1000000) {
			if (isPrime(count)) {
				prime = count;
			}
			if (isPrime(prime)) {
				count++;
				sum += prime;
			} else {
				count++;
			}
		}

		System.out.println(prime -1);    // prime-1 to account for the excess after stopping the while loop.
	}

	public static boolean isPrime(long n){
		int root = (int) Math.round(Math.pow(n, .5) + .5);
		for (int i = root; i >= 2; i--) {
			if (n % i == 0) {
				return false;
			}
		}
		return true;
	}
}
