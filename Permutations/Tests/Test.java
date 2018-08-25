import junit.framework.TestCase;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test extends TestCase {
	public void testPermutations() {
//		int totalPerms = 1;
//		int actualPerms = 0;
		List<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3));

//		for (int i = 1; i <= list.size(); i++) {
//			totalPerms = totalPerms * i;
//		}

//		System.out.println("Total perms:" + totalPerms);
		Permutations<Integer> permutations = new Permutations<>(list);

		while (permutations.hasNext()) {
//			actualPerms++;
//			List<Integer> ret = permutations.next();
			System.out.println(permutations.next());
		}

//		assertEquals(totalPerms, actualPerms);
	}

	public void testTwo() {
		List<Integer> list;
		List<Integer> list2;
		List<Integer> list3;

		list = new ArrayList<Integer>(Arrays.asList(15, 54, 2));
		list2 = list;
		System.out.println(list);
		System.out.println(list2);

		list2.remove(0);
		System.out.println(list);
		System.out.println(list2);

		list3 = new ArrayList<>(list);
		System.out.println(list);
		System.out.println(list2);
		System.out.println(list3);

		list3.add(6);

		System.out.println(list);
		System.out.println(list2);
		System.out.println(list3);
	}
}