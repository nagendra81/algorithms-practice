package hackerrank.algorithms.strings;

import java.util.Scanner;

public class StringConstruction {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();

		for (int i = 0; i < N; i++) {
			int res = solve(sc.next());
			System.out.println(res);
		}
	}

	private static int solve(String next) {
		boolean[] freq = new boolean[26];

		for (char c : next.toCharArray()) {
			freq[c - 'a'] = true;
		}

		int cost = 0;
		for (boolean b : freq) {
			if (b)
				cost++;
		}
		return cost;
	}

}
