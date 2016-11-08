package hackerrank.algorithms.dynamic;

import java.util.Scanner;

public class CoinChangeProblem {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int M = sc.nextInt();

		int[] coins = new int[M];

		for (int i = 0; i < M; i++) {
			coins[i] = sc.nextInt();
		}

		// System.out.println("Coins: " + Arrays.toString(coins));
		long res = solve(coins, N);
		// long res = countWays(N, coins);
		System.out.println(res);

	}

	private static long solve(int[] coins, int N) {
		long[][] dp = new long[coins.length + 1][N + 1];

		for (int i = 0; i <= coins.length; i++) {
			dp[i][0] = 1;
		}

		for (int i = 1; i <= coins.length; i++) {
			for (int j = 1; j <= N; j++) {
				if (j >= coins[i - 1]) {
					dp[i][j] = dp[i - 1][j] + dp[i][j - coins[i - 1]];
				} else {
					dp[i][j] = dp[i - 1][j];
				}
			}
		}

		return dp[coins.length][N];
	}

}
