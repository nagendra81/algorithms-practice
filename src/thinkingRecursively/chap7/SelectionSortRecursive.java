package thinkingRecursively.chap7;

import java.util.Arrays;

public class SelectionSortRecursive {
	public static void main(String[] args) {

		// int[] vals = { 90, 99, 63, 82, 93, 76, 81, 76 };
		int[] vals = { 2, 3, 7, 7, 3, 5, 5, 3 };
		doSelectionSort(vals, 0);
		System.out.println(Arrays.toString(vals));

	}

	private static void doSelectionSort(int[] vals, int ind) {
		if (ind == vals.length - 1) {
			return;
		} else {
			Entry minEntry = FindMin(vals, ind, vals.length - 1);
			swap(vals, ind, minEntry.index);
			doSelectionSort(vals, ind + 1);
		}

	}

	static void swap(int[] vals, int i, int j) {
		int t = vals[i];
		vals[i] = vals[j];
		vals[j] = t;
	}

	private static Entry FindMin(int[] vals, int fromIn, int toIn) {
		if (fromIn == toIn) {
			return new Entry(fromIn, vals[fromIn]);
		} else {
			int mid = (fromIn + toIn) / 2;
			Entry min1 = FindMin(vals, fromIn, mid);
			Entry min2 = FindMin(vals, mid + 1, toIn);

			if (min1.value < min2.value) {
				return min1;
			} else {
				return min2;
			}
		}
	}

	static class Entry {
		int index;
		int value;

		Entry(int index, int value) {
			this.index = index;
			this.value = value;
		}
	}
}
