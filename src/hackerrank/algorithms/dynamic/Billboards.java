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
		Arrays.fill(opt, Integer.MIN_VALUE);

		opt[0] = boards[0];

		for (int n = 1; n < N; n++) {
			long profit = 0;
			long max_so_far = 0;
			long max_profit = Integer.MIN_VALUE;
			for (int k = 0; k < K; k++) {
				if (n - k < 0) {
					break;

				}
				profit += boards[n - k];

				max_so_far = Math.max(profit + getOpt(opt, n - k - 2), getOpt(opt, n - k - 1));
				max_profit = Math.max(max_profit, max_so_far);
			}
			opt[n] = max_profit;
			System.out.println(Arrays.toString(opt));
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
