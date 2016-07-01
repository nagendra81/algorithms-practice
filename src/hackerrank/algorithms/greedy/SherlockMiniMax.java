package hackerrank.algorithms.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;

public class SherlockMiniMax {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		int[] A = new int[N];

		String[] line = br.readLine().split(" ");

		for (int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(line[i]);
		}

		line = br.readLine().split(" ");
		int P = Integer.parseInt(line[0]);
		int Q = Integer.parseInt(line[1]);

		solve(A, P, Q);

	}

	private static void solve(int[] a, int p, int q) {

		Set<Integer> pq = getPQ(a, p, q);

		long res = Long.MIN_VALUE;
		long resM = 0;
		for (int i : pq) {
			long t = getMin(a, i);
			if (t > res) {
				res = t;
				resM = i;
			}
		}
		System.out.println(resM);

	}

	private static Set<Integer> getPQ(int[] a, int p, int q) {
		Arrays.sort(a);
		Set<Integer> pq = new TreeSet<>();
		pq.add(p);
		pq.add(q);

		for (int i = 1; i < a.length; i++) {
			int avg = (a[i - 1] + a[i]) / 2;
			if (avg >= p && avg <= q) {
				pq.add(avg);
			}
			if ((avg - 1) >= p && (avg - 1) <= q) {
				pq.add(avg - 1);
			}
			if ((avg + 1) >= p && (avg + 1) <= q) {
				pq.add(avg + 1);
			}
		}
		return pq;

	}

	static int getMin(int[] a, int k) {
		int N = a.length;
		int lo = 0;
		int hi = N - 1;

		int mid = (lo + (hi)) / 2;
		while (lo < hi && (hi - lo) > 1 && lo >= 0 && hi <= N - 1) {
			mid = (lo + (hi)) / 2;
			if (a[mid] == k) {
				return 0;
			} else if (a[mid] < k) {

				lo = Math.min(mid, N - 1);
			} else {

				hi = Math.max(0, mid);
			}
		}

		int t2 = Math.abs(k - a[lo]);
		int t3 = Math.abs(k - a[hi]);
		return Math.min(t2, t3);
	}

}
