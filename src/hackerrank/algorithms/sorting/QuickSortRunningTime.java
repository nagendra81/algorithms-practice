package hackerrank.algorithms.sorting;

import java.util.Arrays;
import java.util.Scanner;

public class QuickSortRunningTime {
	static int swaps = 0;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int[] arr = new int[N];

		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}

		int[] arr2 = Arrays.copyOf(arr, N);
		doQuickSort(arr, 0, N - 1);

		int shifts = insertionSortTime(arr2);
		System.out.println(shifts - swaps);
	}

	private static void doQuickSort(int[] vals, int lo, int hi) {
		if (lo >= hi) {
			return;
		} else {
			int p = partition(vals, lo, hi);
			doQuickSort(vals, lo, p - 1);
			doQuickSort(vals, p + 1, hi);
		}
	}

	private static int partition(int[] vals, int lo, int hi) {
		int p = vals[hi];

		int i = lo;
		for (int j = lo; j <= hi - 1; j++) {
			if (vals[j] <= p) {
				swap(vals, i, j);
				i++;
				swaps++;
			}
		}
		swap(vals, i, hi);
		swaps++;
		return i;

	}

	private static void swap(int[] vals, int lo, int hi) {
		int t = vals[lo];
		vals[lo] = vals[hi];
		vals[hi] = t;

	}

	private static void print(int[] vals, int lo, int hi) {
		if (lo >= hi) {
			return;
		}
		StringBuilder sb = new StringBuilder();
		for (int i = lo; i <= hi; i++) {
			sb.append(vals[i] + " ");
		}
		System.out.println(sb.toString().trim());
	}

	static int insertionSortTime(int[] a) {
		int N = a.length;
		int shifts = 0;
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
		return shifts;

	}

}
