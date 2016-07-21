package hackerrank.algorithms.dynamic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Billboards {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] line = br.readLine().split(" ");
		int N = Integer.parseInt(line[0].trim());
		int K = Integer.parseInt(line[1].trim());

		int[] boards = new int[N];
		for (int n = 0; n < N; n++) {
			boards[n] = Integer.parseInt(br.readLine().trim());
		}

		solve(boards, N, K);
	}

	private static void solve(int[] boards, int N, int K) {
		long[] opt = new long[boards.length];
		Arrays.fill(opt, -1);

		long t = boards[0];
		for (int i = 1; i < K; i++) {
			opt[i] = t + boards[i];
			t = opt[i];
		}

		for (int n = K; n < N; n++) {
			long profit = 0;
			long max_profit = -1;
			long max_here = 0;
			for (int k = 0; k < K; k++) {
				if (n - k < 0) {
					break;
				}

				profit += boards[n - k];

				max_here = Math.max(profit + getOpt(opt, n - k - 2), getOpt(opt, n - k - 1));
				max_profit = Math.max(max_profit, max_here);
			}

			opt[n] = max_profit;
		}
		// System.out.println(Arrays.toString(opt));
		System.out.println(opt[N - 1]);
	}

	private static long getOpt(long[] opt, int n) {
		if (n < 0)
			return 0;
		return opt[n];
	}

}
