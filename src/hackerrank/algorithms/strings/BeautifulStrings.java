package hackerrank.algorithms.strings;

import java.util.Scanner;

public class BeautifulStrings {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();

		String s = sc.next();
		solve(s);

	}

	private static void solve(String s) {
		String p = "010";

		int ma = 0;
		int la = 0;
		int cnt = 0;
		do {
			ma = s.indexOf(p, la);
			// System.out.println(ma);
			if (ma != -1) {
				cnt++;
				la = (ma + 3);
			}

		} while (ma != -1);

		System.out.println(cnt);

	}

}
