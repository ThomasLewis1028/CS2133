import java.io.*;

/**
 * Thomas Lewis
 * Computer Science II - CS2133
 * Christopher Crick
 * Caesar.java
 * 	Encode a file in only the most secure way possible, no one could
 * 	possibly decrypt any files encrypted by this algorithm.  Includes
 * 	a test.txt file that includes every possible character in order of
 * 	their value to easily check if it shifted properly.
 */

public class Caesar {
	public static void main(String[] args) {
		try {
			int seed = Integer.parseInt(args[0]);
			File infile = new File(args[1]);
			File outfile;

			BufferedReader in = new BufferedReader(new FileReader(infile));
			Cypher cypher = new Cypher();
			StringBuilder output = cypher.encrypt(in, seed);

			try {
				if (args.length > 2) {
					outfile = new File(args[2]);
					BufferedWriter out = new BufferedWriter(new FileWriter(outfile));
					out.append(output);
					out.close();
				}
			} catch (FileNotFoundException e) {
				System.out.println("File not found");
			} catch (IOException e) {
				e.printStackTrace();
			}

			System.out.println(output);

		} catch (FileNotFoundException e) {
			System.out.println("File not found");
		} catch (ArrayIndexOutOfBoundsException e){
			System.out.println("Usage: java Caesar <x> <filename> <optional write file>");
		}
	}
}