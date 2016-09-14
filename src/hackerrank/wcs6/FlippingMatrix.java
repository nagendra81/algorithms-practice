package hackerrank.wcs6;

import java.util.Scanner;

public class FlippingMatrix {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int Q = sc.nextInt();

		for (int i = 0; i < Q; i++) {
			int N = sc.nextInt();

			int[][] matrix = new int[2 * N][];

			for (int k = 0; k < 2 * N; k++) {
				int[] row = new int[2 * N];

				for (int j = 0; j < 2 * N; j++) {
					row[j] = sc.nextInt();
				}
				matrix[k] = row;
			}
			solve(matrix, N);

		}
	}

	private static void solve(int[][] matrix, int N) {
		long res = 0L;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				int a = matrix[i][j];
				int b = matrix[2 * N - i - 1][j];
				int c = matrix[2 * N - i - 1][2 * N - j - 1];
				int d = matrix[i][2 * N - j - 1];

				res += max(a, b, c, d);

			}
		}
		System.out.println(res);

	}

	static int max(int a, int b, int c, int d) {
		int[] arr = { a, b, c, d };
		int res = Integer.MIN_VALUE;

		for (int v : arr) {
			if (v > res)
				res = v;
		}

		return res;

	}

}
