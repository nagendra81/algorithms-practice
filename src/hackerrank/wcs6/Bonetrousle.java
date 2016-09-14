package hackerrank.wcs6;

import java.util.Arrays;
import java.util.Scanner;

public class Bonetrousle {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int t = 0; t < T; t++) {
			int N = sc.nextInt();
			int K = sc.nextInt();
			int B = sc.nextInt();

			int r = solve(N, K, B);
			System.out.println(r);
		}
	}

	private static int solve(int n, int k, int b) {
		if (n > ((k * (k + 1)) / 2)) {
			return -1;
		}
		int[] paths = new int[b];
		return solve(n, k, b, 0, paths, 0);
	}

	private static int solve(int target, int k, int b, int sum, int[] paths, int pi) {

		System.out.println("paths: " + Arrays.toString(paths));
		if (b == 0 || k == 0) {
			if (sum == target) {
				System.out.println(Arrays.toString(Arrays.copyOf(paths, pi)));
			}
			return 0;
		} else {
			paths[pi] = k;
			solve(target, k - 1, b - 1, sum + k, paths, pi + 1);
			paths[pi] = 0;
			solve(target, k, b - 1, sum, paths, pi);
			return 0;
		}

	}

}
