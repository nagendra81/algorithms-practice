package weekofcode21;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.TreeSet;

public class DemandingMoney {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] line = br.readLine().split(" ");
		int N = Integer.parseInt(line[0]);
		int M = Integer.parseInt(line[1]);

		List<Node> nodeSet = new ArrayList<>();

		line = br.readLine().split(" ");
		for (int i = 0; i < N; i++) {
			nodeSet.add(new Node(i + 1, Integer.parseInt(line[i])));
		}

		for (int m = 0; m < M; m++) {
			line = br.readLine().split(" ");
			Node s = nodeSet.get(Integer.parseInt(line[0]) - 1);
			Node t = nodeSet.get(Integer.parseInt(line[1]) - 1);

			s.addEdge(t);
			t.addEdge(s);

		}

		long maxProfit = Long.MIN_VALUE;
		Map<Long, Set<Set<Integer>>> maxPaths = new HashMap<>();
		for (Node node : nodeSet) {
			Set<Integer> paths = new HashSet<>();
			long profit = traverse(node, N, paths);

			if (profit > maxProfit) {
				maxProfit = profit;
			}

			Set<Set<Integer>> pathSet = maxPaths.get(profit);
			if (pathSet == null) {
				pathSet = new HashSet<>();
			}
			pathSet.add(paths);
			maxPaths.put(profit, pathSet);
		}

		int b;
		Set<Set<Integer>> s = maxPaths.get(maxProfit);
		if (s == null) {
			b = 0;
		} else {
			b = s.size();
		}

		System.out.println(maxProfit + " " + b);

	}

	private static long traverse(Node node, int N, Set<Integer> paths) {

		boolean[] visited = new boolean[N + 1];
		Arrays.fill(visited, false);
		long profit = 0;

		PriorityQueue<DemandingMoney.LevelNode> q = new PriorityQueue<>();
		q.add(new LevelNode(node, 0));

		while (!q.isEmpty()) {

			LevelNode ln = q.remove();

			if (visited[ln.node.id]) {
				continue;
			}
			if ((ln.level & 1) == 0) { // even
				paths.add(ln.node.id);
				profit += ln.node.cost;
			}

			visited[ln.node.id] = true;

			for (Node neigh : ln.node.edges) {
				LevelNode levelNeigh = new LevelNode(neigh, ln.level + 1);
				if (!visited[neigh.id]) {
					if (q.contains(levelNeigh)) {
						q.remove(levelNeigh);
					}
					q.add(levelNeigh);
				}
			}
		}

		return profit;

	}

	static class LevelNode implements Comparable<LevelNode> {
		Node node;
		int level;

		LevelNode(Node node, int level) {
			this.node = node;
			this.level = level;
		}

		@Override
		public int compareTo(LevelNode that) {
			int id1 = this.node.id;
			int id2 = that.node.id;
			return Integer.compare(id1, id2);

		}

		@Override
		public boolean equals(Object obj) {
			LevelNode that = (LevelNode) obj;
			return this.node.id == that.node.id;
		}

		@Override
		public int hashCode() {
			return this.node.id;
		}

		@Override
		public String toString() {
			return "id: " + node.id + ", level: " + level;
		}

	}

	static class Node implements Comparable<Node> {
		int id;
		int cost;
		Set<Node> edges;

		public Node(int id, int cost) {
			this.id = id;
			this.cost = cost;

			this.edges = new TreeSet<>(Collections.reverseOrder());
		}

		public void addEdge(Node e) {
			this.edges.add(e);
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
		public String toString() {
			StringBuilder s = new StringBuilder();
			s.append(String.format("[id=%d, cost=%d, edgeCount=%d ]", id, cost, edges.size()));
			return s.toString();

		}

		@Override
		public int compareTo(Node that) {
			return Integer.compare(this.id, that.id);
		}

	}

}
