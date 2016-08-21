package hackerrank.algorithms.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class GridSearch {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine().trim());

		for (int t = 0; t < T; t++) {
			String[] line = br.readLine().split(" ");
			int R = Integer.parseInt(line[0].trim());
			int C = Integer.parseInt(line[1].trim());

			char[][] grid = new char[R][C];

			for (int i = 0; i < R; i++) {
				String line1 = br.readLine().trim();

				for (int j = 0; j < line1.length(); j++) {
					grid[i][j] = line1.charAt(j);
				}

			}

			line = br.readLine().split(" ");
			int r = Integer.parseInt(line[0].trim());
			int c = Integer.parseInt(line[1].trim());

			char[][] pattern = new char[r][c];

			for (int i = 0; i < r; i++) {
				String line1 = br.readLine().trim();
				for (int j = 0; j < line1.length(); j++) {
					pattern[i][j] = line1.charAt(j);
				}
			}
			solve(grid, pattern, R, C, r, c);
		}
	}

	private static void solve(char[][] grid, char[][] pattern, int R, int C, int pr, int pc) {

		if (pr > R || pc > C) {
			System.out.println("NO");
			return;
		}

		boolean isMatch = true;
		for (int i = 0; i < R - pr + 1; i++) {
			for (int j = 0; j < C - pc + 1; j++) {
				isMatch = true;
				// System.out.printf("Grid: (%d, %d)\n", i, j);
				int si = 0;
				int sj = 0;
				for (si = 0; si < pr; si++) {
					for (sj = 0; sj < pc; sj++) {
						if (grid[si + i][sj + j] != pattern[si][sj]) {
							// System.out.println("g: " + grid[si + i].charAt(sj
							// + j) + ", p: " + pattern[si].charAt(sj));
							isMatch = false;
							break;
						}
					}
				}
				if (isMatch && si == pr && sj == pc) {
					break;
				}
			}
			if (isMatch) {
				break;
			}
		}
		if (isMatch) {
			System.out.println("YES");
		} else {
			System.out.println("NO");
		}

	}

}
