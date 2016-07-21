package hackerrank.algorithms.search;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;

public class CutTree {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		Map<Integer, Integer> nodeMap = new HashMap<>();
		int N = sc.nextInt();

		for (int i = 0; i < N; i++) {
			nodeMap.put(i + 1, sc.nextInt());
		}

		Graph graph = new Graph(nodeMap);
		for (int i = 0; i < N - 1; i++) {
			int u = sc.nextInt();
			int v = sc.nextInt();
			graph.addEdge(u, v);
		}
		graph.updateSubTreeSum();

		solve(graph);

	}

	private static void solve(Graph graph) {
		Set<Integer> visited = new HashSet<>();
		int root = graph.ROOT;
		int root_sum = graph.subTreeSum.get(root);

		int tree_diff = Integer.MAX_VALUE;

		Queue<Integer> q = new LinkedList<>();
		q.add(root);

		while (!q.isEmpty()) {
			int node = q.remove();
			visited.add(node);

			for (int ne : graph.edgeMap.get(node)) {
				if (!visited.contains(ne)) {
					int sum1 = graph.subTreeSum.get(ne);
					int sum2 = root_sum - sum1;

					int diff = Math.abs(sum1 - sum2);
					tree_diff = Math.min(diff, tree_diff);
					q.add(ne);
				}
			}
		}

		System.out.println(tree_diff);

	}

	static class Graph {

		private final int ROOT;
		private Map<Integer, Integer> nodeMap;
		private Map<Integer, Set<Integer>> edgeMap = new HashMap<>();

		private Map<Integer, Integer> subTreeSum = new HashMap<>();

		private Set<Integer> visited = new HashSet<>();

		public Graph(Map<Integer, Integer> nodeMap) {
			this.ROOT = 1;
			this.nodeMap = nodeMap;
		}

		public void addSubTreeSum(int u, int cnt) {
			subTreeSum.put(u, cnt);
		}

		public void addEdge(int u, int v) {
			Set<Integer> edgeV = edgeMap.get(u);
			if (edgeV == null) {
				edgeV = new HashSet<>();
			}
			edgeV.add(v);
			edgeMap.put(u, edgeV);

			Set<Integer> edgeU = edgeMap.get(v);
			if (edgeU == null) {
				edgeU = new HashSet<>();
			}
			edgeU.add(u);
			edgeMap.put(v, edgeU);
		}

		public void removeEdge(int u, int v) {
			Set<Integer> edgeV = edgeMap.get(u);
			edgeV.remove(v);
			edgeMap.put(u, edgeV);

			Set<Integer> edgeU = edgeMap.get(v);
			edgeU.remove(u);
			edgeMap.put(v, edgeU);
		}

		public void updateSubTreeSum() {
			explore(ROOT);
		}

		private int explore(int node) {
			Set<Integer> adj = edgeMap.get(node);

			int subSum = nodeMap.get(node);
			visited.add(node);
			for (Integer neigh : adj) {
				if (!visited.contains(neigh)) {
					subSum += explore(neigh);
				}
			}

			addSubTreeSum(node, subSum);
			return subSum;
		}
	}

}
