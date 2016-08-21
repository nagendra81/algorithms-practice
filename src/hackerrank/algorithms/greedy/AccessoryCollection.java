package hackerrank.algorithms.greedy;

import java.util.Scanner;

public class AccessoryCollection {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		for (int t = 0; t < T; t++) {
			int L = sc.nextInt();
			int A = sc.nextInt();
			int N = sc.nextInt();
			int D = sc.nextInt();
			solve(L, A, N, D);
		}
	}

	private static void solve(int L, int A, int N, int D) {

		if (A < D || D > N) {
			System.out.println("SAD");
			return;
		}

		long cost = 0;

		while (L > 0 && A > 0) {
			cost += (D * A);
			A--;
			L -= D;
		}
		System.out.println(cost);
		if (L == 0 && A >= 0) {
			System.out.println(cost);
		} else {
			System.out.println("SAD");
		}

	}

}
