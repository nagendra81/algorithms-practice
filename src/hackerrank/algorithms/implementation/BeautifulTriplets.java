package hackerrank.algorithms.implementation;

import java.util.Arrays;
import java.util.Scanner;

public class BeautifulTriplets {
	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			int n = sc.nextInt();
			int d = sc.nextInt();

			int[] arr = new int[20001];
			Arrays.fill(arr, 0);

			for (int i = 0; i < n; i++) {
				int val = sc.nextInt();
				arr[val]++;
			}

			int res = 0;
			for (int i = 0; i < arr.length; i++) {
				if (i - d >= 0 && i + d < arr.length) {
					res += (arr[i - d] * arr[i] * arr[i + d]);
				}
			}
			System.out.println(res);
		}
	}
}
