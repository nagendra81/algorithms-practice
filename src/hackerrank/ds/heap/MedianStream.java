package hackerrank.ds.heap;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class MedianStream {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		int[] A = new int[N];
		for (int n = 0; n < N; n++) {
			A[n] = Integer.parseInt(br.readLine());

		}
		solve(A);
	}

	private static void solve(int[] A) {
		PriorityQueue<Integer> left = new PriorityQueue<>(Collections.reverseOrder());
		PriorityQueue<Integer> right = new PriorityQueue<>();
		for (int i = 0; i < A.length; i++) {
			if (left.isEmpty()) {
				left.add(A[i]);
			} else if (right.isEmpty() && A[i] <= left.peek()) {
				right.add(left.remove());
				left.add(A[i]);
			} else if (right.isEmpty()) {
				right.add(A[i]);
			} else if (A[i] <= left.peek()) {
				left.add(A[i]);
			} else {
				right.add(A[i]);
			}
			balance(left, right);

			double median = -1;
			;
			if (left.size() == right.size()) {
				median = (left.peek() + right.peek()) / 2.0;
			} else if (left.size() > right.size()) {
				median = (double) left.peek();
			} else if (right.size() > left.size()) {
				median = (double) right.peek();
			}
			System.out.println(String.format("%.1f", median));
		}
	}

	private static void balance(PriorityQueue<Integer> left, PriorityQueue<Integer> right) {
		if (left.size() == right.size()) {
			return;
		}
		if (left.size() - right.size() > 1) {
			while ((left.size() - right.size()) > 1) {
				right.add(left.remove());
			}
		}
		if (right.size() - left.size() > 1) {
			while ((right.size() - left.size()) > 1) {
				left.add(right.remove());
			}
		}

	}

}
