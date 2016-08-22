package thinkingRecursively.chap7;

import java.util.Arrays;

public class MergeSort {
	public static void main(String[] args) {

		int[] vals = { 90, 99, 63, 82, 93, 76, 81, 76 };
		// int[] vals = { 2, 3, 7, 7, 3, 5, 5, 3 };
		doMergeSort(vals, 0, vals.length - 1);
		System.out.println(Arrays.toString(vals));
	}

	private static void doMergeSort(int[] vals, int lo, int hi) {
		if (lo >= hi) {
			return;
		} else {
			int mid = (lo + hi) / 2;
			doMergeSort(vals, lo, mid);
			doMergeSort(vals, mid + 1, hi);

			merge(vals, lo, mid, hi);
		}
	}

	static void merge(int[] vals, int lo, int mid, int hi) {
		int[] tmp = new int[hi - lo + 1];

		int ti = 0;
		int l = lo;
		int m = mid + 1;
		while (l <= mid || m <= hi) {
			if (l > mid) {
				tmp[ti++] = vals[m++];
			} else if (m > hi) {
				tmp[ti++] = vals[l++];
			} else {
				if (vals[l] < vals[m]) {
					tmp[ti++] = vals[l++];
				} else {
					tmp[ti++] = vals[m++];
				}
			}
		}

		for (int i = 0, j = lo; i < tmp.length; i++, j++) {
			vals[j] = tmp[i];
		}
	}
}
