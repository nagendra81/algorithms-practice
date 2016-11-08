package hackerearth.algorithms.dynamic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class LetsBegin {

	public static void main(String[] args) {
		InputReader sc = new InputReader();

		int T = sc.nextInt();
		for (int t = 0; t < T; t++) {
			int X = sc.nextInt();
			solve(X);
		}

	}

	private static void solve(int N) {
		if (N == 1) {
			System.out.println(-1);
			return;
		}
		int[] p = { 2, 3, 5, 7 };

		int[] dp = new int[N + 1];

		dp[0] = dp[1] = 0;
		dp[1] = 999999;
		for (int i = 2; i <= N; i++) {
			int min = Integer.MAX_VALUE;
			for (int k : p) {
				if (k <= i)
					min = Integer.min(min, 1 + dp[i - k]);
			}
			dp[i] = min;
		}

		// System.out.println(Arrays.toString(dp));
		System.out.println(dp[N]);

	}

	static class InputReader {
		public BufferedReader reader;
		public StringTokenizer tokenizer;

		public InputReader() {
			reader = new BufferedReader(new InputStreamReader(System.in));
			tokenizer = null;
		}

		public String next() {
			while (tokenizer == null || !tokenizer.hasMoreTokens()) {
				try {
					tokenizer = new StringTokenizer(reader.readLine());
				} catch (IOException e) {
					throw new RuntimeException(e);
				}
			}
			return tokenizer.nextToken();
		}

		public int nextInt() {
			return Integer.parseInt(next());
		}

		public long nextLong() {
			return Long.parseLong(next());
		}

		public double nextDouble() {
			return Double.parseDouble(next());
		}
	}

}
