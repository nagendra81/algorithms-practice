package hackerrank.algorithms.strings;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class BearSteady {
	public static void main(String[] args) throws NumberFormatException, IOException {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		String word = sc.next();

		solve(word.toCharArray(), N);

	}

	private static void solve(char[] arr, int N) {

		int[] freq = new int[4];
		Arrays.fill(freq, 0);

		for (char c : arr) {
			freq[c2idx(c)]++;
		}

		int exp = N / 4;

		if (freq[0] == exp && freq[1] == exp && freq[2] == exp && freq[3] == exp) {
			System.out.println(0);
			return;
		}

		int lo = 0;
		int hi = 0;

		freq[c2idx(arr[lo])]--;

		int res = Integer.MAX_VALUE;
		while (hi < N || isValid(freq, exp)) {
			if (isValid(freq, exp)) {
				res = Math.min(res, hi - lo + 1);
				freq[c2idx(arr[lo])]++;
				lo++;

			} else if (hi < N - 1) {
				hi++;
				freq[c2idx(arr[hi])]--;

			} else {
				break;
			}
		}
		System.out.println(res);

	}

	static boolean isValid(int[] freq, int exp) {
		if (freq[0] <= exp && freq[1] <= exp && freq[2] <= exp && freq[3] <= exp)
			return true;
		return false;
	}

	static int c2idx(char c) {
		switch (c) {
		case 'A':
			return 0;
		case 'C':
			return 1;
		case 'G':
			return 2;
		case 'T':
			return 3;
		default:
			return -5;

		}
	}
}
