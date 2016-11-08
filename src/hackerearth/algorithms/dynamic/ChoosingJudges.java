package hackerearth.algorithms.dynamic;

import java.util.Scanner;

public class ChoosingJudges {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			int N = sc.nextInt();

			long[] sco = new long[N];
			for (int i = 0; i < N; i++) {
				sco[i] = sc.nextLong();
			}
			solve(t, sco, N);
		}
	}

	static void solve(int t, long[] scores, int N) {
		if (N == 1) {
			System.out.printf("Case %d: %d\n", t, scores[0]);
			return;
		}
		long[] best = new long[N];

		best[0] = scores[0];
		best[1] = Math.max(scores[1], best[0]);
		for (int i = 2; i < scores.length; i++) {
			best[i] = Math.max(best[i - 1], scores[i] + best[i - 2]);
		}
		// System.out.println(Arrays.toString(best));
		System.out.printf("Case %d: %d\n", t, best[N - 1]);
	}

}
