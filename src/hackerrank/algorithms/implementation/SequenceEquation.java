package hackerrank.algorithms.implementation;

import java.util.Scanner;

public class SequenceEquation {
	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			int n = sc.nextInt();

			int[] seq = new int[n + 1];
			seq[0] = 0;

			for (int i = 1; i <= n; i++) {
				int val = sc.nextInt();
				seq[val] = i;
			}

			for (int i = 1; i <= n; i++) {
				System.out.println(seq[seq[i]]);
			}

		}
	}

}
