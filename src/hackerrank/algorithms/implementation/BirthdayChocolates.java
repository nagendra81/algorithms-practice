package hackerrank.algorithms.implementation;

import java.util.Scanner;

public class BirthdayChocolates {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			int N = sc.nextInt();

			int[] bars = new int[N];
			for (int i = 0; i < N; i++) {
				bars[i] = sc.nextInt();
			}

			int d = sc.nextInt();
			int m = sc.nextInt();

			solve(bars, d, m);
		}

	}

	private static void solve(int[] bars, int d, int m) {
		int res = 0;
		int sum = 0;

		for (int i = 0; i < m; i++) {
			sum += bars[i];
		}

		if (sum == d) {
			res++;
		}

		for (int i = m; i < bars.length; i++) {
			sum -= bars[i - m];
			sum += bars[i];
			if (sum == d) {
				res++;
			}

		}
		System.out.println(res);
	}

}
