package hackerrank.algorithms.search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class FindTheMedian {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		int[] ar = new int[N];

		String line = br.readLine();
		String[] tmp = line.split(" ");
		for (int i = 0; i < N; i++) {
			ar[i] = Integer.parseInt(tmp[i]);
		}

		solve(N, ar);

	}

	private static void solve(int N, int[] ar) {
		PriorityQueue<Integer> heap = new PriorityQueue<Integer>();

		for (int a : ar)
			heap.add(a);

		int k = (N + 1) / 2;
		int m1 = 0;

		for (int i = 0; i < k; i++) {
			m1 = heap.remove();
		}
		System.out.println(m1);
	}
}
