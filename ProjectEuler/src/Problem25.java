import java.math.BigInteger;

public class Problem25 {
	public static void main(String[] args) {
		BigInteger num1 = BigInteger.valueOf(1);
		BigInteger num2 = BigInteger.valueOf(1);
		BigInteger numsComb;
		String numsString;
		int fTerm = 2;

		do{
			numsComb = num1.add(num2);
			num1 = num2;
			num2 = numsComb;

			numsString = numsComb.toString();
			fTerm++;
		}while(numsString.length() < 1000 );	//Big integers are mean

		System.out.println(fTerm);
	}
}
