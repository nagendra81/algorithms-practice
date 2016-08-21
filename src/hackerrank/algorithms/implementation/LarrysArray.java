package hackerrank.algorithms.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LarrysArray {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine().trim());

		for (int t = 0; t < T; t++) {
			int N = Integer.parseInt(br.readLine().trim());
			int[] A = new int[N];
			String[] line = br.readLine().split(" ");
			for (int i = 0; i < N; i++) {
				A[i] = Integer.parseInt(line[i].trim());
			}
			solve(A);

		}

	}

	private static void solve(int[] A) {
		int cnt = 0;
		for (int i = 0; i < A.length; i++) {
			for (int j = i + 1; j < A.length; j++) {
				if (A[i] > A[j]) {
					cnt++;
				}
			}
		}
		// System.out.println(cnt);
		if (cnt == 0) {
			System.out.println("YES");
			return;
		}

		if ((cnt % 2) == 1) {
			System.out.println("NO");
		} else {
			System.out.println("YES");
		}

	}

}
