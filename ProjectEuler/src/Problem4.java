public class Problem4 {
	public static void main(String[] args) {
		int num1;
		int num2;
		int pal = 0;

		for (num1 = 999; num1 > 100; num1--) {
			for (num2 = 999; num2 > 100; num2--) {
				int numProd = num1 * num2;

				if(isPalindrome(numProd)){
					if(pal < numProd){
						pal = numProd;
					}
				}
			}
		}

		System.out.println(pal);
	}

	public static boolean isPalindrome(int n) {
		String num = Integer.toString(n);
		int numLength = num.length();
		for (int i = 0; i < numLength / 2; i++) {
			if (num.charAt(i) != num.charAt(numLength - (i + 1))) {
				return false;
			}
		}

		return true;
	}
}
