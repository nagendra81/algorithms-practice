package hackerearth.algorithms.graph.graph_representation;

import java.util.Scanner;

public class MonkGraphFactory {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();

		int sum = 0;

		for (int i = 0; i < N; i++) {
			sum += sc.nextInt();
		}

		if (sum < (N * (N + 1)) / 2) {
			System.out.println("Yes");
		} else {
			System.out.println("No");
		}
	}

}
