package hackerrank.algorithms.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.BitSet;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class RustMurderer {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		String[] line;
		for (int t = 0; t < T; t++) {
			line = br.readLine().split(" ");
			int N = Integer.parseInt(line[0]);
			int M = Integer.parseInt(line[1]);

			int[] U = new int[M];
			int[] V = new int[M];

			Map<Integer, Set<Integer>> adjCity = new HashMap<>();
			for (int m = 0; m < M; m++) {
				line = br.readLine().split(" ");
				U[m] = Integer.parseInt(line[0]);
				V[m] = Integer.parseInt(line[1]);

			}

			int S = Integer.parseInt(br.readLine());

			for (int m = 0; m < M; m++) {
				int u = U[m];
				int v = V[m];
				Set<Integer> ed = adjCity.get(u);
				if (ed == null) {
					ed = new HashSet<>();
				}
				ed.add(v);
				adjCity.put(u, ed);

				ed = adjCity.get(v);
				if (ed == null) {
					ed = new HashSet<>();

				}
				ed.add(u);
				adjCity.put(v, ed);
			}

			/*
			 * Map<Integer, Set<Integer>> adjVill = new HashMap<>();
			 * 
			 * for (int i = 1; i <= N; i++) { Set<Integer> ed = adjVill.get(i);
			 * if (ed == null) ed = new HashSet<>(); for (int j = 1; j <= N;
			 * j++) { if (adjCity.get(i) != null && adjCity.get(i).contains(j))
			 * { continue; } else { ed.add(j); } } if (ed.size() > 0)
			 * adjVill.put(i, ed); }
			 */

			solve(adjCity, N, S);
		}

	}

	private static void solve(Map<Integer, Set<Integer>> adjCity, int N, int S) {
		// System.out.println("Villaga: " + adjVill);
		// System.out.println("S: " + S);

		int[] dist = new int[N + 1];

		Arrays.fill(dist, Integer.MAX_VALUE);

		boolean[] visited = new boolean[N + 1];

		Set<Integer> undiscovered = new HashSet<>();
		for (int i = 1; i <= N; i++) {
			undiscovered.add(i);
		}

		Queue<Integer> q = new LinkedList<>();

		q.add(S);

		dist[S] = 0;
		visited[S] = true;
		undiscovered.remove(S);

		while (undiscovered.size() > 0) {
			int curr = q.remove();
			visited[curr] = true;
			undiscovered.remove(curr);
			BitSet neighbors = getVillageRoads(adjCity.get(curr), N, S);

			if (neighbors == null)
				continue;
			for (int i = 1; i <= N; i++) {
				if (neighbors.get(i) && !visited[i]) {
					dist[i] = Math.min(dist[i], dist[curr] + 1);
					visited[i] = true;
					q.add(i);
					undiscovered.remove(i);
				}
			}
		}

		// System.out.println(Arrays.toString(dist));

		StringBuilder sb = new StringBuilder();

		for (int i = 1; i < dist.length; i++) {
			if (i != S) {
				sb.append(dist[i]);
				sb.append(" ");
			}
		}

		System.out.println(sb.toString().trim());
	}

	private static BitSet getVillageRoads(Set<Integer> set, int N, int s) {

		BitSet bitSet = new BitSet(N + 1);

		bitSet.flip(0, N + 1);

		bitSet.clear(s);

		if (set != null) {
			for (int i : set) {
				bitSet.clear(i);
			}
		}

		// System.out.println(bitSet);
		return bitSet;

	}

}
