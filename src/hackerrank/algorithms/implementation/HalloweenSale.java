package hackerrank.algorithms.implementation;

import java.util.Scanner;

public class HalloweenSale {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			int p = sc.nextInt();
			int d = sc.nextInt();
			int m = sc.nextInt();
			int s = sc.nextInt();

			if (s < p) {
				System.out.println(0);
				return;
			}

			int res = 0;
			while (p > m && s >= p) {
				s -= p;
				p -= d;
				res++;
			}
			while (s >= m && p <= m) {
				s -= m;
				res++;
			}
			System.out.println(res);
		}
	}

}
