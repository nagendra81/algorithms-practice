package hackerrank.algorithms.sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InsertionSortAdvancedAnalysis {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine().trim());

		for (int t = 0; t < T; t++) {

			int N = Integer.parseInt(br.readLine().trim());

			int[] a = new int[N];
			int[] aux = new int[N];

			String[] line = br.readLine().split(" ");
			for (int i = 0; i < N; i++) {
				a[i] = Integer.parseInt(line[i]);
			}

			solve(a, aux);

		}

	}

	private static void solve(int[] a, int[] aux) {
		long shifts = 0;
		int N = a.length;

		shifts = sort(a, 0, N - 1, aux);
		System.out.println(shifts);

	}

	private static long sort(int[] a, int lo, int hi, int[] aux) {
		if (hi <= lo) {
			return 0;
		}

		int mid = lo + (hi - lo) / 2;

		long c1 = sort(a, lo, mid, aux);
		long c2 = sort(a, mid + 1, hi, aux);
		long c3 = merge(a, lo, mid, hi, aux);
		return c1 + c2 + c3;

	}

	private static long merge(int[] a, int lo, int mid, int hi, int[] aux) {
		for (int k = lo; k <= hi; k++) {
			aux[k] = a[k];
		}

		int i = lo;
		int j = mid + 1;

		long cnt = 0;
		int k = lo;
		while (i <= mid || j <= hi) {
			if (i > mid) {
				a[k] = aux[j++];
			} else if (j > hi) {
				a[k] = aux[i++];
			} else if (aux[i] <= aux[j]) {
				a[k] = aux[i++];
			} else {
				a[k] = aux[j++];
				cnt += mid + 1 - i;
			}
			k++;
		}
		return cnt;
	}
}
