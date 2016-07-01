package hackerrank.algorithms.sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InsertionSortAdvancedAnalysis {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine().trim());

		for (int t = 0; t < T; t++) {

			int N = Integer.parseInt(br.readLine().trim());

			int[] a = new int[N];

			String[] line = br.readLine().split(" ");
			for (int i = 0; i < N; i++) {
				a[i] = Integer.parseInt(line[i]);
			}

			solve(a);

		}

	}

	private static void solve(int[] a) {
		long shifts = 0;
		int N = a.length;
		int t = 0;
		for (int i = 1; i < N; i++) {
			for (int j = i; j > 0 && (a[j] < a[j - 1]); j--) {
				shifts++;
				t = a[j];
				a[j] = a[j - 1];
				a[j - 1] = t;
			}
		}
		System.out.println(shifts);
	}
}
