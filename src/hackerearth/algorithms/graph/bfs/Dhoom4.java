package hackerearth.algorithms.graph.bfs;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Dhoom4 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int SK = sc.nextInt();
		int LK = sc.nextInt();

		int N = sc.nextInt();

		long[] arr = new long[N];
		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextLong();

		}

		// Arrays.sort(arr);
		solve(arr, SK, LK);

	}

	private static void solve(long[] arr, int sK, int lK) {

		int C = 100000;
		boolean[] visited = new boolean[C + 1];
		Arrays.fill(visited, false);
		visited[0] = true;
		Queue<Node> pq = new LinkedList<>();

		Node st = new Node(sK, 0);
		pq.add(st);
		// visited[sK] = true;

		int v = 0;

		while (!pq.isEmpty()) {
			Node cu = pq.remove();

			visited[cu.val] = true;
			for (long a : arr) {
				v = (int) ((a * cu.val) % C);
				if (!visited[v]) {
					if (v == lK) {
						System.out.println(cu.dist + 1);
						return;
					}

					Node ne = new Node(v, cu.dist + 1);
					pq.add(ne);
					visited[v] = true;
					;
				}

			}

		}

		System.out.println("-1");
	}

	static class Node implements Comparable<Node> {
		int val;
		int dist;

		Node(int val, int dist) {
			this.val = val;
			this.dist = dist;
		}

		@Override
		public int compareTo(Node that) {

			return Integer.compare(this.dist, that.dist);
		}

		@Override
		public boolean equals(Object obj) {
			Node that = (Node) obj;
			return this.dist == that.dist && this.val == that.val;
		}

		@Override
		public int hashCode() {
			return val * 31 + dist;
		}
	}

}
