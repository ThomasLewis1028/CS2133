/**
 * Created by Thomas on 10/27/2016.
 */
public class Problem7 {
	public static void main(String[] args) {
		int count = 1;
		int prime = 1;
		while (count <= 10001) {
			boolean isPrime = true;
			int root = (int) Math.round(Math.pow(prime, .5) + .5);
			for (int i = root; i >= 2; i--) {
				if (prime % i == 0) {
					isPrime = false;
				}
			}
			if (isPrime == true) {
				prime++;
				count++;
			} else {
				prime++;
			}
		}

		System.out.println(prime-1);	// prime-1 to account for the excess after stopping the while loop.
	}
}
