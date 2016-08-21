package sdgupta.chapter2;

import java.util.Arrays;

public class Median {
	public static void main(String[] args) {
		int[] arr = { 2, 36, 5, 21, 8, 13, 11, 20, 5, 4, 1 };
		int k = 5;
		split(arr, k);
		System.out.println(Arrays.toString(arr));

	}

	private static void split(int[] arr, int k) {
		int start = 0;
		int end = arr.length - 1;

		while (start < end) {

			if (arr[start] <= k) {
				start++;
				continue;
			}
			if (arr[end] > k) {
				end--;
				continue;
			}

			int t = arr[start];
			arr[start] = arr[end];
			arr[end] = t;
			start++;
			end--;

			System.out.println(Arrays.toString(arr));

		}
		System.out.println("start = " + start + ", end = " + end);

	}

}
