package thinkingRecursively.chap7;

import java.util.Arrays;

public class QuickSort {
	public static void main(String[] args) {
		int[] vals = { 90, 99, 63, 82, 93, 76, 81,76 };
		// int[] vals = { 5, 1, 3, 4 };
		// int[] vals = { 2, 3, 7, 7, 3, 5, 5, 3 };
		doQuickSort(vals, 0, vals.length - 1);
		System.out.println(Arrays.toString(vals));

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
		int p = lo;

		for (int i = lo + 1; i <= hi; i++) {
			if (vals[i] < vals[lo]) {
				swap(vals, p + 1, i);
				p++;
			}
		}
		swap(vals, lo, p);
		return p;

	}

	private static void swap(int[] vals, int lo, int hi) {
		int t = vals[lo];
		vals[lo] = vals[hi];
		vals[hi] = t;

	}
}
