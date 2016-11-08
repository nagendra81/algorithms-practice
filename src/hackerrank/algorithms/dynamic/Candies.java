package hackerrank.algorithms.dynamic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Candies {

	public static void main(String[] args) throws IOException {
		InputReader sc = new InputReader();
		PrintWriter out = new PrintWriter(System.out);

		int N = sc.nextInt();

		int[] kids = new int[N];
		for (int i = 0; i < N; i++) {
			kids[i] = sc.nextInt();
		}

		int[] opt = new int[N];
		Arrays.fill(opt, 1);

		for (int i = 1; i < N; i++) {
			if (kids[i] > kids[i - 1]) {
				opt[i] = opt[i - 1] + 1;
			}
		}

		for (int i = N - 1; i > 0; i--) {
			if (kids[i - 1] > kids[i]) {
				opt[i - 1] = opt[i - 1] > opt[i] + 1 ? opt[i - 1] : opt[i] + 1;
			}
		}

		int s = 0;
		for (int op : opt) {
			s += op;
		}
		out.println(s);
		out.close();
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
