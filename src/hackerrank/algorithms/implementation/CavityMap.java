package hackerrank.algorithms.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CavityMap {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		short[][] grid = new short[N][N];
		StringBuilder[] result = new StringBuilder[N];

		for (int i = 0; i < N; i++) {
			String line = br.readLine();
			result[i] = new StringBuilder(line);

			for (int j = 0; j < line.length(); j++) {
				grid[i][j] = (short) (line.charAt(j) - '0');
			}

		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (i == 0 || j == 0)
					continue;
				if (i == N - 1 || j == N - 1)
					continue;
				short curr = grid[i][j];
				if (curr > grid[i - 1][j] && curr > grid[i + 1][j] && curr > grid[i][j - 1] && curr > grid[i][j + 1]) {
					result[i].setCharAt(j, 'X');
				}
			}
		}

		for (StringBuilder sb : result)
			System.out.println(sb.toString());
	}
}
