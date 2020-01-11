package hackerrank.algorithms.implementation;

import java.util.Scanner;

public class Bomberman {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int R = sc.nextInt();
		int C = sc.nextInt();
		int N = sc.nextInt();

		int[][] board = new int[R][C];

		for (int i = 0; i < R; i++) {
			String line = sc.next();
			for (int j = 0; j < line.length(); j++) {
				int c = line.charAt(j);
				if (c == 79) {
					board[i][j] = 1;
				} else {
					board[i][j] = 0;
				}
			}

		}

		plant(board, 2);
		for (int i = 3; i <= N; i++) {
			explode(board, i - 2);
			plant(board, i);

		}

		char[][] newBoard = new char[R][C];
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (board[i][j] > 0) {
					newBoard[i][j] = 'O';
				} else {
					newBoard[i][j] = '.';
				}
			}
		}

		StringBuilder res = new StringBuilder();
		for (int i = 0; i < newBoard.length; i++) {
			res.append(newBoard[i]);
			res.append(System.lineSeparator());
		}

		System.out.println(res);
	}

	private static void plant(int[][] board, int b) {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				if (board[i][j] == 0) {
					board[i][j] = b;
				}
			}
		}
	}

	private static void explode(int[][] board, int b) {

		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				if (board[i][j] == b) {
					clearNeighbors(board, b, i, j);
				}
			}
		}
	}

	private static void clearNeighbors(int[][] board, int c, int i, int j) {
		board[i][j] = 0;

		if (i - 1 >= 0 && board[i - 1][j] != c) {
			board[i - 1][j] = 0;
		}
		if (i + 1 < board.length && board[i + 1][j] != c) {
			board[i + 1][j] = 0;
		}
		if (j - 1 >= 0 && board[i][j - 1] != c) {
			board[i][j - 1] = 0;
		}
		if (j + 1 < board[0].length && board[i][j + 1] != c) {
			board[i][j + 1] = 0;
		}

	}

}
