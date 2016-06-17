package sdgupta.chapter2;

import java.util.Arrays;

public class MergeSort {

	public static void main(String[] args) {
		int[] arr = { 9, 9, 4, 0, 0, 2, 0, 4, 4, 0 };
		mergesort(arr);
		System.out.println(Arrays.toString(arr));
	}

	private static void mergesort(int[] arr) {
		int n = arr.length;
		if (n > 1) {
			int[] s = split(arr, 0, n / 2);
			int[] t = split(arr, (n / 2), n);

			mergesort(s);
			mergesort(t);

			merge(s, t, 0, n, arr);
		}
	}

	private static void merge(int[] s, int[] t, int l, int r, int[] arr) {
		int sn = s.length;
		int tn = t.length;

		int[] res = new int[sn + tn];

		int si = 0;
		int ti = 0;

		int ri = 0;

		while (si < sn || ti < tn) {
			if (si < sn && ti < tn) {
				if (s[si] < t[ti]) {
					res[ri++] = s[si++];
				} else if (ti < tn) {
					res[ri++] = t[ti++];
				}
			} else if (si < sn) {
				res[ri++] = s[si++];
			} else if (ti < tn) {
				res[ri++] = t[ti++];
			}
		}
		ri = 0;
		for (int k = l; k < r; k++) {
			arr[k] = res[ri++];
		}
	}

	private static int[] split(int[] arr, int i, int j) {
		int[] res = new int[j - i];
		int k = 0;
		while (i < j) {
			res[k++] = arr[i++];
		}
		return res;

	}

}
