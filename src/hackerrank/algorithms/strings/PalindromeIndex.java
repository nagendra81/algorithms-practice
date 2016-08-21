package hackerrank.algorithms.strings;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PalindromeIndex {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		String line;
		for (int t = 0; t < T; t++) {
			line = br.readLine().trim();
			solve(line);

		}

	}

	private static void solve(String line) {
		char[] arr = line.toCharArray();
		if (isPalindrome(arr)) {
			System.out.println(-1);
			return;
		}

		int N = arr.length;
		for (int i = 0; i < N; i++) {
			if (isPalindrome(arr, i)) {
				System.out.println(i);
				return;
			}

		}

	}

	private static boolean isPalindrome(char[] arr, int k) {
		int i = 0;
		int j = arr.length - 1;

		while (i <= j) {
			if (i == k) {
				i++;
				continue;
			}
			if (j == k) {
				j--;
				continue;
			}
			if (arr[i++] != arr[j--]) {
				return false;
			}
		}
		return true;

	}

	static char[] remove(char[] arr, int k) {
		char[] new_arr = new char[arr.length - 1];

		int j = 0;
		for (int i = 0; i < arr.length; i++) {
			if (i != k) {
				new_arr[j++] = arr[i];
			}
		}
		return new_arr;
	}

	static boolean isPalindrome(char[] arr) {
		int i = 0;
		int j = arr.length - 1;

		while (i < j) {
			if (arr[i++] != arr[j--]) {
				return false;
			}
		}
		return true;

	}

}
