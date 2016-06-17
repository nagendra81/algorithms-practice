package hackerrank.algorithms.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

public class ShortestReach2 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine().trim());

		for (int t = 0; t < T; t++) {
			String[] line = br.readLine().split(" ");
			int N = Integer.parseInt(line[0].trim());
			int M = Integer.parseInt(line[1].trim());

			Map<Integer, Set<Edge>> edgeMap = new HashMap<>();

			for (int m = 0; m < M; m++) {
				line = br.readLine().split(" ");
				int st = Integer.parseInt(line[0].trim());
				int en = Integer.parseInt(line[1].trim());
				int we = Integer.parseInt(line[2].trim());

				Set<Edge> edgeSet = edgeMap.get(st);
				if (edgeSet == null) {
					edgeSet = new HashSet<>();
				}
				Edge ed = new Edge(st, en, we);
				edgeSet.add(ed);

				edgeMap.put(st, edgeSet);

				edgeSet = edgeMap.get(en);
				if (edgeSet == null) {
					edgeSet = new HashSet<>();

				}
				ed = new Edge(en, st, we);
				edgeSet.add(ed);
				edgeMap.put(en, edgeSet);

			}

			int S = Integer.parseInt(br.readLine().trim());
			solve(N, M, S, edgeMap);

		}

	}

	private static void solve(int N, int M, int S, Map<Integer, Set<Edge>> edgeMap) {
		int[] dist = new int[N + 1];
		Arrays.fill(dist, Integer.MAX_VALUE);

		boolean[] visited = new boolean[N + 1];
		Arrays.fill(visited, false);

		PriorityQueue<Node> q = new PriorityQueue<>();

		q.add(new Node(S, 0));
		dist[S] = 0;
		while (!q.isEmpty()) {
			Node curr = q.remove();
			visited[curr.id] = true;

			Set<Edge> edgeSet = edgeMap.get(curr.id);

			if (edgeSet != null) {

				for (Edge edge : edgeSet) {
					if (!visited[edge.end]) {
						dist[edge.end] = Math.min(dist[edge.end], dist[edge.start] + edge.weight);

						Node t = new Node(edge.end, dist[edge.end]);
						q.remove(t);
						q.add(t);
					}
				}
			}
		}

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

	static class Node implements Comparable<ShortestReach2.Node> {
		int id;
		int dist;

		Node(int id, int dist) {
			this.id = id;
			this.dist = dist;
		}

		@Override
		public boolean equals(Object obj) {
			Node that = (Node) obj;
			return this.id == that.id;
		}

		@Override
		public int hashCode() {
			return this.id;
		}

		@Override
		public int compareTo(Node that) {
			return Integer.compare(this.dist, that.dist);
		}
	}

	static class Edge {
		int start;
		int end;
		int weight;

		public Edge(int start, int end, int weight) {
			this.start = start;
			this.end = end;
			this.weight = weight;

		}

		@Override
		public boolean equals(Object obj) {
			Edge that = (Edge) obj;
			return this.start == that.start && this.end == that.end && this.weight == that.weight;
		}

		@Override
		public int hashCode() {
			int[] a = { this.start, this.end, this.weight };
			return Arrays.hashCode(a);
		}
	}

}
