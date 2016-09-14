package hackerrank.algorithms.dynamic;

import java.util.Scanner;

public class Knapsack {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int t = 0; t < T; t++) {
			int N = sc.nextInt();
			int K = sc.nextInt();

			int[] arr = new int[N];
			for (int i = 0; i < N; i++) {
				arr[i] = sc.nextInt();
			}

			int res = 0;
			// res = solve_rec(arr, 0, 0, 0, K);
			// res = solve_dp(arr, K);
			res = solve_dp2(arr, K);
			System.out.println(res);
		}
	}

	private static int solve_dp2(int[] arr, int K) {
		int N = arr.length;
		int[][] dp = new int[N + 1][K + 1];

		for (int i = 0; i < K; i++) {
			dp[0][i] = 0;
		}

		for (int i = 1; i < N; i++) {
			for (int j = 0; j < K; j++) {
				if (j > arr[i]) {
					dp[i][j] = Math.max(arr[i] + dp[i - 1][j - arr[i - 1]], dp[i - 1][j]);
				} else {
					dp[i][j] = dp[i - 1][j];
				}
			}
		}

		return dp[N - 1][K - 1];

	}

	private static int solve_dp(int[] arr, int K) {
		int[] dp = new int[K + 1];
		dp[0] = 0;

		for (int i = 1; i <= K; i++) {

			int best = Integer.MIN_VALUE;

			for (int a : arr) {
				if (a <= i) {
					best = Math.max(dp[i - a] + a, best);
				}

			}
			if (best == Integer.MIN_VALUE)
				best = 0;
			dp[i] = best;
		}

		return dp[K];

	}

	private static int solve_rec(int[] arr, int i, int sum, int v, int K) {

		if (sum + v == K) {
			return sum + v;
		} else if (sum + v > K) {
			return sum;
		} else if (i == arr.length) {
			return sum + v;
		}

		sum += v;

		int a, b, c;
		a = b = c = Integer.MIN_VALUE;

		c = solve_rec(arr, i, sum, arr[i], K);

		a = solve_rec(arr, i + 1, sum, arr[i], K);
		b = solve_rec(arr, i + 1, sum, 0, K);

		// System.out.println("a = " + a + ", b = " + b + ", c = " + c);
		return max(a, b, c);

	}

	static int max(int a, int b, int c) {
		return Math.max(Math.max(a, b), c);
	}

}
