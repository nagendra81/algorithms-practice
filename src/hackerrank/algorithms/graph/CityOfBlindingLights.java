package hackerrank.algorithms.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.Set;

public class CityOfBlindingLights {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int M = sc.nextInt();

		DirGraph graph = new DirGraph();
		for (int i = 0; i < M; i++) {
			graph.addEdge(sc.nextInt(), sc.nextInt(), sc.nextInt());
		}
		System.out.println(graph);

		List<int[]> queries = new ArrayList<>();

		int Q = sc.nextInt();

		for (int i = 0; i < Q; i++) {
			queries.add(new int[] { sc.nextInt(), sc.nextInt() });
		}

		int[][] paths = new int[N][N];

		for (int[] pa : paths) {
			Arrays.fill(pa, Integer.MAX_VALUE);
		}

		for (int i = 0; i < paths.length; i++) {
			for (int j = 0; j < paths.length; j++) {
				if (i == j) {
					paths[i][j] = 0;
				}
			}
		}

		for (int node : graph.getNodes()) {
			compute(node, graph, paths[node - 1]);
		}

		for (int[] q : queries) {
			System.out.println(paths[q[0] - 1][q[1] - 1]);
		}

		for (int[] pa : paths) {
			System.out.println(Arrays.toString(pa));
		}

	}

	private static void compute(int S, DirGraph graph, int[] dist) {

		boolean[] visited = new boolean[graph.getNodes().size() + 1];

		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.add(new Node(S, dist[S - 1]));

		while (!pq.isEmpty()) {
			System.out.println("pq:" + pq);
			if (visited[S]) {
				return;
			}

			for (Edge e : graph.adj.get(S)) {
				pq.remove(new Node(e.v, dist[e.v - 1]));
				dist[e.v - 1] = Math.min(dist[e.v - 1], dist[S - 1] == Integer.MAX_VALUE ? e.wt : dist[S - 1] + e.wt);

				pq.add(new Node(e.v, dist[e.v - 1]));
			}
			visited[S] = true;
		}
	}

	static class DirGraph {
		Map<Integer, List<Edge>> adj = new HashMap<>();

		public void addEdge(int u, int v, int wt) {
			List<Edge> eu = adj.get(u);
			if (eu == null) {
				eu = new ArrayList<>();
			}
			eu.add(new Edge(u, v, wt));
			adj.put(u, eu);
		}

		public Set<Integer> getNodes() {
			return adj.keySet();
		}

		@Override
		public String toString() {
			return adj.toString();
		}

	}

	static class Node implements Comparable<Node> {
		int u;
		int dis;

		Node(int u, int dis) {
			this.u = u;
			this.dis = dis;
		}

		@Override
		public int compareTo(Node that) {
			if (this.u == that.u && this.dis == that.dis) {
				return 0;
			}
			return Integer.compare(this.dis, that.dis);
		}

		@Override
		public boolean equals(Object obj) {
			Node that = (Node) obj;
			return this.u == that.u;
		}

		@Override
		public String toString() {
			return String.format("u=%d, dis=%d", u, dis);
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
