package hackerrank.algorithms.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class CityOfBlindingLights {
	static final int INFINITY = 99999;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int M = sc.nextInt();

		DirGraph graph = new DirGraph();
		for (int i = 0; i < M; i++) {
			graph.addEdge(sc.nextInt(), sc.nextInt(), sc.nextInt());
		}
		// System.out.println(graph);

		List<int[]> queries = new ArrayList<>();

		int Q = sc.nextInt();

		for (int i = 0; i < Q; i++) {
			queries.add(new int[] { sc.nextInt(), sc.nextInt() });
		}

		int[][] dist = new int[N + 1][N + 1];

		for (int[] pa : dist) {
			Arrays.fill(pa, INFINITY);
		}

		for (int i = 1; i <= N; i++) {
			dist[i][i] = 0;

		}

		for (Edge ed : graph.getEdges()) {
			dist[ed.u][ed.v] = ed.wt;
		}

		for (int k = 1; k <= N; k++) {
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					if (dist[i][j] > dist[i][k] + dist[k][j]) {
						dist[i][j] = dist[i][k] + dist[k][j];
					}
				}
			}
		}

		for (int[] q : queries) {
			int r = dist[q[0]][q[1]];
			if (r == INFINITY) {
				r = -1;
			}
			System.out.println(r);
		}

	}

	static class DirGraph {
		List<Edge> edgeList = new ArrayList<>();

		public void addEdge(int u, int v, int wt) {
			edgeList.add(new Edge(u, v, wt));
		}

		public List<Edge> getEdges() {
			return edgeList;
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
