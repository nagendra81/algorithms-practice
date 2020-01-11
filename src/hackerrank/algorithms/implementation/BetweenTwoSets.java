
package hackerrank.algorithms.implementation;

import java.util.Arrays;
import java.util.Scanner;

public class BetweenTwoSets {
	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			int m = sc.nextInt();
			int n = sc.nextInt();

			int[] a = new int[m];
			for (int i = 0; i < m; i++) {
				a[i] = sc.nextInt();
			}
			int[] b = new int[n];
			for (int i = 0; i < n; i++) {
				b[i] = sc.nextInt();
			}
			solve(a, b, m, n);

		}
	}

	private static void solve(int[] a, int[] b, int m, int n) {
		Arrays.sort(a);
		Arrays.sort(b);

		int res = 0;
		for (int i = a[a.length - 1]; i <= b[0]; i++) {
			if (isAllFactor(a, i) && isFactor(b, i)) {
				res++;
			}
		}
		System.out.println(res);

	}

	private static boolean isAllFactor(int[] a, int i) {
		for (int n : a) {
			if (i % n != 0) {
				return false;
			}
		}
		return true;
	}

	private static boolean isFactor(int[] b, int i) {
		for (int n : b) {
			if (n % i != 0) {
				return false;
			}
		}
		return true;
	}

}
