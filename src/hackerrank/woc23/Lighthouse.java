package hackerrank.woc23;

import java.util.Scanner;

public class Lighthouse {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();

		char[][] grid = new char[N][N];

		for (int i = 0; i < N; i++) {
			String s = sc.next();
			grid[i] = s.toCharArray();

		}

		solve(grid, N);
	}

	private static void solve(char[][] grid, int N) {
		int maxBound = Integer.MIN_VALUE;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (grid[i][j] == '.') {

					maxBound = Math.max(maxBound, getMaxBound(grid, i, j, N));
				}
			}
		}
		System.out.println(maxBound);

	}

	private static int getMaxBound(char[][] grid, int i, int j, int N) {
		int up = 0;

		int k = i - 1;
		while (k >= 0) {
			if (grid[k--][j] == '.') {
				up++;
			} else {
				break;
			}
		}

		int down = 0;
		k = i + 1;
		while (k < N) {
			if (grid[k++][j] == '.') {
				down++;
			} else {
				break;
			}
		}

		int left = 0;

		k = j - 1;

		while (k >= 0) {
			if (grid[i][k--] == '.') {
				left++;
			} else {
				break;
			}
		}

		int right = 0;

		k = j + 1;
		while (k < N) {
			if (grid[i][k++] == '.') {
				right++;
			} else {
				break;
			}
		}

		int r = min(left, right, down, up);

		/*
		 * int res = Integer.MIN_VALUE; while (r >= 0) { res = Math.max(res,
		 * tryFit(r, grid, i, j, N) ? r : Integer.MIN_VALUE); r--; }
		 */

		return r;

	}

	private static boolean tryFit(int r, char[][] grid, int i, int j, int n) {

		System.out.println("trfit");
		int k = i;

		while (k <= i + r) {
			if (grid[k++][j] != '.') {
				return false;
			}
		}

		k = i;
		while (k >= i - r) {
			if (grid[k--][j] != '.') {
				return false;
			}
		}

		k = j;
		while (k <= j + r) {
			if (grid[i][k++] != '.') {
				return false;
			}
		}

		k = j;
		while (k >= j - r) {
			if (grid[i][k--] != '.') {
				return false;
			}
		}
		return true;

	}

	private static int min(int left, int right, int down, int up) {
		return Math.min(Math.min(left, right), Math.min(up, down));
	}
}
