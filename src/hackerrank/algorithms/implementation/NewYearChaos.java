package hackerrank.algorithms.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class NewYearChaos {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine().trim());

		for (int t = 0; t < T; t++) {
			int N = Integer.parseInt(br.readLine().trim());
			int[] queue = new int[N];

			String[] line = br.readLine().split(" ");
			for (int i = 0; i < N; i++) {
				queue[i] = Integer.parseInt(line[i]);
			}
			// System.out.println(Arrays.toString(queue));
			solve(queue, N);
		}

	}

	private static void solve(int[] A, int N) {
		int sum = 0;

		for (int i = 0; i < N; i++) {
			if (A[i] - i - 1 > 2) {
				System.out.println("Too chaotic");
				return;
			}
		}

		for (int i = 0; i < N; i++) {
			int cnt = 0;
			boolean swapped = false;
			for (int j = 0; j < N - 1; j++) {
				if (A[j] > A[j + 1]) {
					swap(A, j, j + 1);
					cnt++;
					swapped = true;
				}
			}
			if (cnt > 2) {
				// System.out.println("Too chaotic");
				// return;
			}
			sum += cnt;
			if (swapped == false) {
				break;
			}
		}
		System.out.println(sum);

	}

	private static void swap(int[] a, int i, int j) {
		int t = a[i];
		a[i] = a[j];
		a[j] = t;

	}

}
