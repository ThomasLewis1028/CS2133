import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.*;

/**
 * Created by Thomas on 11/10/2016.
 */
public class Huff {

	public static void main(String[] args) {
		Map<Byte, Integer> byteMapInt;
		Map<Byte, String> byteMapString = new HashMap<>();

		String inFile = args[0];
		FileInputStream in;
		FileOutputStream outFile;
		ObjectOutputStream outObject;
		byte[] byteArray;

		try {
			in = new FileInputStream(inFile);
			int c;
			byteArray = new byte[in.available()];
			int j = 0;

			while ((c = in.read()) != -1) {
				byteArray[j] = (byte) c;

				j++;
			}
			in.close();

			byteMapInt = fileToBytes(byteArray);
			Node tree = buildNodeTree(byteMapInt);
			setBytes(tree, byteMapString);

			String byteString = "";
			for (int i = 0; i < byteArray.length; i++) {
				byteString += byteMapString.get(byteArray[i]);
			}

			outFile = new FileOutputStream(inFile + ".huff");
			outObject = new ObjectOutputStream(outFile);

			outObject.writeObject(tree);
			outObject.writeObject(getBitSet(byteString));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	//Convert the file into bytes and put the bytes into the HashMap
	public static Map<Byte, Integer> fileToBytes(byte[] b) {
		Map<Byte, Integer> byteList = new HashMap<>();

		for (int i = 0; i < b.length; i++) {
			if (byteList.containsKey(b[i])) {
				int n = byteList.get(b[i]);
				byteList.put(b[i], n + 1);
			} else {
				byteList.put(b[i], 1);
			}
		}

		return byteList;
	}

	private static Queue<Node> createNodeQueue(Map<Byte, Integer> map) {
		final Queue<Node> pq = new PriorityQueue<>(1, new NodeCompare());
		for (Map.Entry<Byte, Integer> entry : map.entrySet()) {
			pq.add(new Node(entry.getKey(), entry.getValue(), null, null));
		}
		return pq;
	}

	private static Node buildNodeTree(Map<Byte, Integer> map) {
		final Queue<Node> nodeQueue;
		nodeQueue = createNodeQueue(map);

		while (nodeQueue.size() > 1) {
			final Node node1 = nodeQueue.remove();
			final Node node2 = nodeQueue.remove();
			Node node = new Node((byte) 0, node1.frequency + node2.frequency, node1, node2);
			nodeQueue.add(node);
		}

		return nodeQueue.remove();
	}

	private static void setBytes(Node n, Map<Byte, String> h) {
		//Put the byte and the location into the map, provided the byte isn't a 0
		if (n.aByte != 0)
			h.put(n.aByte, n.location);

		//Go down the tree and set the right child location equal to the current location + 1
		if (n.rightCh != null) {
			n.rightCh.location += n.location + "1";
			setBytes(n.rightCh, h);
		}

		//Go down the tree and set the left child location equal to the current location + 0
		if (n.leftCh != null) {
			n.leftCh.location += n.location + "0";
			setBytes(n.leftCh, h);
		}
	}

	private static BitSet getBitSet(String message) {
		final BitSet bitSet = new BitSet();
		int i = 0;
		//Create the bitset from the String of "bits" where 0 is false and 1 is true
		for (i = 0; i < message.length(); i++) {
			if (message.charAt(i) == '0') {
				bitSet.set(i, false);
			} else {
				bitSet.set(i, true);
			}
		}
		bitSet.set(i, true);
		return bitSet;
	}

	//Compare two nodes
	public static class NodeCompare implements Comparator<Node> {
		public int compare(Node node1, Node node2) {
			return node1.frequency - node2.frequency;
		}
	}
}

