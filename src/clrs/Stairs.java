package clrs;

public class Stairs {

	public static void main(String[] args) {
		int N = 10;

		long res = countWays(N);
		System.out.println(res);

	}

	static long countWays(int N, int m) {

		if (N <= 1)
			return 1;
		else if (N == 2)
			return 2;
		else if (N == 3)
			return 4;
		else {
			long res = 0;
			for (int i = 1; i <= m; i++) {
				res += countWays(N - i, m);
			}
			return res;
		}

	}

	static long countWays(int N) {
		int[] best = new int[N + 1];

		best[1] = 1;
		best[2] = 2;
		best[3] = 4;

		for (int i = 4; i <= N; i++) {
			best[i] = best[i - 1] + best[i - 2] + best[i - 3];
		}

		return best[N];
	}

}
