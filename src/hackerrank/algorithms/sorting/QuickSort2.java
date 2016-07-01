package hackerrank.algorithms.sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class QuickSort2 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine().trim());
		int[] a = new int[N];
		String[] line = br.readLine().split(" ");

		for (int i = 0; i < N; i++) {
			a[i] = Integer.parseInt(line[i]);
		}

		doQuickSort(a, 0, N);

	}

	private static void doQuickSort(int[] a, int st, int en) {
		if (st < en) {
			int p = partition(a, st, en);
			doQuickSort(a, st, p - 1);
			doQuickSort(a, p + 1, en);
		}

	}

	private static int partition(int[] a, int st, int en) {
		int p = a[st];
		int lt = st;
		int gt = en;

		return 0;

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
