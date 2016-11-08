package hackerearth.algorithms.dynamic;

import java.util.Arrays;
import java.util.Scanner;

public class SamuShopping {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int t = 0; t < T; t++) {
			int N = sc.nextInt();

			int[][] shops = new int[N][3];

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < 3; j++) {
					shops[i][j] = sc.nextInt();
				}
			}

			solve(shops, N);
		}
	}

	private static void solve(int[][] shops, int N) {
		int[][] dp = new int[N][3];
		for (int[] d : dp) {
			Arrays.fill(d, Integer.MAX_VALUE);
		}

		for (int j = 0; j < 3; j++) {
			dp[0][j] = shops[0][j];
		}

		for (int i = 1; i < N; i++) {
			for (int j = 0; j < 3; j++) {
				if (j == 0) {
					dp[i][j] = shops[i][j] + Math.min(dp[i - 1][j + 1], dp[i - 1][j + 2]);
				} else if (j == 1) {
					dp[i][j] = shops[i][j] + Math.min(dp[i - 1][j - 1], dp[i - 1][j + 1]);
				} else {
					dp[i][j] = shops[i][j] + Math.min(dp[i - 1][j - 1], dp[i - 1][j - 2]);
				}
			}
		}

		int res = Integer.MAX_VALUE;
		for (int j = 0; j < 3; j++) {
			res = Math.min(dp[N - 1][j], res);

		}
		System.out.println(res);
	}
}
