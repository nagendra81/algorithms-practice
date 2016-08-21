package hackerrank.algorithms.search;

import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class BillBoards2 {
	public static void main(String[] args) throws FileNotFoundException {

		Scanner in = new Scanner(System.in);
		// Scanner in = new Scanner(new
		// FileInputStream("C:\\Users\\nchumbal\\Desktop\\billboards\\input.txt"));

		int N = in.nextInt();
		int K = in.nextInt();

		int[] bb = new int[N];
		for (int i = 0; i < N; i++)
			bb[i] = in.nextInt();

		new BillBoards2().solve(bb, N, K);
	}

	private void solve(int[] bb, int N, int K) {
		int[] dp = new int[N];
		Arrays.fill(dp, 0);

		for (int i = 0; i < K; i++)
			dp[i] = bb[i];

		for (int i = K; i < N; i++) {
			for (int j = K-i; j <= K; j++) {

			}
		}
	}

}
