package clrs;

import java.util.Arrays;

public class CutRod {
	public static void main(String[] args) {
		int[] prices = { 0, 1, 5, 8, 9, 10, 17, 17, 20, 24, 30 };

		int N = 4;
		int[] path = new int[N + 1];
		System.out.println("Rod Prices: " + Arrays.toString(prices));
		System.out.println("N : " + N);
		int profit = solve_dp2(prices, N, path);

		System.out.println("Max Profit: " + profit);
		System.out.println("path:" + Arrays.toString(path));

		int M = N;
		while (M > 0) {
			System.out.println("Cut -> " + path[M]);
			M = M - path[M];
		}

		/* Recursive */

		int[] memo = new int[N + 1];
		Arrays.fill(memo, -1);
		profit = solve_rec(prices, memo, N);
		System.out.println("*** Recursive ***");
		System.out.println(profit);

	}

	static int solve_dp2(int[] prices, int N, int[] path) {
		int[] best = new int[N + 1];

		best[0] = 0;

		/**
		 * Recurrence: Best[i] = Max(p[k] + Best[i-k]), for all i = 0 to N and k
		 * = 0 to n;
		 */

		for (int i = 1; i <= N; i++) {
			for (int k = 1; k <= i; k++) {
				int t = prices[k] + best[i - k];
				if (t > best[i]) {
					best[i] = t;
					path[i] = k;
				}
			}
		}
		return best[N];
	}

	static int solve_rec(int[] prices, int[] memo, int N) {
		if (N <= 0) {
			memo[0] = 0;
			return 0;
		} else if (memo[N] != -1) {
			return memo[N];
		} else {
			int max = -1;
			for (int i = 1; i <= N; i++) {
				max = Math.max(max, prices[i] + solve_rec(prices, memo, N - i));
			}
			memo[N] = max;
			return max;
		}
	}
}
