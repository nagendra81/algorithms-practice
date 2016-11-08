package hackerearth.algorithms.dynamic;

import java.util.Scanner;

public class IntelligentGirl {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		char[] arr = sc.next().toCharArray();

		int N = arr.length;

		int[] dp = new int[N + 1];
		dp[N] = 0;

		for (int i = N - 1; i >= 0; i--) {
			if (isEven(arr[i])) {
				dp[i] = dp[i + 1] + 1;
			} else {
				dp[i] = dp[i + 1];
			}
		}

		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < N; i++) {
			sb.append(dp[i] + " ");
		}
		System.out.println(sb);
	}

	private static boolean isEven(char c) {
		switch (c) {
		case '2':
		case '4':
		case '6':
		case '8':
			return true;
		default:
			return false;

		}
	}

}
