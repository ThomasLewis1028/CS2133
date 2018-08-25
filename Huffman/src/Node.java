import java.io.Serializable;

/**
 * Created by Thomas on 11/11/2016.
 */
public class Node implements Serializable{
	byte aByte;
	int frequency;
	Node leftCh;
	Node rightCh;
	String location = "";

	/**
	 * Receive a byte, an int, and two Nodes to set the current byte
	 * value, the frequency of said byte value, and then two children
	 *
	 * @param aByte The current byte value of a given Node
	 * @param frequency The frequency of said byte value
	 * @param leftCh The left child Node
	 * @param rightCh The right child Node
	 */
	Node(byte aByte, int frequency, Node leftCh, Node rightCh) {
		this.aByte = aByte;
		this.frequency = frequency;
		this.leftCh = leftCh;
		this.rightCh = rightCh;
	}

	@Override
	//toString method for testing purposes
	public String toString() {
		return "(" + aByte + ") - " + frequency +
				"\n\t(" + rightCh + ")" +
				"\n\t(" + leftCh + ")";
	}
}