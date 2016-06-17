package hackerrank.algorithms.strings;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class TwoStrings {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine().trim());

		for (int t = 0; t < T; t++) {
			String A = br.readLine().trim();
			String B = br.readLine().trim();
			solve(A, B);
		}

	}

	private static void solve(String A, String B) {
		Set<Character> wordSet = new HashSet<>();

		for (int i = 0; i < A.length(); i++) {
			wordSet.add(A.charAt(i));
		}

		for (int i = 0; i < B.length(); i++) {
			if (wordSet.contains(B.charAt(i))) {
				System.out.println("YES");
				return;
			}
		}
		System.out.println("NO");

	}

}
