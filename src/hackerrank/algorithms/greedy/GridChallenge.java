package hackerrank.algorithms.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class GridChallenge {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine().trim());

		for (int t = 0; t < T; t++) {
			int N = Integer.parseInt(br.readLine().trim());

			char[][] grid = new char[N][N];

			for (int i = 0; i < N; i++) {

				char[] line = br.readLine().trim().toCharArray();
				Arrays.sort(line);
				grid[i] = line;
			}

			solve(grid);

		}
	}

	private static void solve(char[][] grid) {

		int N = grid.length;
		for (int j = 0; j < N; j++) {
			for (int i = 0; i < N - 1; i++) {
				if (grid[i][j] > grid[i + 1][j]) {
					System.out.println("NO");
					return;
				}
			}
		}
		System.out.println("YES");

	}

}
