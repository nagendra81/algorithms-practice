package hackerrank.algorithms.graph;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.Set;

public class Prim {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int M = sc.nextInt();

		Graph graph = new Graph();
		for (int i = 0; i < M; i++) {
			graph.addEdge(sc.nextInt(), sc.nextInt(), sc.nextInt());
		}
		int S = sc.nextInt();
		// System.out.println(graph);

		Set<Edge> mst = new HashSet<>();

		PriorityQueue<Edge> pq = new PriorityQueue<>();
		boolean[] visited = new boolean[N + 1];

		explore(S, graph, pq, visited);

		while (!pq.isEmpty()) {

			Edge e = pq.remove();
			if (visited[e.u] && visited[e.v]) {
				continue;
			}
			mst.add(e);
			if (!visited[e.u]) {
				explore(e.u, graph, pq, visited);
			}
			if (!visited[e.v]) {
				explore(e.v, graph, pq, visited);
			}
		}
		long res = 0;

		for (Edge e : mst) {
			res += e.wt;
		}
		System.out.println(res);
	}

	private static void explore(int s, Graph graph, PriorityQueue<Edge> pq, boolean[] visited) {
		if (visited[s]) {
			return;
		}

		for (Edge e : graph.adj.get(s)) {
			pq.add(e);
		}
		visited[s] = true;
	}

	static class Graph {
		Map<Integer, List<Edge>> adj = new LinkedHashMap<>();

		public void addEdge(int u, int v, int wt) {
			List<Edge> eu = adj.get(u);
			if (eu == null) {
				eu = new ArrayList<>();
			}
			eu.add(new Edge(u, v, wt));
			adj.put(u, eu);

			List<Edge> ev = adj.get(v);
			if (ev == null) {
				ev = new ArrayList<>();
			}
			ev.add(new Edge(v, u, wt));
			adj.put(v, ev);
		}

		@Override
		public String toString() {
			return adj.toString();
		}

	}

	static class Edge implements Comparable<Edge> {
		int u;
		int v;
		int wt;

		Edge(int u, int v, int wt) {
			this.u = u;
			this.v = v;
			this.wt = wt;
		}

		@Override
		public int compareTo(Edge e) {
			if (this.u == e.u && this.v == e.v && this.wt == e.wt) {
				return 0;
			}
			return Integer.compare(this.wt, e.wt);
		}

		@Override
		public boolean equals(Object obj) {
			Edge that = (Edge) obj;

			return this.u == that.u && this.v == that.v && this.wt == that.wt;
		}

		@Override
		public String toString() {
			return String.format("[%d->%d, w=%d]", u, v, wt);

		}

	}

}
