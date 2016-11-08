package hackerearth.algorithms.problems;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class RhezoDiv7 {
	static int BLOCK_SIZE = 0;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		char[] arr = sc.next().toCharArray();

		int Q = sc.nextInt();
		BLOCK_SIZE = (int) Math.sqrt(Q);
		PriorityQueue<Query> pq = new PriorityQueue<>();

		for (int i = 0; i < Q; i++) {
			Query q = new Query(i, sc.nextInt() - 1, sc.nextInt() - 1);
			pq.add(q);
		}

		boolean[] res = new boolean[Q];
		int L = 0;
		int R = 0;
		while (!pq.isEmpty()) {
			Query currQ = pq.remove();

			while (L < currQ.lo) {

				L++;
			}
			while (L > currQ.lo) {

				L--;
			}
			while (R < currQ.hi) {

				R++;
			}

			while (R > currQ.hi) {

				R--;
			}

			char[] num = Arrays.copyOfRange(arr, L, R + 1);
			BigInteger bi = new BigInteger(String.valueOf(num));
			// System.out.println(String.valueOf(s));
			// long v = Long.valueOf(String.valueOf(s));
			if (bi.mod(BigInteger.valueOf(7)) == BigInteger.ZERO) {
				res[currQ.id] = true;
			}

		}

		for (boolean b : res) {
			if (b) {
				System.out.println("YES");
			} else {
				System.out.println("NO");
			}
		}

	}

	static class Query implements Comparable<Query> {
		int id;
		int lo;
		int hi;

		Query(int id, int lo, int hi) {
			this.id = id;
			this.lo = lo;
			this.hi = hi;

		}

		@Override
		public int compareTo(Query that) {
			int L1 = this.lo / BLOCK_SIZE;
			int L2 = that.lo / BLOCK_SIZE;
			if (L1 == L2) {
				return Integer.compare(this.hi, that.hi);
			} else {
				return Integer.compare(L1, L2);
			}
		}

	}
}
