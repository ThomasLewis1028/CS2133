/**
 * Thomas Lewis
 * Computer Science II - CS2133
 * Christopher Crick
 */

import java.util.Scanner;

public class Average {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numCount = 0;
        double sumTotal = 0;
        double currentNum = 0;
        double average;

        System.out.println("Please input numbers, use a negative number to stop input");

        while (currentNum >= 0) {
            currentNum = scanner.nextDouble();

            if (currentNum >= 0) {
                sumTotal += currentNum;
                numCount++;
            }
        }

        average = sumTotal / numCount;

        System.out.println("The average of your " + numCount + " numbers is " + average);
    }
}
