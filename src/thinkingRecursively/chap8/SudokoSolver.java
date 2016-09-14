package thinkingRecursively.chap8;

import java.util.Arrays;

public class SudokoSolver {
	private static final int N = 9;
	private static final int UNASSIGNED = 0;
	private static volatile int[][] board = new int[N][N];

	public static void main(String[] args) {

		for (int[] b : board) {
			Arrays.fill(b, UNASSIGNED);
		}

		prePopulateBoard(board);
		boolean ok = solve(board);
		System.out.println("res: " + ok);
		print(board);

	}

	private static void prePopulateBoard(int[][] board) {
		board[0] = new int[] { 8, 0, 0, 0, 6, 0, 3, 9, 7 };
		board[1] = new int[] { 9, 1, 0, 2, 0, 0, 0, 0, 0 };
		board[2] = new int[] { 0, 0, 0, 4, 0, 0, 0, 0, 0 };
		board[3] = new int[] { 0, 0, 7, 9, 0, 0, 0, 0, 0 };
		board[4] = new int[] { 0, 0, 4, 0, 0, 0, 0, 2, 5 };
		board[5] = new int[] { 2, 0, 0, 6, 7, 0, 0, 0, 0 };
		board[6] = new int[] { 0, 0, 0, 0, 9, 1, 0, 0, 0 };
		board[7] = new int[] { 4, 0, 0, 0, 0, 0, 0, 3, 0 };
		board[8] = new int[] { 0, 0, 0, 0, 0, 0, 6, 1, 0 };

	}

	private static void print(int[][] board) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.printf("%d ", board[i][j]);
			}
			System.out.println();
		}
		System.out.println("----");
	}

	private static boolean solve(int[][] board) {

		int[] pos = getNextEmptyCell(board);
		if (pos == null) {
			return true;
		}
		// print(board);
		int row = pos[0];
		int col = pos[1];
		for (int val = 1; val <= N; val++) {
			if (isConstraintSatisfied(board, row, col, val)) {
				board[row][col] = val;

				if (solve(board)) {
					return true;
				}

				board[row][col] = UNASSIGNED;
			}
		}
		return false;
	}

	private static int[] getNextEmptyCell(int[][] board) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (board[i][j] == UNASSIGNED) {
					return new int[] { i, j };
				}
			}
		}
		return null;
	}

	private static boolean isConstraintSatisfied(int[][] board, int row, int col, int val) {
		// Check row
		for (int j = 0; j < N; j++) {
			if (board[row][j] == val) {
				return false;
			}
		}

		// Check col
		for (int i = 0; i < N; i++) {
			if (board[i][col] == val) {
				return false;
			}
		}

		int startRow = row - (row % 3);
		int startCol = col - (col % 3);
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (board[i + startRow][j + startCol] == val)
					return false;
			}
		}

		return true;
	}

}
