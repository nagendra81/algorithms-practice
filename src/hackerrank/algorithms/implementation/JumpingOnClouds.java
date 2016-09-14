package hackerrank.algorithms.implementation;

import java.util.Scanner;

public class JumpingOnClouds {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();

		int[] clds = new int[N];

		for (int i = 0; i < N; i++) {
			clds[i] = sc.nextInt();
		}

		int res = solve(clds, 0, N - 1);
		;
		System.out.println(res);

	}

	private static int solve(int[] clds, int i, int N) {
		if (i >= N) {
			return 0;
		} else if (clds[i] == 1) {
			return 99999;
		} else if (clds[i] == 0) {
			int a1 = 1 + solve(clds, i + 1, N);
			int a2 = 1 + solve(clds, i + 2, N);
			return Math.min(a1, a2);
		}
		return 0;

	}
}
