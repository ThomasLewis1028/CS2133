/**
 * Created by Thomas on 10/27/2016.
 */
public class Problem17 {
	public static void main(String[] args) {
		int oneThruNine = 3 + 3 + 5 + 4 + 4 + 3 + 5 + 5 + 4;
		int tenThruNineTeen = 3 + 6 + 6 + 8 + 8 + 7 + 7 + 9 + 8 + 8;
		int twentyThruNinetyNine = 10 * (6 + 6 + 5 + 5 + 5 + 7 + 6 + 6) + 8 * oneThruNine;
		int hundred = 7;
		int hundredAnd = 10;
		int hundredThru999 = (oneThruNine * 100) +
				(9 * (oneThruNine + tenThruNineTeen + twentyThruNinetyNine)) +
				(hundred * 9) +
				(hundredAnd * 9 * 99);
		int oneThousand = 11;
		int letterCount = oneThruNine + tenThruNineTeen + twentyThruNinetyNine + hundredThru999 + oneThousand;
		System.out.println(letterCount);
	}
}
