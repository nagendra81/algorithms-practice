package hackerearth.algorithms.problems;

import java.util.Scanner;

public class MilliEqualArray {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int t = 0; t < T; t++) {
			int N = sc.nextInt();
			int X = sc.nextInt();
			int Y = sc.nextInt();
			int Z = sc.nextInt();

			int[] arr = new int[N];
			for (int i = 0; i < N; i++) {
				arr[i] = sc.nextInt();
			}

			boolean ok = solve(arr, N, X, Y, Z);
			if (ok) {
				System.out.println("She can");
			} else {
				System.out.println("She can't");
			}
		}
	}

	private static boolean solve(int[] arr, int n, int x, int y, int z) {
		int prod = x * y * z;

		for (int v : arr) {
			if (v == 1)
				continue;
			if (v >= prod) {
				if (v % prod != 0) {
					return false;
				}
			} else {
				if (prod % v != 0) {
					return false;
				}
			}
		}

		return true;

	}

}
