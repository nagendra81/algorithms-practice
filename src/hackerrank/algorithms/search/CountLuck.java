package hackerrank.algorithms.search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;

public class CountLuck {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			String[] line = br.readLine().split(" ");
			int N = Integer.parseInt(line[0].trim());
			int M = Integer.parseInt(line[1].trim());

			char[][] grid = new char[N][M];

			int x, y;

			x = y = -1;
			for (int n = 0; n < N; n++) {
				String line1 = br.readLine().trim();

				for (int m = 0; m < line1.length(); m++) {
					grid[n][m] = line1.charAt(m);
					if (grid[n][m] == 'M') {
						x = n;
						y = m;
					}
				}
			}

			int K = Integer.parseInt(br.readLine().trim());

			boolean[][] visited = new boolean[N][M];

			Stack<Cell> stack = new Stack<>();
			Cell c = new Cell(x, y, K);
			stack.push(c);

			solve(grid, visited, stack, K);

		}
	}

	private static void solve(char[][] grid, boolean[][] visited, Stack<Cell> stack, int K) {

		int N = grid.length;
		int M = grid[0].length;

		while (!stack.isEmpty()) {
			Cell c = stack.pop();
			// System.out.println(c.x + "," + c.y + " visited: " +
			// visited[c.x][c.y]);
			if (grid[c.x][c.y] == '*') {
				// System.out.println("*****");
				if (c.K == 0) {
					System.out.println("Impressed");
				} else {
					System.out.println("Oops!");
				}
				break;
			}
			if (visited[c.x][c.y]) {
				continue;
			}
			if (grid[c.x][c.y] == 'X') {
				visited[c.x][c.y] = true;
				continue;
			}

			visited[c.x][c.y] = true;

			Cell up, down, left, right;

			up = down = left = right = null;

			int choices = 0;
			if (c.x < N - 1 && isValidCell(grid[c.x + 1][c.y]) && !visited[c.x + 1][c.y]) { // down
				down = new Cell(c.x + 1, c.y, K);
				choices++;
			}
			if (c.x > 0 && isValidCell(grid[c.x - 1][c.y]) && !visited[c.x - 1][c.y]) { // up
				up = new Cell(c.x - 1, c.y, K);
				choices++;
			}
			if (c.y < M - 1 && isValidCell(grid[c.x][c.y + 1]) && !visited[c.x][c.y + 1]) { // right
				right = new Cell(c.x, c.y + 1, K);
				choices++;
			}
			if (c.y > 0 && isValidCell(grid[c.x][c.y - 1]) && !visited[c.x][c.y - 1]) { // left
				left = new Cell(c.x, c.y - 1, K);
				choices++;
			}

			int newK = c.K;

			if (choices > 1) {
				newK = c.K - 1;
				// System.out.printf("x=%d,y=%d,k=%d\n", c.x, c.y, newK);

			}

			if (up != null) {
				up.K = newK;
				stack.push(up);
			}
			if (down != null) {
				down.K = newK;
				stack.push(down);
			}

			if (left != null) {
				left.K = newK;
				stack.push(left);
			}

			if (right != null) {
				right.K = newK;
				stack.push(right);
			}
		}
	}

	private static boolean isValidCell(char c) {
		switch (c) {
		case '*':
		case '.':
			return true;
		}
		return false;

	}

	static class Cell {
		int x;
		int y;
		int K;

		public Cell(int x, int y, int K) {
			this.x = x;
			this.y = y;
			this.K = K;
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
			return String.format("[x=%d,y=%d,k=%d]", x, y, K);
		}

	}

}
