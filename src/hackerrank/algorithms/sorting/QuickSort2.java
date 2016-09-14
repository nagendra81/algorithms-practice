package hackerrank.algorithms.sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class QuickSort2 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine().trim());
		int[] a = new int[N];
		String[] line = br.readLine().split(" ");

		for (int i = 0; i < N; i++) {
			a[i] = Integer.parseInt(line[i]);
		}

		doQuickSort(a, 0, N - 1);
		// print(a, 0, N - 1);

	}

	private static void doQuickSort(int[] vals, int lo, int hi) {
		if (hi - lo < 0) {
			return;
		} else {
			int p = partition(vals, lo, hi);
			// System.out.println("partition: " + vals[p]);
			doQuickSort(vals, lo, p - 1);
			// print(vals, lo, p - 1);
			doQuickSort(vals, p + 1, hi);
			// print(vals, p + 1, hi);
			print(vals, lo, hi);
		}
	}

	private static void print(int[] vals, int lo, int hi) {
		if (lo >= hi) {
			return;
		}
		StringBuilder sb = new StringBuilder();
		for (int i = lo; i <= hi; i++) {
			sb.append(vals[i] + " ");
		}
		System.out.println(sb.toString().trim());
	}

	private static int partition(int[] vals, int lo, int hi) {
		int p = vals[lo];
		List<Integer> lt = new ArrayList<>();
		List<Integer> gt = new ArrayList<>();

		for (int i = lo + 1; i <= hi; i++) {
			if (vals[i] <= p) {
				lt.add(vals[i]);
			} else {
				gt.add(vals[i]);
			}
		}

		// System.out.println("part: " + p);
		// System.out.println("lt: " + lt);
		// System.out.println("gt: " + gt);

		int i = lo;
		for (Integer v : lt) {
			vals[i++] = v;
		}
		vals[i++] = p;
		for (Integer v : gt) {
			vals[i++] = v;
		}

		return lo + lt.size();

	}

	private static void swap(int[] vals, int lo, int hi) {
		int t = vals[lo];
		vals[lo] = vals[hi];
		vals[hi] = t;

	}

}
