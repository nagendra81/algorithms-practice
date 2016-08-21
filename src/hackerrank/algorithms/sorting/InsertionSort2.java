package hackerrank.algorithms.sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InsertionSort2 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine().trim());

		int[] a = new int[N];

		String[] line = br.readLine().split(" ");
		for (int i = 0; i < a.length; i++) {
			a[i] = Integer.parseInt(line[i]);
		}

		long shifts = 0;
		for (int i = 1; i < N; i++) {

			int t = a[i];
			int j = i - 1;

			while (j >= 0 && a[j] > t) {
				a[j + 1] = a[j];
				j--;
				shifts++;
			}
			// System.out.println("j = " + j);
			if (a[j + 1] > t) {
				a[j + 1] = t;
				// shifts++;
			}

			// print(a);

		}
		System.out.println(shifts);

	}

	private static void print(int[] arr) {
		StringBuilder sb = new StringBuilder();
		for (int a : arr) {
			sb.append(a);
			sb.append(" ");
		}
		System.out.println(sb);

	}

}
