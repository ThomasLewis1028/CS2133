/**
 * Created by Thomas on 10/28/2016.
 */
public class Problem45 {
	public static void main(String[] args) {
		long nt = 286;    //Start one higher than the given value in the problem
		long np = 166;
		long nh = 144;
		long t = Triangle(nt);
		long p = Pentagonal(np);
		long h = Hexagonal(nh);

		while (t != p || p != h) {
			if (t <= p && t <= h) {
				nt++;
			} else if (p <= t && p <= h) {
				np++;
			} else if (h <= t && h <= p) {
				nh++;
			}
			t = Triangle(nt);
			p = Pentagonal(np);
			h = Hexagonal(nh);
		}

		System.out.println(t);
	}

	public static long Triangle(long n) {
		return (n * (n + 1)) / 2;
	}

	public static long Pentagonal(long n) {
		return (n * ((3 * n) - 1)) / 2;
	}

	public static long Hexagonal(long n) {
		return n * ((2 * n) - 1);
	}
}
