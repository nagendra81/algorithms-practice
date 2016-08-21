package hackerrank.algorithms.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FindDigits {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine().trim());
		for (int t = 0; t < T; t++) {
			String line = br.readLine().trim();

			long val = Long.valueOf(line);
			solve(line, val);
		}
	}

	private static void solve(String line, long val) {
		int res = 0;
		for (char c : line.toCharArray()) {
			int ic = c - '0';
			if (ic != 0 && (val % ic) == 0) {
				res++;
			}
		}
		System.out.println(res);

	}
}
