package hackerrank.algorithms.graph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;

public class EvenTree {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int M = sc.nextInt();

		Graph graph = new Graph(N, M);

		for (int i = 0; i < M; i++) {
			int u = sc.nextInt();
			int v = sc.nextInt();

			graph.addEdge(u, v);
		}
		solve(graph);
	}

	private static void solve(Graph graph) {
		graph.countSubTree();
		// System.out.println(graph.nodes);
		// System.out.println(graph.subTreeCnt);

		Set<Integer> visited = new HashSet<>();

		int root = graph.nodes.keySet().iterator().next();
		Queue<Integer> q = new LinkedList<>();
		q.add(root);
		int res = 0;
		while (!q.isEmpty()) {
			int node = q.remove();

			if (visited.contains(node)) {
				continue;
			}
			visited.add(node);
			Set<Integer> adj = graph.nodes.get(node);

			// System.out.println("BFS: " + node);

			for (int ne : adj) {
				if (visited.contains(ne)) {
					continue;
				}
				int subCnt = graph.subTreeCnt.get(ne);
				// System.out.println("Ne : " + ne + ", subtree::" + subCnt);
				if (isEven(subCnt)) {
					res++;
				}
				q.add(ne);
			}
		}
		System.out.println(res);
		// System.out.println(graph.subTreeCnt);
	}

	private static boolean isEven(Integer num) {
		if (num == null) {
			return false;
		}

		if ((num.intValue() & 1) == 0) {
			return true;
		}
		return false;

	}

	static class Graph {
		private int V;
		private int E;
		private Map<Integer, Set<Integer>> nodes = new HashMap<>();

		private Map<Integer, Integer> subTreeCnt = new HashMap<>();

		private Set<Integer> visited = new HashSet<>();

		public Graph(int V, int E) {
			this.V = V;
			this.E = E;
		}

		public void addSubTreeCount(int u, int cnt) {
			subTreeCnt.put(u, cnt);
		}

		public void addEdge(int u, int v) {
			Set<Integer> edgeV = nodes.get(u);
			if (edgeV == null) {
				edgeV = new HashSet<>();
			}
			edgeV.add(v);
			nodes.put(u, edgeV);

			Set<Integer> edgeU = nodes.get(v);
			if (edgeU == null) {
				edgeU = new HashSet<>();
			}
			edgeU.add(u);
			nodes.put(v, edgeU);

		}

		public void removeEdge(int u, int v) {
			Set<Integer> edgeV = nodes.get(u);
			edgeV.remove(v);
			nodes.put(u, edgeV);

			Set<Integer> edgeU = nodes.get(v);
			edgeU.remove(u);
			nodes.put(v, edgeU);
		}

		public void countSubTree() {
			int root = nodes.keySet().iterator().next();
			explore(root);
		}

		private int explore(int node) {
			Set<Integer> adj = nodes.get(node);

			int subCount = 1;
			visited.add(node);
			for (Integer neigh : adj) {
				if (!visited.contains(neigh)) {
					subCount += explore(neigh);
				}
			}
			addSubTreeCount(node, subCount);
			return subCount;
		}
	}
}
