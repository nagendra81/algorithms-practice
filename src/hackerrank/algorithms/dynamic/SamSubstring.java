package hackerrank.algorithms.dynamic;

import java.util.Scanner;

public class SamSubstring {
	private static final long MOD = 1000000007;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		char[] balls = sc.nextLine().toCharArray();

		int N = balls.length;

		long offset = 0;
		long res = 0;

		long b;
		for (int i = N - 1; i >= 0; i--) {
			b = (balls[i] - '0') * (i + 1);
			b %= MOD;
			offset = (offset * 10 + 1) % MOD;

			res = (res % MOD) + (b * (offset % MOD));
			res %= MOD;

		}

		System.out.println(res);

	}
}
