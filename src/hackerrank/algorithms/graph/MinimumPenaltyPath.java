package hackerrank.algorithms.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class MinimumPenaltyPath {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] line = br.readLine().split(" ");
		int N = Integer.parseInt(line[0].trim());
		int M = Integer.parseInt(line[1].trim());

		Map<Integer, List<Edge>> edgeMap = new HashMap<>();

		for (int m = 0; m < M; m++) {
			line = br.readLine().split(" ");
			int st = Integer.parseInt(line[0].trim());
			int en = Integer.parseInt(line[1].trim());
			int we = Integer.parseInt(line[2].trim());

			List<Edge> edgeList = edgeMap.get(st);
			if (edgeList == null) {
				edgeList = new ArrayList<>();
			}
			Edge ed = new Edge(st, en, we);
			edgeList.add(ed);

			edgeMap.put(st, edgeList);

			edgeList = edgeMap.get(en);
			if (edgeList == null) {
				edgeList = new ArrayList<>();

			}
			ed = new Edge(en, st, we);
			edgeList.add(ed);
			edgeMap.put(en, edgeList);

		}
		line = br.readLine().split(" ");
		int S = Integer.parseInt(line[0].trim());
		int E = Integer.parseInt(line[1].trim());
		solve(N, M, S, E, edgeMap);

	}

	private static void solve(int N, int M, int S, int E, Map<Integer, List<Edge>> edgeMap) {
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

			List<Edge> edgeSet = edgeMap.get(curr.id);

			if (edgeSet != null) {

				for (Edge edge : edgeSet) {
					if (!visited[edge.end]) {
						dist[edge.end] = Math.min(dist[edge.end], dist[edge.start] | edge.weight);

						Node t = new Node(edge.end, dist[edge.end]);
						q.remove(t);
						q.add(t);
					}
				}
			}
			if (curr.id == E) {
				System.out.println(dist[curr.id]);
			}
		}

		/*
		 * StringBuilder path = new StringBuilder(); for (int i = 1; i <
		 * dist.length; i++) { if (i == S) continue; if (dist[i] ==
		 * Integer.MAX_VALUE) { path.append("-1 ");
		 * 
		 * } else { path.append(dist[i] + " "); } } System.out.println(path);
		 */

	}

	static class Node implements Comparable<MinimumPenaltyPath.Node> {
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
