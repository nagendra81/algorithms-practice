package hackerrank.algorithms.sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BiggerGreater {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		for (int t = 0; t < T; t++) {
			String line = br.readLine().trim();
			solve(line.toCharArray());
		}
	}

	private static void solve(char[] arr) {

		int pivot = arr.length - 1;

		while (pivot > 0 && arr[pivot] <= arr[pivot - 1]) {
			pivot--;
		}
		if (pivot <= 0) {
			System.out.println("no answer");
			return;
		}

		pivot--;

		int n = arr.length - 1;
		for (int i = n; i >= pivot; i--) {
			if (arr[i] > arr[pivot]) {
				char t = arr[i];
				arr[i] = arr[pivot];
				arr[pivot] = t;
				break;
			}
		}

		reverse(arr, pivot + 1);
		System.out.println(new String(arr));

	}

	private static void reverse(char[] arr, int k) {
		int i = k;
		int j = arr.length - 1;

		while (i <= j) {
			char c = arr[i];
			arr[i] = arr[j];
			arr[j] = c;
			i++;
			j--;
		}

	}
}
