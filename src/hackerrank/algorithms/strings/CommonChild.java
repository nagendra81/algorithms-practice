package hackerrank.algorithms.strings;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CommonChild {

	public int solve(String s, String t) {
		int sn = s.length();
		int tn = t.length();
		int[][] E = new int[sn + 1][tn + 1];

		for (int i = 0; i <= sn; i++) {
			E[i][0] = 0;
		}
		for (int j = 0; j <= tn; j++) {
			E[0][j] = 0;
		}

		for (int i = 1; i <= sn; i++) {
			for (int j = 1; j <= tn; j++) {
				if (s.charAt(i - 1) == t.charAt(j - 1)) {
					E[i][j] = 1 + E[i - 1][j - 1];
				} else {
					E[i][j] = Math.max(E[i - 1][j], E[i][j - 1]);
				}
			}
		}
		/*
		 * for (int[] e : E) System.out.println(Arrays.toString(e));
		 */
		return E[sn][tn];
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String s = br.readLine();
		String t = br.readLine();

		System.out.println(new CommonChild().solve(s, t));

	}

}
