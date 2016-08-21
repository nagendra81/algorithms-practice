package hackerrank.algorithms.bitmanipulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FlipBits {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine().trim());
		for (int t = 0; t < T; t++) {
			long val = Long.parseLong(br.readLine().trim());
			solve(val);
		}
	}

	private static void solve(long val) {

		StringBuilder flippedString = new StringBuilder(Long.toBinaryString(val));

		StringBuilder prefix = new StringBuilder();
		for (int i = 0; i < 32 - flippedString.length(); i++) {
			prefix.append("0");
		}

		prefix.append(flippedString);

		for (int i = 0; i < prefix.length(); i++) {
			if (prefix.charAt(i) == '1') {
				prefix.setCharAt(i, '0');
			} else {
				prefix.setCharAt(i, '1');
			}
		}
		// System.out.println(prefix);

		long res = 0;
		int n = prefix.length();

		for (int i = 0; i < n; i++) {
			if (prefix.charAt(i) == '1')
				res += Math.pow(2, n - 1 - i);
		}
		System.out.println(res);

	}

}
