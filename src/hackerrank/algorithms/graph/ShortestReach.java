package hackerrank.algorithms.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class ShortestReach {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine().trim());

		for (int t = 0; t < T; t++) {
			String[] line = br.readLine().split(" ");
			int N = Integer.parseInt(line[0].trim());
			int M = Integer.parseInt(line[1].trim());

			Map<Integer, Set<Integer>> edges = new HashMap<>();
			for (int m = 0; m < M; m++) {
				line = br.readLine().split(" ");

				int s = Integer.parseInt(line[0].trim());
				int e = Integer.parseInt(line[1].trim());

				Set<Integer> ed = edges.get(s);
				if (ed == null) {
					ed = new HashSet<>();
				}
				ed.add(e);
				edges.put(s, ed);

				ed = edges.get(e);
				if (ed == null) {
					ed = new HashSet<>();

				}

				ed.add(s);
				edges.put(e, ed);
				;

			}

			int S = Integer.parseInt(br.readLine().trim());

			solve(N, M, S, edges);

		}

	}

	private static void solve(int N, int M, int S, Map<Integer, Set<Integer>> edges) {
		boolean[] visited = new boolean[N + 1];
		Arrays.fill(visited, false);

		int[] dist = new int[N + 1];
		Arrays.fill(dist, Integer.MAX_VALUE);

		Queue<Integer> q = new LinkedList<>();

		q.add(S);
		dist[S] = 0;

		while (!q.isEmpty()) {
			int currNode = q.remove();
			visited[currNode] = true;
			Set<Integer> neighbours = edges.get(currNode);
			if (neighbours == null) {
				continue;
			}

			for (int neigh : neighbours) {
				if (!visited[neigh]) {
					q.add(neigh);
					dist[neigh] = Math.min(dist[neigh], dist[currNode] + 6);
				}
			}
		}
		// System.out.println(Arrays.toString(dist));

		StringBuilder path = new StringBuilder();
		for (int i = 1; i < dist.length; i++) {
			if (i == S)
				continue;
			if (dist[i] == Integer.MAX_VALUE) {
				path.append("-1 ");

			} else {
				path.append(dist[i] + " ");
			}
		}
		System.out.println(path);

	}
}
