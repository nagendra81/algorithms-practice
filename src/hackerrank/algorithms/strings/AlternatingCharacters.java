package hackerrank.algorithms.strings;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class AlternatingCharacters {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine().trim());

		for (int t = 0; t < T; t++) {
			String line = br.readLine().trim();
			solve(line.toCharArray());

		}
	}

	private static void solve(char[] arr) {
		int res = 0;

		for (int i = 1; i < arr.length; i++) {
			if (arr[i] == arr[i - 1]) {
				res++;
			}
		}
		System.out.println(res);

	}

}
