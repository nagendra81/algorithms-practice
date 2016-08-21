package hackerrank.algorithms.search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ConnectedCell {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int M = Integer.parseInt(br.readLine().trim());
		int N = Integer.parseInt(br.readLine().trim());

		int[][] grid = new int[M][N];

		for (int m = 0; m < M; m++) {
			String[] line = br.readLine().split(" ");

			for (int n = 0; n < N; n++) {
				if (line[n].equals("1")) {
					grid[m][n] = 1;
				} else {
					grid[m][n] = 0;
				}
			}
		}
		solve(grid);
	}

	private static void solve(int[][] grid) {

		int M = grid.length;
		int N = grid[0].length;

		int[][] paths = new int[M][N];
		for (int[] v : paths) {
			Arrays.fill(v, 0);
		}

		int cc = 1;
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				if (grid[i][j] == 1 && paths[i][j] == 0) {
					explore(grid, i, j, paths, cc++);
				}
			}
		}

		Map<Integer, Integer> ccCount = new HashMap<>();
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				cc = paths[i][j];
				if (cc > 0) {
					Integer val = ccCount.get(cc);
					if (val == null) {
						val = 0;
					}
					val++;
					ccCount.put(cc, val);
				}
			}
		}

		int res = Integer.MIN_VALUE;
		for (Integer cnt : ccCount.values()) {
			if (cnt > res) {
				res = cnt;
			}
		}

		System.out.println(res);
	}

	private static void explore(int[][] grid, int x, int y, int[][] paths, int cc) {
		int[] dir_x = { 0, 0, 1, -1, -1, -1, 1, 1 };
		int[] dir_y = { 1, -1, 0, 0, -1, 1, -1, 1 };

		int M = grid.length;
		int N = grid[0].length;

		Stack<Cell> stack = new Stack<>();

		stack.push(new Cell(x, y));

		while (!stack.isEmpty()) {
			Cell c = stack.pop();
			if (grid[c.x][c.y] == 1 && paths[c.x][c.y] == 0) {
				paths[c.x][c.y] = cc;
			}
			for (int d = 0; d < 8; d++) {
				int nx = c.x + dir_x[d];
				int ny = c.y + dir_y[d];

				if (nx < 0 || nx >= M || ny < 0 || ny >= N)
					continue;
				// System.out.println("Neighbours: " + nx + ", " + ny + ", paths
				// = " + paths[nx][ny]);
				if (grid[nx][ny] == 1 && paths[nx][ny] == 0) {
					paths[nx][ny] = cc;
					stack.push(new Cell(nx, ny));
				}
			}
		}

	}

	static class Cell {
		int x;
		int y;

		public Cell(int x, int y) {
			this.x = x;
			this.y = y;
		}

		@Override
		public boolean equals(Object obj) {
			Cell that = (Cell) obj;
			return this.x == that.x && this.y == that.y;
		}

		@Override
		public int hashCode() {
			int[] a = new int[] { x, y };
			return Arrays.hashCode(a);
		}

		@Override
		public String toString() {
			return String.format("[x=%d,y=%d]", x, y);
		}

	}

}
