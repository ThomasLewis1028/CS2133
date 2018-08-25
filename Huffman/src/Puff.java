import java.io.*;
import java.util.BitSet;

/**
 * Created by Thomas on 11/10/2016.
 */
public class Puff {
	public static void main(String[] args) {
		Node tree;
		BitSet bitSet;

		try {
			String outFileName = args[0].replace(".huff", "");
			FileInputStream inFile = new FileInputStream(args[0]);
			ObjectInputStream inObject = new ObjectInputStream(inFile);
			FileOutputStream outFile = new FileOutputStream(outFileName);

			//Read the tree from the tree object stored in the .puff file
			tree = (Node) inObject.readObject();
			//Read the bitSet into here
			bitSet = (BitSet) inObject.readObject();

			//Go through and add the aByte of the current temp to the outFile
			for (int i = 0; i < bitSet.length() - 1; ) {
				Node temp = tree;

				while (temp.leftCh != null) {
					if (!bitSet.get(i))
						temp = temp.leftCh;
					else
						temp = temp.rightCh;
					i++;
				}
				outFile.write(temp.aByte);
			}

			outFile.flush();
			outFile.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
