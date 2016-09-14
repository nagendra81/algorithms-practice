package hackerrank.algorithms.implementation;

import java.util.Scanner;

public class FlatlandSpaceStations {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int M = sc.nextInt();

		int[] stns = new int[M];
		for (int i = 0; i < M; i++) {
			stns[i] = sc.nextInt();
		}

		solve(stns, N);

	}

	private static void solve(int[] stns, int n) {
		int max = Integer.MIN_VALUE;

		for (int i = 0; i < n; i++) {
			int dist = Integer.MAX_VALUE;
			for (int j = 0; j < stns.length; j++) {
				dist = Math.min(dist, Math.abs(stns[j] - i));
			}
			max = Math.max(dist, max);
		}
		System.out.println(max);
	}

}
