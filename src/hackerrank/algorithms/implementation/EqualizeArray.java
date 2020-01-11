package hackerrank.algorithms.implementation;

import java.util.Arrays;
import java.util.Scanner;

public class EqualizeArray {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			int n = sc.nextInt();

			int[] arr = new int[101];
			Arrays.fill(arr, 0);

			for (int i = 0; i < n; i++) {
				int v = sc.nextInt();
				arr[v]++;
			}
			// System.out.println(Arrays.toString(arr));

			int max = 0;
			for (int i : arr) {
				if (i > max) {
					max = i;
				}
			}
			System.out.println(n - max);
		}
	}
}
