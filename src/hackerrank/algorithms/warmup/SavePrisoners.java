package hackerrank.algorithms.warmup;

import java.util.Scanner;

public class SavePrisoners {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int t = 0; t < 100; t++) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			int S = sc.nextInt();

			int res = (S - 1 + M - 1) % N;
			System.out.println(res + 1);

		}
	}

}
