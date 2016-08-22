package thinkingRecursively.chap8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class KnightsTour {
	public static void main(String[] args) {
		int N = 8;
		Board board = new Board(N, N);

		board.setVal(0, 0, 1);
		boolean ok = solve(board, 0, 0, 1);

		System.out.println("result: " + ok);
		board.print();

	}

	static boolean solve(Board board, int row, int col, int val) {
		if (board.allCellsAssigned()) {
			return true;
		} else if (isDeadEnd(board, row, col)) {
			return false;
		}

		for (int[] moves : board.getLegalMovesFrom(row, col)) {
			if (board.getVal(moves[0], moves[1]) == Board.UNASSIGNED) {
				board.setVal(moves[0], moves[1], val + 1);

				if (solve(board, moves[0], moves[1], val + 1))
					return true;

				board.unSetVal(moves[0], moves[1]);
			}
		}
		return false;

	}

	private static boolean isDeadEnd(Board board, int row, int col) {
		for (int[] moves : board.getLegalMovesFrom(row, col)) {
			if (board.getVal(moves[0], moves[1]) == Board.UNASSIGNED) {
				return false;
			}
		}
		return true;
	}

	static class Board {
		public static final int UNASSIGNED = -1;
		private final int numRows;
		private int numCols;

		private final int[][] grid;

		Board(int numRows, int numCols) {
			this.numRows = numRows;
			this.numCols = numCols;

			this.grid = new int[numRows][numCols];
			for (int[] g : grid) {
				Arrays.fill(g, UNASSIGNED);
			}
		}

		public boolean allCellsAssigned() {
			for (int i = 0; i < numRows; i++) {
				for (int j = 0; j < numCols; j++) {
					if (grid[i][j] == UNASSIGNED)
						return false;
				}
			}
			return true;
		}

		public void print() {
			for (int i = 0; i < numRows; i++) {
				for (int j = 0; j < numCols; j++) {
					System.out.printf("%2d ", grid[i][j]);
				}
				System.out.print("\n");
			}
			System.out.println();
		}

		public int getRows() {
			return this.numRows;
		}

		public int getCols() {
			return this.numCols;
		}

		public int getVal(int row, int col) {
			return grid[row][col];
		}

		public void setVal(int row, int col, int val) {
			grid[row][col] = val;
		}

		public void unSetVal(int row, int col) {
			grid[row][col] = UNASSIGNED;
		}

		public int[][] getLegalMovesFrom(int row, int col) {
			List<int[]> moves = new ArrayList<>(8);

			int[] rd = { -2, -2, -1, -1, +1, +1, +2, +2 };
			int[] cd = { -1, +1, -2, +2, -2, +2, +1, -1 };

			int nr = -1, nc = -1;
			for (int i = 0; i < 8; i++) {
				nr = row + rd[i];
				nc = col + cd[i];
				if (nr >= 0 && nr < numRows && nc >= 0 && nc < numCols) {
					moves.add(new int[] { nr, nc });
				}
			}

			int[][] moves2Arr = new int[moves.size()][];

			int m = 0;
			for (int[] mo : moves) {
				moves2Arr[m++] = mo;
			}

			return moves2Arr;
		}
	}
}
