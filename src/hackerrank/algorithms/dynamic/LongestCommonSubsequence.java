package hackerrank.algorithms.dynamic;

import java.util.Arrays;
import java.util.Scanner;

public class LongestCommonSubsequence {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();

		int[] a = new int[N];

		for (int i = 0; i < N; i++) {
			a[i] = sc.nextInt();
		}

		int[] b = new int[M];

		for (int i = 0; i < M; i++) {
			b[i] = sc.nextInt();
		}

		int[] res = solve(a, b);
		// System.out.println("res: " + Arrays.toString(res));

		StringBuilder sb = new StringBuilder();
		for (int i = res.length - 1; i >= 0; i--) {
			sb.append(res[i] + " ");
		}

		System.out.println(sb.toString().trim());

	}

	private static int[] solve(int[] a, int[] b) {
		int[][] soln = new int[a.length + 1][b.length + 1];

		for (int i = 0; i < a.length; i++) {
			soln[i][0] = 0;
		}

		for (int i = 0; i < b.length; i++) {
			soln[0][i] = 0;
		}

		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < b.length; j++) {
				if (a[i] == b[j]) {
					soln[i + 1][j + 1] = 1 + soln[i][j];
				} else {
					soln[i + 1][j + 1] = Math.max(soln[i + 1][j], soln[i][j + 1]);
				}
			}
		}

		int[] res = new int[Math.max(a.length, b.length)];
		int i = 0;

		for (int x = a.length, y = b.length; x != 0 && y != 0;) {
			if (soln[x][y] == soln[x - 1][y])
				x--;
			else if (soln[x][y] == soln[x][y - 1])
				y--;
			else {
				res[i++] = a[x - 1];
				// System.out.println(a[x - 1]);
				x--;
				y--;
			}
		}

		// System.out.println(Arrays.toString(res));
		return Arrays.copyOf(res, i);

	}
}
