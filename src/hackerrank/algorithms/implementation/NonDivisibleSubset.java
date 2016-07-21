package hackerrank.algorithms.implementation;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class NonDivisibleSubset {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int K = sc.nextInt();

		int[] arr = new int[N];

		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
			arr[i] %= K;
		}
		Map<Integer, Integer> freqMap = new HashMap<Integer, Integer>();

		for (int i = 0; i < N; i++) {
			Integer val = freqMap.get(arr[i]);
			if (val == null) {
				val = 0;
			}
			val++;
			freqMap.put(arr[i], val);
		}

		int cnt = 0;
		for (int k : freqMap.keySet()) {
			int m2 = freqMap.get(K - k) == null ? Integer.MIN_VALUE : freqMap.get(K - k);
			cnt += Math.max(k, m2);
			freqMap.remove(K - k);

		}

		System.out.println(freqMap);
		System.out.println(cnt);

	}

}
