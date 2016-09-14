package hackerearth.algorithms.dynamic;

import java.util.Scanner;

public class XsquareTwoArrays {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int Q = sc.nextInt();

		int[] A = new int[N];
		int[] B = new int[N];

		for (int i = 0; i < N; i++) {
			A[i] = sc.nextInt();
		}

		for (int i = 0; i < N; i++) {
			B[i] = sc.nextInt();
		}

		int[] pre_a = new int[N];

		pre_a[0] = A[0];
		for (int i = 1; i < N; i++) {
			pre_a[i] = pre_a[i - 1] + A[i];
		}

		int[] pre_b = new int[N];

		pre_b[0] = B[0];
		for (int i = 1; i < N; i++) {
			pre_b[i] = pre_b[i - 1] + B[i];
		}

		for (int q = 0; q < Q; q++) {
			int ch = sc.nextInt();
			int lo = sc.nextInt();
			int hi = sc.nextInt();

			if (ch == 1) {
				solve(pre_a, lo, hi);
			} else {
				solve(pre_b, lo, hi);
			}
		}

	}

	private static void solve(int[] pre, int lo, int hi) {

	}

}
