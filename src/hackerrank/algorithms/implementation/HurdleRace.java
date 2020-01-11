package hackerrank.algorithms.implementation;

import java.util.Scanner;

public class HurdleRace {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {

			int n = sc.nextInt();
			int k = sc.nextInt();

			int res = 0;
			for (int i = 0; i < n; i++) {
				int h = sc.nextInt();
				if (h > k) {
					res = Math.max(res, h - k);
				}
			}
			System.out.println(res);
		}

	}
}
