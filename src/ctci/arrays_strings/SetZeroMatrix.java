package ctci.arrays_strings;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class SetZeroMatrix {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int[][] matrix = new int[N][N];

		for (int i = 0; i < N; i++) {
			String[] tmp = br.readLine().split(" ");
			for (int j = 0; j < N; j++) {
				matrix[i][j] = Integer.parseInt(tmp[j]);
			}

		}

		for (int[] m : matrix)
			System.out.println(Arrays.toString(m));
		
		
		System.out.println("=================");

		setZeros(matrix);

	}

	static void setZeros(int[][] matrix) {
		int r = matrix.length;
		int c = matrix[0].length;

		boolean rows[] = new boolean[r];
		boolean cols[] = new boolean[c];

		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				if (matrix[i][j] == 0) {
					rows[i] = true;
					cols[j] = true;

				}
			}
		}

		for (int i = 0; i < rows.length; i++)
			if (rows[i])
				Arrays.fill(matrix[i], 0);

		for (int j = 0; j < cols.length; j++) {
			if (cols[j])
				for (int k = 0; k < r; k++) {
					matrix[k][j] = 0;
				}
		}

		for (int[] m : matrix)
			System.out.println(Arrays.toString(m));

	}

}
