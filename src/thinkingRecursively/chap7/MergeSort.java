package thinkingRecursively.chap7;

import java.util.Arrays;

public class MergeSort {
	public static void main(String[] args) {

		// int[] vals = { 90, 99, 63, 82, 93, 76, 81, 76 };
		int[] vals = { 2, 3, 7, 7, 3, 5, 5 };
		sort(vals);
		System.out.println(Arrays.toString(vals));
	}

	private static void sort(int[] arr) {
		if (arr.length > 1) {
			int mid = arr.length / 2;
			int[] a1 = subarray(arr, 0, mid);
			int[] a2 = subarray(arr, mid, arr.length);
			sort(a1);
			sort(a2);
			merge(arr, a1, a2);
		}

	}

	private static void merge(int[] arr, int[] a1, int[] a2) {
		int i1 = 0, i2 = 0;
		int n1 = a1.length, n2 = a2.length;
		for (int i = 0; i < arr.length; i++) {
			if (i2 == n2 || (i1 < n1 && a1[i1] < a2[i2])) {
				arr[i] = a1[i1++];
			} else {
				arr[i] = a2[i2++];
			}
		}
	}

	private static int[] subarray(int[] arr, int s, int e) {
		int[] sub = new int[e - s];
		for (int i = s; i < e; i++) {
			sub[i - s] = arr[i];
		}
		return sub;
	}

}
