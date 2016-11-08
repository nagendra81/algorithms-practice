package hackerrank.algorithms.sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class QuickSortInPlace {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine().trim());
		int[] a = new int[N];
		String[] line = br.readLine().split(" ");

		for (int i = 0; i < N; i++) {
			a[i] = Integer.parseInt(line[i]);
		}

		doQuickSort(a, 0, N - 1);
		print(a);
	}

	private static void doQuickSort(int[] a, int lo, int hi) {
		if (lo < hi) {
			int p = partition(a, lo, hi);
			print(a);
			doQuickSort(a, lo, p - 1);
			doQuickSort(a, p + 1, hi);

		}

	}

	static int partition(int[] A, int lo, int hi) {
		int pivot = A[hi];
		int i = lo;
		for (int j = lo; j < hi; j++) {
			if (A[j] <= pivot) {
				swap(A, i, j);
				i++;
			}
		}
		swap(A, i, hi);
		return i;
	}

	static void swap(int[] A, int i, int j) {
		int t = A[i];
		A[i] = A[j];
		A[j] = t;
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
