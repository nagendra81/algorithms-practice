package thinkingRecursively.chap8;

import java.util.Arrays;

public class MazeGame {

	public static void main(String[] args) {
		// @formatter:off
		char[][] maze = new char[][] {  { ' ', '#', ' ' }, 
										{ ' ', '#', ' ' },
										{ ' ', '#', ' ' },
										{ ' ', ' ', ' ' },
										{ ' ', '#', '#' },
										{ ' ', ' ', 'F' },
										
									 };
		// @formatter:on

		boolean res = solve(maze, 0, 0);
		System.out.println(res);
		for (char[] ma : maze) {
			System.out.println(Arrays.toString(ma));
		}

	}

	private static boolean solve(char[][] maze, int x, int y) {
		if (x < 0 || x >= maze.length || y < 0 || y >= maze[0].length) {
			return false;
		}
		if (maze[x][y] == 'F') {
			return true;
		}
		if (maze[x][y] == '#' || maze[x][y] == '+') {
			return false;
		}
		maze[x][y] = '+';
		if (solve(maze, x, y + 1)) {
			return true;
		}

		if (solve(maze, x, y - 1)) {
			return true;
		}
		if (solve(maze, x + 1, y)) {
			return true;
		}
		if (solve(maze, x - 1, y)) {
			return true;
		}
		maze[x][y] = ' ';
		return false;
	}

}
