package hackerrank.algorithms.search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SherlockAndArray {
	public static void main(String[] args) throws IOException {
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
		if (A.length == 1) {
			System.out.println("YES");
			return;
		}
		long rightSum = 0;
		for (int a : A) {
			rightSum += a;
		}

		int leftSum = A[0];
		rightSum -= A[0];

		for (int i = 1; i < A.length; i++) {
			if (leftSum == rightSum - A[i]) {
				System.out.println("YES");
				return;
			}
			leftSum += A[i];
			rightSum -= A[i];
		}
		System.out.println("NO");

	}

}
