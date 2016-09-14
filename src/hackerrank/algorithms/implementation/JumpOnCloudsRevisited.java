package hackerrank.algorithms.implementation;

import java.util.Scanner;

public class JumpOnCloudsRevisited {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int K = sc.nextInt();

		int[] clds = new int[N];
		for (int i = 0; i < N; i++) {
			clds[i] = sc.nextInt();
		}

		int res = solve(clds, 0, K, N, 100);
		System.out.println(res);

	}

	private static int solve(int[] clds, int S, int K, int N, int E) {

		if (S == 0 && E < 100) {
			return E;
		} else {
			return solve(clds, S = (S + K) % N, K, N, E - 1 - ((clds[S] == 1) ? 2 : 0));
		}
	}
}
