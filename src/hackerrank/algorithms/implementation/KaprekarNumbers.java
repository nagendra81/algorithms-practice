package hackerrank.algorithms.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashSet;
import java.util.Set;

public class KaprekarNumbers {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int P = Integer.parseInt(br.readLine().trim());
		int Q = Integer.parseInt(br.readLine().trim());

		Set<Integer> results = new LinkedHashSet<>();

		for (int p = P; p <= Q; p++) {
			long sq = (long) p * (long) p;

			int d = String.valueOf(p).length();

			String str = String.valueOf(sq);

			String rightString = str.substring(str.length() - d);
			long right = Long.parseLong(rightString);
			String leftString = str.substring(0, str.indexOf(rightString));
			long left = 0;
			if (leftString == null || leftString.trim().length() == 0) {
				left = 0;
			} else {
				left = Long.parseLong(leftString);
			}
			if (left + right == p) {
				results.add(p);
			}

		}
		if (results.isEmpty()) {
			System.out.println("INVALID RANGE");
		} else {
			StringBuilder sb = new StringBuilder();
			for (int re : results) {
				sb.append(re + " ");
			}
			System.out.println(sb.toString().trim());
		}

	}

}
