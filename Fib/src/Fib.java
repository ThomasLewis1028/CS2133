import java.math.BigInteger;

/**
 * Thomas Lewis
 * Computer Science II - CS2133
 * Christopher Crick
 * Fib.java - Calculate a Fibonacci sequence to the Nth number in the sequence
 */
public class Fib {
	public static void main(String[] args) {
		BigInteger num1 = BigInteger.valueOf(1);
		BigInteger num2 = BigInteger.valueOf(1);
		BigInteger numsComb = BigInteger.valueOf(0);
		/**I used BigInt on these because I noticed larger Fibonacci numbers
		 * like 100 were becoming "wrong" as they'd hit the int or Long Int
		 * caps and would wrap around.  So I found BigInt and implemented this
		 * instead.  However, this could potentially crash a program when you
		 * hit the JVM limit, 800,000 was 160k digits and took a few seconds.
		 * 80,000,000 with 16million digits went for 5 minutes before I killed it.
		 */
		int fibSeqNum = Integer.parseInt(args[0]);

		//Print 1 for the first two in the sequence
		if (fibSeqNum < 3) {
			System.out.println(1);
		} else {
			for (int i = 3; i <= fibSeqNum; i++) {  //Start at 3 to ignore the first two
				numsComb = num1.add(num2);
				num1 = num2;
				num2 = numsComb;
			}
		}

		System.out.println(numsComb);
	}
}
