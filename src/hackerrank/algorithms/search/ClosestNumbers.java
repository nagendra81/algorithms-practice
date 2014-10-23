package hackerrank.algorithms.search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class ClosestNumbers {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		int ar[] = new int[N];

		String tmp[] = br.readLine().split(" ");

		for (int i = 0; i < N; i++) {
			ar[i] = Integer.parseInt(tmp[i]);
		}
		solve(N, ar);

	}

	private static void solve(int n, int[] ar) {
		Arrays.sort(ar);

		int m1 = Math.abs(ar[1] - ar[0]);

		for (int i = 2; i < ar.length; i++) {
			if (Math.abs(ar[i] - ar[i - 1]) < m1) {
				m1 = Math.abs(ar[i] - ar[i - 1]);
			}
		}
		for (int i = 1; i < ar.length; i++) {
			if (Math.abs(ar[i] - ar[i - 1]) == m1) {
				System.out.printf("%d %d ", ar[i - 1], ar[i]);
			}
		}
	}
}
