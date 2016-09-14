package hackerrank.algorithms.strings;

import java.util.Scanner;

public class SuperReducedString {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String S = sc.next();

		solve(new StringBuilder(S));
	}

	private static void solve(StringBuilder sb) {
		boolean reduced = true;

		while (reduced) {
			reduced = false;
			for (int i = 1; i < sb.length(); i++) {
				if (sb.charAt(i) == sb.charAt(i - 1)) {
					sb.deleteCharAt(i);
					sb.deleteCharAt(i - 1);
					reduced = true;
				}
			}
		}
		if (sb.length() == 0) {
			System.out.println("Empty String");
		} else {
			System.out.println(sb);
		}

	}

}
