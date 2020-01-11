package thinkingRecursively.chap7;

import java.util.Arrays;

public class SelectionSortRecursive {
	public static void main(String[] args) {

		// int[] vals = { 90, 99, 63, 82, 93, 76, 81, 76 };
		int[] vals = { 9, 8, 4, 0, 7, 4, 0, 4, 4, 0 };
		selectionSort(vals, 0);
		System.out.println(Arrays.toString(vals));

	}

	static void selectionSort(int[] arr, int index) {
		if (index == arr.length - 1) {
			return;
		}
		int minIndex = findMinIndex(arr, index + 1);
		swap(arr, index, minIndex);
		selectionSort(arr, index + 1);
	}

	private static void swap(int[] arr, int i, int j) {
		int t = arr[i];
		arr[i] = arr[j];
		arr[j] = t;
	}

	static void selectionSort(int[] arr) {
		for (int i = 0; i < arr.length - 1; i++) {
			int minIndex = findMinIndex(arr, i);
			swap(arr, i, minIndex);
			int t = arr[minIndex];
			arr[minIndex] = arr[i];
			arr[i] = t;
		}

	}

	static int findMinIndex(int[] arr, int fromIndex) {
		int min = arr[fromIndex];
		int minIndex = fromIndex;
		for (int i = fromIndex + 1; i < arr.length; i++) {
			if (arr[i] < min) {
				min = arr[i];
				minIndex = i;
			}
		}
		return minIndex;
	}

}
