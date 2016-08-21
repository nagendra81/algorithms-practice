package hackerrank.algorithms.strings;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FunnyStrings {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine().trim());

		for (int t = 0; t < T; t++) {
			String line = br.readLine().trim();
			solve(line);
		}

	}

	private static void solve(String line) {
		char[] arr = line.toCharArray();
		char[] rev = new StringBuilder(line).reverse().toString().toCharArray();

		int s;
		int r;
		for (int i = 1; i < line.length(); i++) {
			s = arr[i] - arr[i - 1];
			if (s < 0)
				s *= -1;
			r = rev[i] - rev[i - 1];
			if (r < 0)
				r *= -1;

			if (s != r) {
				System.out.println("Not Funny");
				return;
			}
		}
		System.out.println("Funny");

	}

}
