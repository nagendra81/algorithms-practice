package hackerrank.algorithms.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TaumBirthday {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.valueOf(br.readLine().trim());

		for (int t = 0; t < T; t++) {
			String[] line = br.readLine().split(" ");
			long B = Long.parseLong(line[0].trim());
			long W = Long.parseLong(line[1].trim());

			line = br.readLine().split(" ");
			long X = Long.parseLong(line[0].trim());
			long Y = Long.parseLong(line[1].trim());
			long Z = Long.parseLong(line[2].trim());

			solve(B, W, X, Y, Z);
		}

	}

	private static void solve(long B, long W, long X, long Y, long Z) {
		long orig = (B * X) + (W * Y);
		long c1 = (B + W) * X + (W * Z);
		long c2 = (B + W) * Y + (B * Z);

		System.out.println(min(orig, c1, c2));

	}

	static long min(long a, long b, long c) {
		return Math.min(Math.min(a, b), c);
	}

}
