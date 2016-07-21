package hackerrank.algorithms.dynamic;

import java.io.IOException;
import java.util.Scanner;

public class StockMaximize {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int t = 0; t < T; t++) {
			int N = sc.nextInt();
			int[] stocks = new int[N];
			for (int i = 0; i < N; i++) {
				stocks[i] = sc.nextInt();
			}
			solve(stocks);
		}

	}

	private static void solve(int[] st) {
		int N = st.length;
		int[] sell = new int[N];

		sell[N - 1] = st[N - 1];

		for (int i = N - 2; i >= 0; i--) {
			sell[i] = Math.max(sell[i + 1], st[i]);
		}

		long profit = 0;

		for (int i = 0; i < st.length; i++) {
			profit += sell[i] - st[i];
		}

		System.out.println(profit);
	}

}
