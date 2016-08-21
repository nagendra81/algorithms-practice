package hackerrank.algorithms.implementation;

import java.util.Scanner;

public class FairRations {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();

		int[] arr = new int[N];

		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}

		int cnt = 0;
		for (int i = 0; i < N - 1; i++) {
			if (isOdd(arr[i])) {
				arr[i]++;
				cnt++;
				if (i + 1 <= N - 1) {
					arr[i + 1]++;
					cnt++;
				}

			}
		}

		for (int i = 0; i < N; i++) {
			if (isOdd(arr[i])) {
				System.out.println("NO");
				return;
			}
		}
		System.out.println(cnt);

	}

	private static boolean isOdd(int k) {
		return (k & 1) == 1;
	}

}
