package hackerrank.algorithms.implementation;

import java.util.BitSet;
import java.util.Scanner;

public class ClimbingLeaderboard {
	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			int n = sc.nextInt();

			// TreeSet<Integer> pq = new TreeSet<>(Comparator.reverseOrder());

			int[] scores = new int[n];
			for (int i = 0; i < n; i++) {
				int score = sc.nextInt();
				scores[i] = score;

			}

			int m = sc.nextInt();
			int[] alice = new int[m];

			for (int i = 0; i < m; i++) {
				int score = sc.nextInt();
				alice[i] = score;
			}

			BitSet bs = new BitSet();
			for (int i = 0; i < scores.length; i++) {
				bs.set(scores[i]);
			}

			int[] res = new int[m];
			for (int i = 0; i < m; i++) {
				int score = alice[i];
				bs.set(score);
				int rank = findRank(bs, score);
				res[i] = rank;

			}

			for (int i = 0; i < m; i++) {
				System.out.println(res[i]);
			}

		}

	}

	private static int findRank(BitSet bs, int score) {
		int rank = 0;

		for (int i = bs.length() - 1; i >= score; i--) {
			if (bs.get(i)) {
				rank++;
			}
		}
		return rank;
	}

}
