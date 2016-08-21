package hackerrank.algorithms.sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InsertionSort1 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine().trim());

		int[] arr = new int[N];

		String[] line = br.readLine().split(" ");
		for (int i = 0; i < arr.length; i++) {
			arr[i] = Integer.parseInt(line[i]);
		}

		int i = N - 1;
		int t = arr[N - 1];
		while (i > 0 && arr[i - 1] > t) {
			arr[i] = arr[i - 1];
			i--;
			print(arr);
		}
		if (i >= 0) {
			arr[i] = t;
		}
		print(arr);

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
