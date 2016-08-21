package hackerrank.algorithms.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class SnakesLadders {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine().trim());

		for (int t = 0; t < T; t++) {
			int N = Integer.parseInt(br.readLine().trim());
			Map<Integer, Integer> ladders = new HashMap<>();
			for (int n = 0; n < N; n++) {
				String[] line = br.readLine().trim().split(" ");
				ladders.put(Integer.parseInt(line[0]), Integer.parseInt(line[1]));
			}

			int M = Integer.parseInt(br.readLine().trim());
			Map<Integer, Integer> snakes = new HashMap<>();

			for (int m = 0; m < M; m++) {
				String[] line = br.readLine().trim().split(" ");
				snakes.put(Integer.parseInt(line[0]), Integer.parseInt(line[1]));
			}

			solve(snakes, ladders);
		}

	}

	private static void solve(Map<Integer, Integer> snakes, Map<Integer, Integer> ladders) {
		int[] cost = new int[101];
		Arrays.fill(cost, Integer.MAX_VALUE);

		boolean[] visited = new boolean[101];

		PriorityQueue<Node> pq = new PriorityQueue<>();

		pq.add(new Node(1, 0));
		cost[1] = 0;
		visited[1] = true;

		while (!pq.isEmpty()) {

			Node curr = pq.poll();
			visited[curr.num] = true;
			// System.out.println("Curr Node: " + curr);
			if (curr.num >= 100) {
				break;
			}

			if (ladders.containsKey(curr.num) && !visited[ladders.get(curr.num)]) {
				int neigh = ladders.get(curr.num);
				cost[neigh] = Math.min(cost[curr.num], cost[neigh]);
				Node tmp = new Node(neigh, cost[neigh]);
				pq.remove(tmp);
				pq.add(tmp);
			} else if (snakes.containsKey(curr.num) && !visited[snakes.get(curr.num)]) {
				int neigh = snakes.get(curr.num);
				cost[neigh] = Math.min(cost[curr.num], cost[neigh]);

				Node tmp = new Node(neigh, cost[neigh]);
				pq.remove(tmp);
				pq.add(tmp);
			} else {

				for (int i = 1; i <= 6; i++) {
					int neigh = curr.num + i;
					if (neigh <= 100 && !visited[neigh]) {
						cost[neigh] = Math.min(cost[curr.num] + 1, cost[neigh]);

						Node tmp = new Node(neigh, cost[neigh]);
						pq.remove(tmp);
						pq.add(tmp);
					}
				}
			}

		}

		// System.out.println(Arrays.toString(cost));
		if (cost[100] == Integer.MAX_VALUE) {
			System.out.println("-1");
		} else {
			System.out.println(cost[100]);
		}

	}

	static class Node implements Comparable<SnakesLadders.Node> {
		int num;
		int cost;

		Node(int num, int cost) {
			this.num = num;
			this.cost = cost;
		}

		@Override
		public boolean equals(Object obj) {
			Node that = (Node) obj;
			return this.num == that.num;
		}

		@Override
		public int hashCode() {
			return this.num;
		}

		@Override
		public int compareTo(Node that) {
			return Integer.compare(cost, that.cost);
		}

		@Override
		public String toString() {
			return "[Node: " + num + ", Cost: " + cost + "]";
		}

	}

}
