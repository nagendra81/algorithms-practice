package hackerrank.algorithms.dynamic;

import java.util.Arrays;
import java.util.Scanner;

public class LongestIncreasingSubsequence {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();

		int[] arr = new int[N];

		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}

		// int res = solve_dp(arr, N);
		int res = solve_r(arr, N);
		// int res = solve_binary_search(arr, N);
		System.out.println(res);

	}

	private static int solve_r(int[] arr, int n) {

		if (n <= 0) {
			return 1;
		}

		for (int i = 1; i < n; i++) {
			int res = -1;
			for (int j = 0; j < i; j++) {
				if (arr[j] < arr[i]) {
					res = Math.max(res, solve_r(arr, j));
				}
			}
		}

		return -1;
	}

	static int max(int[] arr, int lo, int hi, int k) {
		return 0;
	}

	private static int solve_dp(int[] arr, int N) {
		int[] dp = new int[N];

		dp[0] = 1;
		for (int i = 1; i < N; i++) {
			int res = -1;
			for (int j = 0; j < i; j++) {
				if (arr[j] < arr[i]) {
					res = Math.max(res, dp[j]);
				}
			}
			if (res == -1) {
				dp[i] = 1;
			} else {
				dp[i] = res + 1;
			}

		}

		System.out.println(Arrays.toString(dp));
		int res = -1;

		for (int d : dp) {
			if (d > res)
				res = d;
		}
		return res;

	}
}
