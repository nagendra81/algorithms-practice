package hackerrank.algorithms.warmup;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Staircase {
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine().trim());

		for (int i = 1; i <= N; i++) {
			String res = repeat(' ', N - i).append(repeat('#', i)).toString();
			System.out.println(res);
		}

	}

	static StringBuilder repeat(char c, int k) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < k; i++) {
			sb.append(c);
		}
		return sb;
	}
}
