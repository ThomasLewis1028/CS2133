import java.math.BigInteger;

public class Problem48 {
	public static void main(String[] args){
		BigInteger sum = BigInteger.ZERO;

		for(int i = 1; i <= 1000; i++){
			BigInteger power = BigInteger.valueOf(i).pow(i);
			sum = sum.add(power);
		}

		String sumString = sum.toString();
		String lastTen = sumString.substring(sumString.length()-10);

		System.out.println(lastTen);
	}
}
