import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Created by thoma on 10/8/2016.
 */
public class Cypher {
	public StringBuilder encrypt(BufferedReader clearText, int seed) {
		int charValue;
		StringBuilder encryptedText = new StringBuilder();
		try {
			while ((charValue = clearText.read()) != -1) {
				encryptedText.append((char) cypher(seed, charValue));
			}
		} catch (FileNotFoundException e) {
			System.out.println("File not found");
		} catch (IOException e) {
			e.printStackTrace();
		}

		return encryptedText;
	}

	private int cypher(int shift, int charValue) {
		int returnValue;
		if (charValue < 32 || charValue > 126) {
			returnValue = charValue;
		} else if (shift >= 0) {    //Positive Shift
			if (charValue + shift > 126) {
				int excessShift = (charValue + shift) - 126;
				while (excessShift + 31 > 126) {
					excessShift = (excessShift + 31) - 126;
				}
				returnValue = excessShift + 31;
			} else {
				returnValue = charValue + shift;
			}


		} else if (shift < 0) {    //Negative Shift
			if (charValue + shift < 32) {
				int excessShift;
				if ((charValue + shift) - 32 < 0) {
					excessShift = (charValue + shift) - 32;
				} else {
					excessShift = Math.abs(charValue + shift) - 32;
				}
				int test = 127 + excessShift;
				while (127 + excessShift < 32) {
					excessShift = 127 - (32 - excessShift);
				}

				returnValue = 127 + excessShift;

			} else {
				returnValue = charValue + shift;
			}
		} else {
			returnValue = charValue + shift;
		}

		return returnValue;

	}
}
