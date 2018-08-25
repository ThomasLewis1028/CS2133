/**
 * Created by Thomas on 10/28/2016.
 */
public class Problem5 {
	public static void main(String[] args){
		int num = 2520;
		boolean isGud = false;
		while(isGud == false){
			for (int i = 1; i <= 20; i++){
				if(!(num % i == 0)){
					isGud = false;
					num+=2;
					break;
				}else isGud = true;
			}
		}

		System.out.println(num);
	}
}
