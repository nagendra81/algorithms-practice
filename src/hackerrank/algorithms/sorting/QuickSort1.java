package hackerrank.algorithms.sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class QuickSort1 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine().trim());
		int[] a = new int[N];
		String[] line = br.readLine().split(" ");

		for (int i = 0; i < N; i++) {
			a[i] = Integer.parseInt(line[i]);
		}

		int p = a[0];
		int lt = 0;
		int gt = 0;

		int[] res = new int[N];

		lt = 0;
		gt = N - 1;
		for (int i = 0; i < N; i++) {
			if (a[i] < p) {
				res[lt++] = a[i];

			} else if (a[i] > p) {
				res[gt--] = a[i];
			}
		}

		while (lt <= gt) {
			res[lt++] = p;
		}
		print(res);

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
