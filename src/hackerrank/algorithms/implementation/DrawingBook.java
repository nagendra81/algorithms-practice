package hackerrank.algorithms.implementation;

import java.util.Scanner;

public class DrawingBook {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			int n = sc.nextInt();
			int p = sc.nextInt();

			n /= 2;
			p /= 2;

			System.out.println(Math.min(p - 0, n - p));

		}
	}
}
