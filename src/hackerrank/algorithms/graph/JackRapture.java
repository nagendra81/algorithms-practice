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

public class JackRapture {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] line = br.readLine().split(" ");
		int N = Integer.parseInt(line[0].trim());
		int M = Integer.parseInt(line[1].trim());

		Map<Integer, Set<Edge>> edgeMap = new HashMap<>();

		for (int m = 0; m < M; m++) {
			line = br.readLine().split(" ");
			int st = Integer.parseInt(line[0].trim());
			int en = Integer.parseInt(line[1].trim());
			long we = Long.parseLong(line[2].trim());

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
		int S = 1;
		solve(N, M, S, edgeMap);

	}

	private static void solve(int N, int M, int S, Map<Integer, Set<Edge>> edgeMap) {
		long[] dist = new long[N + 1];
		Arrays.fill(dist, Long.MAX_VALUE);

		boolean[] visited = new boolean[N + 1];
		Arrays.fill(visited, false);

		PriorityQueue<Node> q = new PriorityQueue<>();

		q.add(new Node(S, 0L));
		dist[S] = 0L;
		while (!q.isEmpty()) {
			Node curr = q.remove();
			visited[curr.id] = true;

			Set<Edge> edgeSet = edgeMap.get(curr.id);

			if (edgeSet != null) {
				for (Edge edge : edgeSet) {
					if (!visited[edge.end]) {
						long fare;
						if (edge.weight >= dist[curr.id]) {
							fare = edge.weight;
						} else {
							fare = dist[curr.id];
						}
						dist[edge.end] = Math.min(fare, dist[edge.end]);
						Node t = new Node(edge.end, dist[edge.end]);
						q.remove(t);
						q.add(t);
					}
				}
			}
		}

		// System.out.println(Arrays.toString(dist));
		if (Long.compare(dist[N], Long.MAX_VALUE) == 0) {
			System.out.println("NO PATH EXISTS");
		} else {
			System.out.println(dist[N]);
		}
	}

	static class Node implements Comparable<JackRapture.Node> {
		int id;
		long dist;

		Node(int id, long dist) {
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
			return Long.compare(this.dist, that.dist);
		}
	}

	static class Edge {
		int start;
		int end;
		long weight;

		public Edge(int start, int end, long weight) {
			this.start = start;
			this.end = end;
			this.weight = weight;

		}

	}

}
