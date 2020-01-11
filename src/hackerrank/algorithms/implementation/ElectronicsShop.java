package hackerrank.algorithms.implementation;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class ElectronicsShop {

	/*
	 * Complete the getMoneySpent function below.
	 */
	static int getMoneySpent(int[] kb, int[] dr, int b) {

		Arrays.sort(kb);
		Arrays.sort(dr);

		int res = -1;

		for (int i = kb.length - 1; i >= 0; i--) {
			for (int j = dr.length - 1; j >= 0; j--) {
				if (kb[i] + dr[j] <= b) {
					res = Math.max(res, kb[i] + dr[j]);
				}
			}
		}

		return res;
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {

		int b = scanner.nextInt();

		int n = scanner.nextInt();

		int m = scanner.nextInt();

		int[] keyboards = new int[n];

		for (int i = 0; i < n; i++) {
			int keyboardsItem = scanner.nextInt();
			keyboards[i] = keyboardsItem;
		}

		int[] drives = new int[m];

		for (int drivesItr = 0; drivesItr < m; drivesItr++) {
			int drivesItem = scanner.nextInt();
			drives[drivesItr] = drivesItem;
		}

		/*
		 * The maximum amount of money she can spend on a keyboard and USB
		 * drive, or -1 if she can't purchase both items
		 */

		int moneySpent = getMoneySpent(keyboards, drives, b);

		System.out.println(moneySpent);
		scanner.close();
	}
}
