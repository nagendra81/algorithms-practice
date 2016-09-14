package hackerrank.wcs6;

import java.util.Scanner;

public class CombinationLock {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int[] act = new int[5];

		for (int i = 0; i < 5; i++) {
			act[i] = sc.nextInt();
		}

		int[] targ = new int[5];

		for (int i = 0; i < 5; i++) {
			targ[i] = sc.nextInt();
		}

		solve(act, targ);
	}

	private static void solve(int[] act, int[] targ) {
		int res = 0;

		for (int i = 0; i < 5; i++) {
			if (act[i] == targ[i]) {
				continue;
			} else {
				res += min(Math.abs(act[i] - targ[i]), (10 - act[i] + targ[i]), act[i] + 10 - targ[i]);
			}
		}
		System.out.println(res);

	}

	private static int min(int a, int b, int c) {
		return Math.min(a, Math.min(b, c));
	}

}
