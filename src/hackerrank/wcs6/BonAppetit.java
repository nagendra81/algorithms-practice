package hackerrank.wcs6;

import java.util.Scanner;

public class BonAppetit {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();

		long[] cost = new long[N];

		for (int i = 0; i < N; i++) {
			cost[i] = sc.nextLong();
		}

		long bCharged = sc.nextLong();

		solve(cost, N, K, bCharged);
	}

	private static void solve(long[] cost, int n, int k, long bCharged) {
		long bActual = 0L;

		for (int i = 0; i < n; i++) {
			if (i != k) {
				bActual += cost[i];
			}
		}

		bActual /= 2;

		if (bCharged == bActual) {
			System.out.println("Bon Appetit");
		} else {
			System.out.println((bCharged - bActual));
		}

	}

}
