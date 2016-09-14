package hackerrank.algorithms.dynamic;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class CoinChangeProblem {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int M = sc.nextInt();

		Set<Integer> coins = new TreeSet<>();

		for (int i = 0; i < M; i++) {
			coins.add(sc.nextInt());
		}

		System.out.println("Coins: " + coins);
		int[] paths = new int[100];
		long res = solve(coins, N);
		System.out.println(res);

	}

	private static long solve(Set<Integer> coins, int N) {

		long[] dp = new long[N + 1];
		Arrays.fill(dp, 0);

		dp[0] = 0;
		for (int i = 1; i <= N; i++) {
			long num = 0;

			for (int j = 1; j <= i; j++) {
				if (coins.contains(j) && i - j == 0) {
					num++;
				} else if (coins.contains(j) && dp[i - j] > 0) {
					num += dp[i - j];
				}
			}

			dp[i] = num;
		}

		System.out.println(Arrays.toString(dp));
		return dp[N];
		/*
		 * if (sum == K) { print(Arrays.copyOf(paths, pi)); return 1; } long res
		 * = 0; for (int i = 1; i <= N; i++) { if (coins.contains(i)) {
		 * paths[pi] = i; long ans = solve(coins, K, N - i, sum + i, paths, pi +
		 * 1); if (ans > 0) { res += ans; } } } return res;
		 */

	}

	private static void print(int[] paths) {
		System.out.println(Arrays.toString(paths));

	}

}
