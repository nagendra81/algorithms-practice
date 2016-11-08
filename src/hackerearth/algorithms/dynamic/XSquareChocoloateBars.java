package hackerearth.algorithms.dynamic;

import java.util.Arrays;
import java.util.Scanner;

public class XSquareChocoloateBars {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		String[] chocs = new String[N];

		for (int i = 0; i < N; i++) {
			chocs[i] = sc.next();
		}

		StringBuilder res = new StringBuilder();

		for (int i = 0; i < N; i++) {
			int r = solve(chocs[i], chocs[i].length());
			res.append(r + "\n");
		}
		System.out.println(res);
	}

	private static int solve(String choc, int N) {
		int[][] dp = new int[N + 1][N + 1];
		int max = 0;
		for (int i = 0; i < choc.length(); i++) {
			for (int j = i + 1; j < choc.length(); j++) {
				if (((j - i + 1) % 3) == 0) {
					if (dp[i][j + 1] == -1) {
						continue;
					}
					if (dp[i][j + 1] > 0) {
						max = Math.max(max, dp[i][j + 1]);
					} else if (dp[i][j] == 0) {

						boolean b = isValidBar(choc.substring(i, j + 1).toCharArray());
						// System.out.println(choc.substring(i, j + 1));
						max = Math.max(max, j - i + 1);
						if (b) {
							dp[i][j + 1] = max;
						} else {
							dp[i][j + 1] = -1;
						}

					}
				}
			}
		}
		for (int[] d : dp) {
			System.out.println(Arrays.toString(d));
		}
		return choc.length() - max;
	}

	private static boolean isValidBar(char[] choc) {
		for (int i = 0; i < choc.length; i += 3) {
			if (choc[i] == choc[i + 1] && choc[i] != choc[i + 2])
				continue;
			else if (choc[i] == choc[i + 2] && choc[i] != choc[i + 1])
				continue;
			else if (choc[i + 1] == choc[i + 2] && choc[i] != choc[i + 1])
				continue;
			else
				return false;
		}
		return true;
	}

}
