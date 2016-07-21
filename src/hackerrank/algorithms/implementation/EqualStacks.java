package hackerrank.algorithms.implementation;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class EqualStacks {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N1 = sc.nextInt();
		int N2 = sc.nextInt();
		int N3 = sc.nextInt();

		List<LinkedList<Integer>> cylinders = new ArrayList<LinkedList<Integer>>();
		cylinders.add(new LinkedList<>());
		cylinders.add(new LinkedList<>());
		cylinders.add(new LinkedList<>());

		long[] sums = new long[3];

		for (int i = 0; i < N1; i++) {
			int h = sc.nextInt();
			sums[0] += h;
			cylinders.get(0).add(h);
		}

		for (int i = 0; i < N2; i++) {
			int h = sc.nextInt();
			sums[1] += h;
			cylinders.get(1).add(h);
		}

		for (int i = 0; i < N3; i++) {
			int h = sc.nextInt();
			sums[2] += h;
			cylinders.get(2).add(h);
		}

		for (;;) {
			if (isEqual(sums)) {
				break;
			}
			int idx = getMax(sums);
			LinkedList<Integer> st = cylinders.get(idx);
			sums[idx] -= st.poll();
		}
		System.out.println(sums[0]);
	}

	private static int getMax(long[] sums) {
		long max = sums[0];
		int max_i = 0;

		for (int i = 1; i < sums.length; i++) {
			if (sums[i] > max) {
				max = sums[i];
				max_i = i;
			}
		}
		return max_i;

	}

	private static boolean isEqual(long[] sums) {
		for (int i = 1; i < sums.length; i++) {
			if (sums[i] != sums[i - 1])
				return false;
		}
		return true;
	}

}
