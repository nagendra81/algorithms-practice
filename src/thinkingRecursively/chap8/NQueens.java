package thinkingRecursively.chap8;

import java.util.Arrays;

public class NQueens {

	public static void main(String[] args) {
		int N = 8;

		Board board = new Board(N);
		boolean ok = solve(board, 0);
		System.out.println("res: " + ok);

		board.print();
	}

	static boolean solve(Board board, int col) {

		if (col >= board.getCols()) {
			return true;
		}
		for (int nq = 0; nq < board.getRows(); nq++) {
			if (isSafe(board, nq, col)) {
				PlaceQueen(board, nq, col);
				if (solve(board, col + 1)) {
					return true;
				}
				RemoveQueen(board, nq, col);
			}
		}
		return false;
	}

	private static void RemoveQueen(Board board, int nq, int col) {
		board.set(nq, col, false);
	}

	private static void PlaceQueen(Board board, int nq, int col) {
		board.set(nq, col, true);
	}

	private static boolean isSafe(Board board, int row, int col) {
		for (int i = 0; i < board.getCols(); i++) {
			if (i != col && board.getVal(row, i)) {
				return false;
			}
		}
		for (int i = 0; i < board.getRows(); i++) {
			if (i != row && board.getVal(i, col)) {
				return false;
			}
		}

		int c = 1;
		for (int i = row - 1; i >= 0; i--) {
			if (col + c < board.getCols() && board.getVal(i, col + c)) {
				return false;
			}
			if (col - c >= 0 && board.getVal(i, col - c)) {
				return false;
			}
			c++;
		}

		c = 1;
		for (int i = row + 1; i < board.getRows(); i++) {
			if (col + c < board.getCols() && board.getVal(i, col + c)) {
				return false;
			}
			if (col - c >= 0 && board.getVal(i, col - c)) {
				return false;
			}
			c++;
		}
		return true;
	}

	static class Board {
		private final int N;
		private boolean[][] grid;

		Board(int N) {
			this.N = N;
			this.grid = new boolean[N][N];

			for (boolean[] g : grid) {
				Arrays.fill(g, false);
			}
		}

		public int getRows() {
			return N;
		}

		public int getCols() {
			return N;
		}

		public void set(int row, int col, boolean val) {
			grid[row][col] = val;
		}

		public boolean getVal(int row, int col) {
			return grid[row][col];
		}

		public void print() {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					System.out.printf("%c ", grid[i][j] ? 'Q' : '_');
				}
				System.out.print("\n");
			}
			System.out.println();
		}
	}
}
