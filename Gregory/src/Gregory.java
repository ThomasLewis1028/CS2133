/**
 * Thomas Lewis
 * Computer Science II - CS2133
 * Christopher Crick
 * Gregory.java - Calculate Pi using Gregory's Series to the Nth series
 */
public class Gregory {
    public static void main(String[] args) {
        int nSeries = Integer.parseInt(args[0]);
        double piCalc = 0;

        for (int i = 1; i <= nSeries; i++) {
            double denom = i * 2 - 1;
            //The denominator follows a pattern of x*2-1, so 2*2-1 = 3, 3*2-1 = 5 etc.

            if (i % 2 != 0) { //Addition/Subtraction pattern of even series being subtraction
                piCalc += 1 / denom;
            } else {
                piCalc -= 1 / denom;
            }
        }

        piCalc = piCalc * 4;

        System.out.println("Pi according to " + nSeries + " iterations of Gregory's Series: " + piCalc);
        System.out.println("This is " + piCompare(piCalc) + " percent off from Java's Pi value");
    }

    public static double piCompare(double gregPi) {
        double percentage = gregPi / Math.PI;
        percentage -= 1;
        percentage *= 100;
        return Math.abs(percentage);
        //Because 1-% can end negative, the abs of it is correct
    }
}
