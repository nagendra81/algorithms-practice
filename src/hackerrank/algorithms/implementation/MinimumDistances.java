package hackerrank.algorithms.implementation;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class MinimumDistances {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();

		int[] arr = new int[N];
		HashMap<Integer, Set<Integer>> map = new HashMap<>();

		for (int i = 0; i < N; i++) {
			int t = sc.nextInt();
			arr[i] = t;
			Set<Integer> se = map.get(t);
			if (se == null) {
				se = new HashSet<>();

			}
			se.add(i);
			map.put(t, se);
		}

		int min = Integer.MAX_VALUE;
		for (int i = 0; i < N; i++) {
			Set<Integer> se = map.get(arr[i]);
			if (se == null) {
				continue;
			}
			for (int j : se) {
				if (i != j) {
					int m = Math.abs(i - j);
					min = Math.min(m, min);
				}
			}
		}

		if (min == Integer.MAX_VALUE) {
			System.out.println(-1);
		} else {
			System.out.println(min);
		}

	}

}
