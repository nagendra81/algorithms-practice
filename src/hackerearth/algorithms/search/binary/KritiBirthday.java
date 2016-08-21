package hackerearth.algorithms.search.binary;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Scanner;

public class KritiBirthday {

	private static int BLOCK_SIZE;
	private static int li = 0;
	private static int ri = 0;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		BLOCK_SIZE = (int) Math.sqrt(N);

		String[] arr = new String[N + 1];

		for (int i = 0; i < N; i++) {
			arr[i + 1] = sc.next();
		}

		int M = sc.nextInt();

		PriorityQueue<Query> queue = new PriorityQueue<Query>();

		for (int i = 0; i < M; i++) {
			Query qu = new Query(i, sc.nextInt(), sc.nextInt(), sc.next());
			queue.add(qu);
		}

		int[] res = new int[M];

		Map<String, Integer> freqMap = new HashMap<>();
		while (!queue.isEmpty()) {
			Query qu = queue.remove();
			int ans = solve(qu, arr, freqMap);
			res[qu.id] = ans;
		}

		for (int i = 0; i < res.length; i++) {
			System.out.println(res[i]);
		}
	}

	static void add(Map<String, Integer> map, String key) {
		Integer value = map.get(key);
		if (value == null) {
			value = 0;
		}
		value++;
		map.put(key, value);
	}

	static void subtract(Map<String, Integer> map, String key) {
		Integer value = map.get(key);
		if (value == null) {
			value = 0;
		}
		value--;
		map.put(key, value);

	}

	private static int solve(Query qu, String[] arr, Map<String, Integer> freqMap) {

		while (ri < qu.R) {
			ri++;
			add(freqMap, arr[ri]);
		}
		while (ri > qu.R) {
			subtract(freqMap, arr[ri]);
			ri--;
		}

		while (li < qu.L) {
			subtract(freqMap, arr[li]);
			li++;
		}
		while (li > qu.L) {
			li--;
			add(freqMap, arr[li]);

		}

		Integer res = freqMap.get(qu.key);
		if (res == null)
			res = 0;
		return res;
	}

	static class Query implements Comparable<Query> {
		int id;
		int L;
		int R;
		String key;

		public Query(int id, int L, int R, String key) {
			this.id = id;
			this.L = L;
			this.R = R;
			this.key = key;
		}

		@Override
		public boolean equals(Object obj) {
			Query that = (Query) obj;

			return this.id == that.id;
		}

		public int hashCode() {
			return this.id;
		}

		@Override
		public int compareTo(Query that) {
			int l1 = this.L / BLOCK_SIZE;
			int l2 = that.L / BLOCK_SIZE;

			if (l1 == l2) {
				return Integer.compare(this.R, that.R);
			} else {
				return Integer.compare(l1, l2);
			}
		}

		@Override
		public String toString() {
			return String.format("id=%d,L=%d,R=%d,key=%s", id, L, R, key);
		}
	}
}
