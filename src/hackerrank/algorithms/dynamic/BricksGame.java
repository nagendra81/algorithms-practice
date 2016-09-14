package hackerrank.algorithms.dynamic;

import java.util.Scanner;

public class BricksGame {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int t = 0; t < T; t++) {
			int N = sc.nextInt();
			long[] bricks = new long[N];
			for (int i = 0; i < N; i++) {
				bricks[i] = sc.nextInt();
			}

			long res = Long.MIN_VALUE;
			for (int i = 0; i < bricks.length; i++) {
				res = Math.max(res, solve_rec(bricks, i));
			}
			System.out.println(res);
		}
	}

	private static long solve_rec(long[] bricks, int i) {
		long res = Long.MIN_VALUE;

		long pre = 0;
		for (int j = i; j < bricks.length && j - i < 3; j++) {
			System.out.println("lop");
			pre += bricks[j];
			long a = pre + solve_rec(bricks, j + 1);
			res = Math.max(res, a);
		}

		return res;
	}

}
