package hackerrank.algorithms.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class IceCreamParlor {

	private void solve(int c, int[] L) {
		int n = L.length;
		for (int i = 0; i < n - 1; i++) {
			for (int j = i + 1; j < n; j++) {
				if (L[i] + L[j] == c) {
					System.out.printf("%d %d\n", i + 1, j + 1);
					break;
				}
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = br.readLine();
		int T = Integer.parseInt(line);

		for (int i = 0; i < T; i++) {
			int C = Integer.parseInt(br.readLine());
			line = br.readLine();

			int n = Integer.parseInt(line);
			line = br.readLine();
			String[] tmp = line.split(" ");

			int[] L = new int[n];
			for (int j = 0; j < n; j++) {
				L[j] = Integer.parseInt(tmp[j]);
			}
			new IceCreamParlor().solve(C, L);
		}
	}

}
