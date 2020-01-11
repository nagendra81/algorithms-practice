package hackerrank.algorithms.implementation;

import java.util.Scanner;

public class BeautifulDaysMovies {
	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			int i = sc.nextInt();
			int j = sc.nextInt();
			int k = sc.nextInt();

			int res = 0;
			for (int b = i; b <= j; b++) {
				int rb = rev(b);
				if (abs(rb, b) % k == 0) {
					res++;
				}
			}
			System.out.println(res);
		}

	}

	private static int rev(int b) {
		return Integer.parseInt(new StringBuilder(String.valueOf(b)).reverse().toString());
	}

	private static int abs(int x, int z) {
		if (x < z)
			return z - x;
		return x - z;
	}

}
