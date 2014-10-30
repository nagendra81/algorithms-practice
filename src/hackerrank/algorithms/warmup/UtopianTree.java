package hackerrank.algorithms.warmup;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class UtopianTree {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		for (int t = 0; t < T; t++) {
			solve(Integer.parseInt(br.readLine()));
		}
	}

	private static void solve(int cycles) {
		int h = 1;

		for (int i = 1; i <= cycles; i++) {
			if ((i % 2) == 0) {
				h++;
			} else {
				h *= 2;
			}
		}
		System.out.println(h);
	}

}
