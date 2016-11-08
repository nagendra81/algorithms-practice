package hackerearth.algorithms.graph.bfs;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;

public class MonkIslands {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int t = 0; t < T; t++) {
			int N = sc.nextInt();
			int M = sc.nextInt();

			Map<Integer, Set<Integer>> adj = new HashMap<>();
			int[] u = new int[M];
			int[] v = new int[M];

			for (int i = 0; i < M; i++) {
				u[i] = sc.nextInt();
				v[i] = sc.nextInt();

			}
			for (int i = 0; i < M; i++) {

				Set<Integer> edges = adj.get(u[i]);
				if (edges == null)
					edges = new HashSet<>();
				edges.add(v[i]);
				adj.put(u[i], edges);

				edges = adj.get(v[i]);
				if (edges == null) {
					edges = new HashSet<>();
				}
				edges.add(u[i]);
				adj.put(v[i], edges);

			}
			solve(adj, 1, N);
		}
	}

	private static void solve(Map<Integer, Set<Integer>> adj, int S, int N) {
		Queue<Integer> q = new LinkedList<>();

		int[] dist = new int[N + 1];
		Arrays.fill(dist, Integer.MAX_VALUE);
		boolean[] visited = new boolean[N + 1];

		q.add(S);
		visited[S] = true;
		dist[S] = 0;

		while (!q.isEmpty() && q.peek() != N) {
			int cu = q.remove();
			visited[cu] = true;

			Set<Integer> neighbors = adj.get(cu);
			if (neighbors != null) {
				for (int neigh : neighbors) {
					if (!visited[neigh]) {
						dist[neigh] = Math.min(dist[neigh], 1 + dist[cu]);
						q.add(neigh);
					}
				}
			}
		}
		System.out.println(dist[N]);

	}
}
