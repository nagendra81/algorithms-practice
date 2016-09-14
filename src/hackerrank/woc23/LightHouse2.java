package hackerrank.woc23;

import java.util.Scanner;

public class LightHouse2 {
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

	}

}
