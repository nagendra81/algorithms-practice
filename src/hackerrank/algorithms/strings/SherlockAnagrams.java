package hackerrank.algorithms.strings;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class SherlockAnagrams {

	public static void main(String[] args) throws NumberFormatException, IOException {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		for (int t = 0; t < T; t++) {
			int ans = solve(sc.next());
		}

	}

	private static int solve(String word) {
		int N = word.length();

		for (int i = 0; i < word.length(); i++) {
			for (int j = 1; i < word.length(); j++) {

			}
		}

		return -1;

	}

	static boolean isAnagram(String word, String subs) {
		int[] freq = new int[26];
		Arrays.fill(freq, 0);

		for (char c : word.toCharArray()) {
			freq[c - 'a']++;
		}

		for (char c : subs.toCharArray()) {
			freq[c - 'a']--;
		}

		for (int f : freq) {
			if (f != 0) {
				return false;
			}
		}
		return true;
	}
}
