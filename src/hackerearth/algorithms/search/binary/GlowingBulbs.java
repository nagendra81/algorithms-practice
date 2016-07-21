package hackerearth.algorithms.search.binary;

import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class GlowingBulbs {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int t = 0; t < T; t++) {
			String s = sc.next();
			long K = sc.nextLong();
			solve(s, K);
		}
	}

	private static void solve(String s, long K) {

		PriorityQueue<Bulb> q = new PriorityQueue<>();

		for (int i = 0; i < s.toCharArray().length; i++) {
			if (s.charAt(i) == '1') {
				q.add(new Bulb(i + 1, i + 1));
			}
		}

		long prev = -1;
		long bid = -1;
		while (!q.isEmpty()) {
			// System.out.println(q);
			Bulb b = q.remove();
			bid = b.id;
			for (int m : b.mulSet) {
				b.set(b.id + m);
				q.add(b);
			}

			if (bid != prev) {
				K--;
			}

			if (K == 0) {
				System.out.println(bid);
				break;
			}
			prev = bid;

		}

		// System.out.println(q);

	}

	static class Bulb implements Comparable<Bulb> {
		long id;
		Set<Integer> mulSet = new TreeSet<>();

		Bulb(long id, int mul) {
			this.id = id;
			this.mulSet.add(mul);
		}

		@Override
		public int compareTo(Bulb b) {
			return Long.compare(this.id, b.id);
		}

		@Override
		public boolean equals(Object obj) {
			Bulb that = (Bulb) obj;

			return this.id == that.id && this.mulSet.equals(that.mulSet);
		}

		@Override
		public int hashCode() {
			return Long.valueOf(id).hashCode();
		}

		public void set(long id) {
			this.id = id;
		}

		@Override
		public String toString() {
			return String.format("id=%d, mul=%s", id, mulSet.toString());
		}
	}

}