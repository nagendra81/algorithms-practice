package hackerrank.algorithms.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class JourneyMoon {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int I = sc.nextInt();

		Map<Integer, List<Integer>> adj = new HashMap<>();

		for (int i = 0; i < I; i++) {
			int s = sc.nextInt();
			int e = sc.nextInt();

			List<Integer> edges = adj.get(s);
			if (edges == null) {
				edges = new ArrayList<>();

			}
			edges.add(e);
			adj.put(s, edges);

			edges = adj.get(e);
			if (edges == null) {
				edges = new ArrayList<>();
			}
			edges.add(s);
			adj.put(e, edges);
		}

		// System.out.println("adj: " + adj);
		Map<Integer, Integer> ccMap = connComp(adj, N);
		// System.out.println(ccMap);

		long[] arr = toArray(ccMap);
		//
		// Arrays.sort(arr);

		// System.out.println(Arrays.toString(arr));
		long res = computeResult(arr);
		System.out.println(res);

	}

	private static long computeResult(long[] arr) {

		long[] prefix = new long[arr.length];

		prefix[0] = arr[0];

		for (int i = 1; i < arr.length; i++) {
			prefix[i] = prefix[i - 1] + arr[i];
		}
		// System.out.println("prefix: " + Arrays.toString(prefix));

		long res = 0;

		for (int i = 1; i < arr.length; i++) {
			res += (arr[i] * prefix[i - 1]);
		}

		return res;
	}

	private static long[] toArray(Map<Integer, Integer> ccMap) {
		long[] arr = new long[ccMap.values().size()];

		int i = 0;
		for (Integer v : ccMap.values()) {
			arr[i++] = v * 1L;
		}

		return arr;
	}

	private static Map<Integer, Integer> connComp(Map<Integer, List<Integer>> adj, int N) {
		Map<Integer, Integer> ccMap = new HashMap<>();

		boolean[] visited = new boolean[N];
		Arrays.fill(visited, false);
		for (int i = 0; i < N; i++) {
			if (!visited[i]) {
				int cnt = explore(adj, i, visited);
				ccMap.put(i, cnt);
			}
		}

		return ccMap;
	}

	private static int explore(Map<Integer, List<Integer>> adj, int node, boolean[] visited) {
		int cnt = 1;

		visited[node] = true;

		if (adj.get(node) != null) {
			for (Integer v : adj.get(node)) {
				if (!visited[v.intValue()])
					cnt += explore(adj, v, visited);
			}
		}
		return cnt;
	}
}
