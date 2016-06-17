package hackerrank.algorithms.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SherlockSquares {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		for (int t = 0; t < T; t++) {
			String[] line = br.readLine().split(" ");
			long A = Long.valueOf(line[0]);
			long B = Long.valueOf(line[1]);
			solve(A, B);

		}
	}

	private static void solve(long a, long b) {
		long sa = (long) Math.floor((double) Math.sqrt((double) a));
		long sb = (long) Math.floor((double) Math.sqrt((double) b));

		long res = 0;
		for (long i = sa; i <= sb; i++) {
			long c = i * i;
			if (c >= a && c <= b) {
				res++;
			}
		}
		System.out.println(res);

	}

}
