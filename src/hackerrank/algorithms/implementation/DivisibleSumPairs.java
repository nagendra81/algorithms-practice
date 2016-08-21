package hackerrank.algorithms.implementation;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class DivisibleSumPairs {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int K = sc.nextInt();

		int[] arr = new int[N];
		HashMap<Integer, Set<Integer>> map = new HashMap<>();

		for (int i = 0; i < N; i++) {
			int t = sc.nextInt();
			t %= K;
			arr[i] = t;
			Set<Integer> se = map.get(t);
			if (se == null) {
				se = new HashSet<>();

			}
			se.add(i);
			map.put(t, se);
		}

		int cnt = 0;
		for (int i = 0; i < N; i++) {
			int t = arr[i];
			Set<Integer> se;
			if (t == 0) {
				se = map.get(0);
			} else {
				se = map.get(K - t);
			}
			if (se != null) {
				for (int j : se) {
					if (i < j)
						cnt++;
				}
			}
		}
		System.out.println(cnt);
	}

}
