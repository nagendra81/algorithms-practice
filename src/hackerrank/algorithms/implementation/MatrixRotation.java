package hackerrank.algorithms.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class MatrixRotation {

	private static int[] dirx = { 1, 0, -1, 0 };
	private static int[] diry = { 0, 1, 0, -1 };

	private static int M;
	private static int N;
	private static int R;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] line = br.readLine().split(" ");

		M = Integer.parseInt(line[0].trim());
		N = Integer.parseInt(line[1].trim());
		R = Integer.parseInt(line[2].trim());

		int[][] grid = new int[M][N];
		for (int m = 0; m < M; m++) {
			line = br.readLine().split(" ");
			for (int j = 0; j < line.length; j++) {
				grid[m][j] = Integer.parseInt(line[j]);
			}
		}

		// System.out.printf("M=%d, N=%d, R=%d\n", M, N, R);
		solve(grid, M, N, R);

	}

	private static void solve(int[][] grid, int M, int N, int R) {

		int[][] res = new int[M][N];
		for (int[] r : res) {
			Arrays.fill(r, 0);
		}

		int num_layers = Math.min(M, N) / 2;

		int rows = M - 1;
		int cols = N - 1;
		for (int lay = 0; lay < num_layers; lay++) {
			int length = getLength(rows, cols, lay);
			// System.out.println("Length: " + length);
			int rot = R % length;

			int sx = lay;
			int sy = lay;

			int[] t = getPosition(sx, sy, lay, rows, cols, rot);
			int dx = t[0];
			int dy = t[1];
			// System.out.printf("initial layer: %d, sx: %d, sy: %d, dx: %d, dy:
			// %d\n", lay, sx, sy, dx, dy);

			for (int i = 0; i < length; i++) {
				res[dx][dy] = grid[sx][sy];

				t = getPosition(sx, sy, lay, rows, cols, 1);
				sx = t[0];
				sy = t[1];

				t = getPosition(dx, dy, lay, rows, cols, 1);
				dx = t[0];
				dy = t[1];
				// System.out.printf("layer: %d, (sx,sy): (%d, %d), (dx,dy):
				// (%d, %d)\n", lay, sx, sy, dx, dy);
			}
		}

		StringBuilder result = new StringBuilder();
		for (int[] re : res) {
			StringBuilder row = new StringBuilder();
			for (int r : re) {
				row.append(r);
				row.append(" ");
			}
			row.trimToSize();
			row.append("\n");

			result.append(row);

		}

		result.trimToSize();
		System.out.println(result);

	}

	private static int getLength(int rows, int cols, int lay) {
		// System.out.printf("rows: %d, cols: %d, layer: %d\n", rows, cols,
		// lay);
		int half = rows - (2 * lay) + cols - (2 * lay);
		return half * 2;

	}

	private static int[] getPosition(int sx, int sy, int lay, int rows, int cols, int rot) {
		int dx = sx;
		int dy = sy;
		for (int i = 0; i < rot; i++) {
			if (dy == lay && dx < rows - lay) {
				dx++;
			} else if (dx == rows - lay && dy < cols - lay) {
				dy++;
			} else if (dy == cols - lay && dx > lay) {
				dx--;
			} else if (dx == lay && dy >= lay) {
				dy--;
			}
		}
		return new int[] { dx, dy };

	}
}