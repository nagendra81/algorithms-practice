package hackerrank.algorithms.implementation;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

public class NonDivisibleSubset {
	public static void main(String[] args) throws FileNotFoundException {
		// Scanner sc = new Scanner(System.in);
		Scanner sc = new Scanner(new File("C:\\users\\nagend~1\\Desktop\\nds09.txt"));

		int N = sc.nextInt();
		int K = sc.nextInt();

		int[] arr = new int[N];

		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
			arr[i] %= K;
		}

		System.out.println(Arrays.toString(arr));

		Map<Integer, Integer> freq = new HashMap<>();

		for (int a : arr) {
			if (a == 0) {
				freq.put(a, 1);
			} else {
				Integer c = freq.get(a);
				if (c == null)
					c = 0;
				freq.put(a, c + 1);
			}
		}

		System.out.println(freq);

		if (isOdd(K)) {
			int max = 0;

			for (int i = 0; i <= K / 2; i++) {
				max += Math.max(iffNull(freq.get(i)), iffNull(freq.get(K - i)));
			}
			System.out.println(max);

		} else {
			int max = 0;

			for (Entry<Integer, Integer> en : freq.entrySet()) {
				int k = en.getKey();
				int v = en.getValue();
				if (k == 0 || (K - k) == 0 || (k % K) == 0)
					max += 2;
				else {
					max += v;
				}
			}
			System.out.println(max / 2);

		}

	}

	private static int iffNull(Integer f) {
		if (f == null)
			return 0;
		return f;

	}

	private static boolean isOdd(int k) {
		return ((k & 1) == 1);
	}

}
