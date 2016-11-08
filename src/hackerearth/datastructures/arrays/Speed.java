package hackerearth.datastructures.arrays;

import java.util.Scanner;

public class Speed {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int t = 0; t < T; t++) {
			int N = sc.nextInt();
			int[] arr = new int[N];

			for (int i = 0; i < N; i++) {
				arr[i] = sc.nextInt();
			}
			solve(arr, N);
		}
	}

	private static void solve(int[] arr, int N) {

		int res = 1;
		for (int i = 1; i < N; i++) {
			if (arr[i] <= arr[i - 1])
				res++;
		}
		System.out.println(res);

	}

}
