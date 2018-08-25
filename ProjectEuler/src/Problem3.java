/**
 * Created by Thomas on 10/27/2016.
 */
public class Problem3 {
	public static void main(String[] args) {
		long num = 600851475143L;

		for(long n = 3; n < num; n+=2){
			while(num % n == 0){
				num = num / n;
			}
		}

		System.out.println(num);
	}
}
