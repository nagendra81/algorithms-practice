package thinkingRecursively.chap8;

import java.time.LocalDateTime;

public class NQueens2 {

	static int N = 8;

	public static void main(String[] args) {
		System.out.println(LocalDateTime.now());
		boolean[][] board = new boolean[N][N];

		solve(board, 0, 0);

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (board[i][j]) {
					System.out.printf("%c ", 'Q');
				} else {
					System.out.printf("%c ", '.');
				}
			}
			System.out.print("\n");
		}
		System.out.println(LocalDateTime.now());

	}

	static boolean solve(boolean[][] board, int row, int col) {
		if (col >= 8) {
			return true;
		}

		for (int r = row; r < N; r++) {
			if (isSafe(board, r, col)) {
				board[r][col] = true;
				if (solve(board, 0, col + 1)) {
					return true;
				}
				board[r][col] = false;
			}

		}
		return false;
	}

	static boolean isSafe(boolean[][] board, int row, int col) {
		for (int c = 0; c < N; c++) {
			if (c != col && board[row][c]) {
				return false;
			}
		}

		for (int r = 0; r < N; r++) {
			if (r != row && board[r][col]) {
				return false;
			}
		}

		int r = row - 1;
		int lc = col - 1;
		int rc = col + 1;

		while (r >= 0 && lc >= 0 && rc < N) {
			if (board[r][lc] || board[r][rc]) {
				return false;
			}
			r--;
			lc--;
			rc++;
		}

		r = row + 1;
		lc = col - 1;
		rc = col + 1;

		while (r < N && lc >= 0 && rc < N) {
			if (board[r][lc] || board[r][rc]) {
				return false;
			}
			r++;
			lc--;
			rc++;
		}
		return true;

	}

}
