package hackerrank.algorithms.warmup;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DiagonalDifference {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		int[][] arr = new int[N][N];

		for (int i = 0; i < N; i++) {
			String[] line = br.readLine().split(" ");
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(line[j]);
			}

		}

		solve(arr, N);

	}

	private static void solve(int[][] arr, int N) {
		int sum1 = 0;
		for (int i = 0; i < N; i++) {

			sum1 += arr[i][i];

		}

		int sum2 = 0;

		for (int i = N - 1; i >= 0; i--) {
			sum2 += arr[i][N - 1 - i];

		}
		System.out.println(Math.abs(sum1 - sum2));

	}
}
