
package hackerearth.algorithms.dynamic;

import java.util.Scanner;

public class RoyAndRopes {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int t = 0; t < T; t++) {
			int L = sc.nextInt();

			int[] upper = new int[L - 1];

			for (int i = 0; i < L - 1; i++) {
				upper[i] = sc.nextInt();

			}

			int[] lower = new int[L - 1];

			for (int i = 0; i < L - 1; i++) {
				lower[i] = sc.nextInt();
			}

			long res = solve(L - 1, upper, lower);
			System.out.println(res);
		}
	}

	private static int solve(int L, int[] upper, int[] lower) {

		int res = L + 1;

		for (int i = 0; i < L; i++) {
			int r = Math.max(upper[i], lower[i]);
			if (r == 0)
				continue;
			if (i + 1 + r > res) {
				res = i + 1 + r;
			}

		}
		return res;
	}

}
