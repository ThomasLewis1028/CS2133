import java.util.ArrayList;
import java.util.List;

/**
 * Thomas Lewis
 * Christopher Crick
 * Computer Science II
 * November 16, 2016
 * Permutations.java
 * 	Receive a list of anything E and calculate the number of permutations
 * 	possible and return those values to be printed or handled via tests.
 */
public class Permutations<E> {
	private int i=0;
	private int totalPerms;
	private int count;
	private List<E> L;
	private Permutations<E> P;
	private E c;

	public Permutations(List<E> n) {
		if (n == null || n.size() == 0) {
			totalPerms = 1;
			count = 1;
		} else {
			totalPerms = 1;

			for (int i = 1; i <= n.size(); i++) {
				totalPerms = totalPerms * i;
			}

			L = new ArrayList<>(n);
			c = L.get(0);
			L.remove(0);

			if (L.size() > 1) {
				P = new Permutations<>(L);
				if (P.hasNext())
					L = P.next();
			}

		}
	}

	public boolean hasNext() {
		return (count < totalPerms);
	}

	public List<E> next() {
		count++;

		if (i > L.size()) {
			i = 0;
			L = P.next();
		}

		List<E> newList = new ArrayList<>(L);
		newList.add(i, c);
		i++;
		return newList;
	}
}