package hackerearth.algorithms.dynamic;

import java.util.Scanner;

public class OnceUponATime {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int t = 0; t < T; t++) {
			int N = sc.nextInt();
			int K = sc.nextInt();

			long[] arr = new long[N];
			for (int i = 0; i < N; i++) {
				arr[i] = sc.nextLong();
			}

			solve(arr, N, K);

		}

	}

	private static void solve(long[] arr, int N, int K) {
	}

}
