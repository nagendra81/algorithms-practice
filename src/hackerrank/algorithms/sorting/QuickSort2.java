package hackerrank.algorithms.sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class QuickSort2 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine().trim());
		int[] a = new int[N];
		String[] line = br.readLine().split(" ");

		for (int i = 0; i < N; i++) {
			a[i] = Integer.parseInt(line[i]);
		}

		doQuickSort(a, 0, N - 1);
		System.out.println(Arrays.toString(a));

	}

	private static void doQuickSort(int[] a, int st, int en) {
		if (st < en) {
			int p = partition(a, st, en);
			doQuickSort(a, st, p - 1);
			doQuickSort(a, p + 1, en);
		}
	}

	private static int partition(int[] A, int lo, int hi) {
		int pivot = A[lo];
		System.out.println("pivot:" + pivot);

		int j = hi;
		for (int i = lo + 1; i < hi;) {
			if (A[i] > pivot) {
				swap(A, i, j);
				j--;
			} else {
				i++;
			}

		}
		swap(A, j, lo);
		return j;
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
