package hackerearth.algorithms.dynamic;

import java.util.Scanner;

public class XSquareCoins {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int t = 0; t < T; t++) {
			int N = sc.nextInt();
			int K = sc.nextInt();

			long[] coins = new long[N];
			for (int i = 0; i < N; i++) {
				coins[i] = sc.nextLong();
			}

			solve(coins, N, K);
		}
	}

	private static void solve(long[] coins, int N, int K) {
		long[] dp = new long[N];

		dp[0] = coins[0] <= K ? coins[0] : 0;
		for (int i = 1; i < N; i++) {
			if (coins[i] <= K) {
				dp[i] = dp[i - 1] + coins[i];
			} else {
				dp[i] = 0;
			}
		}
		// System.out.println(Arrays.toString(dp));

		long max = dp[0];
		for (int i = 1; i < dp.length; i++) {
			if (dp[i] > max)
				max = dp[i];
		}

		System.out.println(max);
	}

}
