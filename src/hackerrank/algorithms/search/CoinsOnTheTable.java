package hackerrank.algorithms.search;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class CoinsOnTheTable {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int K = sc.nextInt();

		char[][] bord = new char[N][M];

		for (int i = 0; i < N; i++) {
			String s = sc.next();
			for (int j = 0; j < s.length(); j++) {
				bord[i][j] = s.charAt(j);
			}
		}
		solve(bord, N, M, K);
	}

	private static void solve(char[][] bord, int n, int m, int k) {

		int[][] cost = new int[n][m];
		for (int[] co : cost) {

			Arrays.fill(co, Integer.MAX_VALUE);
		}

		PriorityQueue<Cell> pq = new PriorityQueue<>();
		Cell start = new Cell(0, 0);
		pq.add(start);

		while (!pq.isEmpty()) {
			Cell t = pq.remove();

			switch (bord[t.r][t.c]) {
			case 'L':

				break;
			case 'R':
				break;
			case 'U':

				break;
			case 'D':
				break;
			case '*':
				break;
			}

		}
		System.out.println(-1);

	}

	static class Cell implements Comparable<Cell> {
		int r;
		int c;
		int cost;

		Cell(int r, int c) {
			this.r = r;
			this.c = c;
			this.cost = 0;
		}

		public int compareTo(Cell that) {
			return Integer.compare(this.cost, that.cost);
		}
	}

}