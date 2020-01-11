package thinkingRecursively.chap8;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class KnightsTour2 {

	static int N = 8;

	public static void main(String[] args) {

		int[][] board = new int[N][N];
		for (int[] b : board) {
			Arrays.fill(b, -1);
		}
		System.out.println(LocalDateTime.now());
		solve(board, 1, 0, 0);

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.printf("%2d ", board[i][j]);
			}
			System.out.print("\n");
		}
		System.out.println(LocalDateTime.now());
	}

	private static boolean solve(int[][] board, int p, int x, int y) {
		// System.out.println(p);
		int[][] moves = nextMove(board, x, y);

		if (isSolved(board)) {
			return true;
		} else if (moves.length == 0) {
			return false;
		}

		for (int m = 0; m < moves.length; m++) {
			int mx = moves[m][0];
			int my = moves[m][1];

			board[mx][my] = p;

			if (solve(board, p + 1, mx, my)) {
				return true;
			}
			board[mx][my] = -1;
		}

		return false;

	}

	private static boolean isSolved(int[][] board) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (board[i][j] == -1) {
					return false;
				}
			}
		}
		return true;
	}

	static int[][] nextMove(int[][] board, int x, int y) {

		int[] dx = new int[] { -1, -1, -2, -2, 1, 1, 2, 2 };
		int[] dy = new int[] { -2, 2, -1, 1, -2, 2, -1, 1 };

		List<int[]> next = new ArrayList<>();

		for (int i = 0; i < N; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];

			if (nx >= 0 && nx < 8 && ny >= 0 && ny < 8 && board[nx][ny] == -1) {
				next.add(new int[] { nx, ny });
			}
		}
		int[][] moves = new int[next.size()][];
		int i = 0;
		for (int[] n : next) {
			moves[i++] = n;
		}
		return moves;

	}

}
