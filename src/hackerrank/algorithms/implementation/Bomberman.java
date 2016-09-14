package hackerrank.algorithms.implementation;

import java.util.Scanner;

public class Bomberman {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int R = sc.nextInt();
		int C = sc.nextInt();
		int N = sc.nextInt();

		char[][] board = new char[R][C];

		for (int i = 0; i < R; i++) {
			board[i] = sc.next().toCharArray();
		}

		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (board[i][j] == 'O') {
					board[i][j] = 'R';
				}
			}
		}

		if (N > 3) {
			N = (N - 2) % 4;
		}
		for (int t = 2; t <= N; t++) {

			if (t % 4 == 1) {
				explode(board, 'B');
			} else if (t % 2 == 0 && t % 4 != 0) {
				plant(board, 'B');
			} else if (t % 4 == 3) {
				explode(board, 'R');
			} else if (t % 4 == 0) {
				plant(board, 'R');
			}
		}

		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (board[i][j] == 'R' || board[i][j] == 'B') {
					board[i][j] = 'O';
				}
			}
		}

		StringBuilder res = new StringBuilder();
		for (int i = 0; i < board.length; i++) {
			res.append(board[i]);
			res.append("\n");
		}

		System.out.println(res);
	}

	private static void plant(char[][] board, char c) {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				if (board[i][j] == '.') {
					board[i][j] = c;
				}
			}
		}

	}

	private static void explode(char[][] board, char c) {

		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				if (board[i][j] == c) {
					clearNeighbors(board, c, i, j);
				}
			}
		}
	}

	private static void clearNeighbors(char[][] board, char c, int i, int j) {
		board[i][j] = '.';

		if (i - 1 >= 0 && board[i - 1][j] != c) {
			board[i - 1][j] = '.';
		}
		if (i + 1 < board.length && board[i + 1][j] != c) {
			board[i + 1][j] = '.';
		}
		if (j - 1 >= 0 && board[i][j - 1] != c) {
			board[i][j - 1] = '.';
		}
		if (j + 1 < board[0].length && board[i][j + 1] != c) {
			board[i][j + 1] = '.';
		}

	}

}
