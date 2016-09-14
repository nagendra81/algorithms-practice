package hackerrank.algorithms.dynamic;

import java.util.Arrays;
import java.util.Scanner;

public class NikitaGame {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int t = 0; t < T; t++) {
			int N = sc.nextInt();
			int[] arr = new int[N];
			for (int i = 0; i < N; i++) {
				arr[i] = sc.nextInt();
			}

			long[] pre_sums = new long[N];
			pre_sums[0] = arr[0];
			for (int i = 1; i < N; i++) {
				pre_sums[i] = (pre_sums[i - 1] * 1L) + (arr[i] * 1L);
			}

			int res = 0;
			// System.out.println(Arrays.toString(arr));
			// System.out.println("pre: " + Arrays.toString(pre_sums));
			res = solve_rec(arr, pre_sums, 0, N - 1);
			System.out.println(res);
		}
	}

	private static int solve_rec(int[] arr, long[] pre_sums, int lo, int hi) {
		if (pre_sums == null || pre_sums.length == 0) {
			return 0;
		}
		for (int i = lo; i <= hi; i++) {
			if (pre_sums[i] == (pre_sums[hi] - pre_sums[i])) {
				// System.out.println("equal: " + i + ", " + (hi - i));

				long[] pre_left = summarize(arr, lo, i);
				long[] pre_right = summarize(arr, i + 1, hi);
				int left = solve_rec(arr, pre_left, lo, i);
				int right = solve_rec(arr, pre_right, i + 1, hi);
				return 1 + Math.max(left, right);

			}
		}
		return 0;
	}

	private static long[] summarize(int[] arr, int lo, int hi) {
		if (lo >= hi) {
			return new long[] {};
		}
		long[] pre = new long[hi + 1];
		Arrays.fill(pre, 0);

		pre[lo] = arr[lo];
		for (int i = lo + 1; i <= hi; i++) {
			pre[i] = (1L * pre[i - 1]) + (1L * arr[i]);
		}
		return pre;
	}
}
