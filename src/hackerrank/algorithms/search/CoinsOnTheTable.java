package hackerrank.algorithms.search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class CoinsOnTheTable {

	static int N;
	static int M;
	static int K;

	static char[][] board;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] tmp = br.readLine().split(" ");
		N = Integer.parseInt(tmp[0]);
		M = Integer.parseInt(tmp[1]);
		K = Integer.parseInt(tmp[2]);

		board = new char[N][M];
		for (int i = 0; i < N; i++) {
			board[i] = br.readLine().toCharArray();
		}

		solve(board);

	}

	private static void solve(char[][] board) {

		/*
		 * for (char[] b : board) System.out.println(Arrays.toString(b));
		 */

		int[][] cost = new int[N][M];
		for (int[] co : cost)
			Arrays.fill(co, Integer.MAX_VALUE);

		Queue<Node> pq = new PriorityQueue<Node>();

		Node start = new Node(0, 0, K, 0);
		pq.add(start);
		cost[0][0] = 0;

		while (!pq.isEmpty()) {
			// System.out.println(Arrays.toString(pq.toArray(new Node[1])));;
			Node t = pq.poll();
			cost[t.x][t.y] = Math.min(t.cost, cost[t.x][t.y]);
			t.cost = cost[t.x][t.y];
			// System.out.printf("(%d, %d): %d\n", t.x, t.y, cost[t.x][t.y]);

			if (board[t.x][t.y] == '*' && t.k >= 0) {
				System.out.println(cost[t.x][t.y]);
				return;
			} else if (t.k < 0) {
				continue;
			}

			// UP
			if (t.x - 1 >= 0) {
				int c = board[t.x][t.y] == 'U' ? 0 : 1;
				if (c + t.cost < cost[t.x - 1][t.y]) {

					pq.offer(new Node(t.x - 1, t.y, t.k - 1, c + t.cost));
				}
			}

			// LEFT
			if (t.y - 1 >= 0) {
				int c = board[t.x][t.y] == 'L' ? 0 : 1;
				if (c + t.cost < cost[t.x][t.y - 1]) {
					pq.offer(new Node(t.x, t.y - 1, t.k - 1, c + t.cost));
				}
			}

			// RIGHT
			if (t.y + 1 < M) {
				int c = board[t.x][t.y] == 'R' ? 0 : 1;
				if (c + t.cost < cost[t.x][t.y + 1]) {
					pq.offer(new Node(t.x, t.y + 1, t.k - 1, c + t.cost));
				}
			}

			// DOWN
			if (t.x + 1 < N) {
				int c = board[t.x][t.y] == 'D' ? 0 : 1;
				if (c + t.cost < cost[t.x + 1][t.y]) {
					pq.offer(new Node(t.x + 1, t.y, t.k - 1, c + t.cost));
				}

			}
		}
		System.out.println(-1);
	}

	static class Node implements Comparable<Node> {
		public int x;
		public int y;
		public int k;
		public int cost;

		@Override
		public String toString() {
			return String.format("x:%d, y:%d, k:%d, cost: %d", x, y, k, cost);
		}

		public Node(int x, int y, int k, int cost) {
			this.x = x;
			this.y = y;
			this.k = k;
			this.cost = cost;
		}

		@Override
		public int compareTo(Node o) {
			Node n = (Node) o;
			return this.cost - n.cost;
		}

	}

}
