package hackerrank.algorithms.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Set;
import java.util.TreeSet;

public class ManasaStones {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine().trim());

		for (int t = 0; t < T; t++) {
			int N = Integer.parseInt(br.readLine().trim());
			int a = Integer.parseInt(br.readLine().trim());
			int b = Integer.parseInt(br.readLine().trim());
			solve(N, a, b);

		}

	}

	private static void solve(int n, int a, int b) {
		Set<Integer> result = new TreeSet<>();

		for (int i = 0; i < n; i++) {
			int sa = a * (n - i);
			int sb = b * (i);
			result.add(sa + sb - a);

		}

		StringBuilder sb = new StringBuilder();
		for (int r : result) {
			sb.append(r + " ");
		}
		System.out.println(sb.toString().trim());

	}

	private static void solve(int curr, int cnt, int n, int a, int b, Set<Integer> result) {
		if (cnt < n) {
			solve(curr + a, cnt + 1, n, a, b, result);
			solve(curr + b, cnt + 1, n, a, b, result);
		} else {
			result.add(curr);
		}

	}

}
