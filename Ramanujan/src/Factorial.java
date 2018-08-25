/**
 * Thomas Lewis
 * Computer Science II - CS2133
 * Christopher Crick
 * Factorial.java - Calculate a factorial to the Nth with recursion
 */
public class Factorial {
    public static long calculate(long n){
        if(n == 0){
            return 1;
        }else {
            return (n * calculate(n-1));
        }
    }

    public static void main(String[] args){
        long n = Long.parseLong(args[0]);
        if(n < 0 || n > 20){
            System.out.println("Please enter a number between 0 and 20");
            return;
        }

        if(calculate(0) == 1){
            System.out.println("Test 1 passed");
        }else{
            System.out.println("Test 1 failed");
        }

        if(calculate(5) == 120){
            System.out.println("Test 2 passed");
        }else{
            System.out.println("Test 2 failed");
        }

        System.out.println(calculate(n));
    }
}
