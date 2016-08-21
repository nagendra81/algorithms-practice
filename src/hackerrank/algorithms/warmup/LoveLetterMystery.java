package hackerrank.algorithms.warmup;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LoveLetterMystery {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			solve(br.readLine());
		}
	}

	static void solve(String word) {
		int st = 0;
		int end = word.length() - 1;

		int res = 0;
		while (st < end) {
			res += Math.abs(word.charAt(st) - word.charAt(end));
			st++;
			end--;
		}
		System.out.println(res);
	}

}
