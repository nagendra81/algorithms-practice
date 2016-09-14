package hackerearth.algorithms.graph.graph_representation;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class MonkRealEstate {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		// Map<Integer, Integer> adj = new HashMap<>();
		for (int t = 0; t < T; t++) {
			int E = sc.nextInt();
			Set<Integer> nodes = new HashSet<>();
			for (int e = 0; e < E; e++) {
				int u = sc.nextInt();
				int v = sc.nextInt();
				nodes.add(u);
				nodes.add(v);
			}
			System.out.println(nodes.size());
		}
	}
}
