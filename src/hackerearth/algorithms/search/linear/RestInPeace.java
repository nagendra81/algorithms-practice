package hackerearth.algorithms.search.linear;

import java.util.Scanner;

public class RestInPeace {
	private static final String BROKEN = "The streak is broken!";
	private static final String LIVES_ON = "The streak lives still in our heart!";

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int t = 0; t < T; t++) {
			int num = sc.nextInt();
			solve(num);
		}
	}

	private static void solve(int num) {
		if ((num % 21) == 0) {
			System.out.println(BROKEN);
			return;
		}
		String s = String.valueOf(num);
		if (s.indexOf("21") >= 0) {
			System.out.println(BROKEN);
		} else {
			System.out.println(LIVES_ON);
		}
	}

}
