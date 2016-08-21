package hackerrank.algorithms.search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class Median {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine().trim());

		int[] ar = new int[N];
		char[] op = new char[N];
		
		String[] tmp;
		for(int i = 0; i < N; i++) {
			tmp = br.readLine().split(" ");
			op[i] = tmp[0].charAt(0);
			ar[i] = Integer.parseInt(tmp[1]);
			
		}
		solve(N, ar, op);

	}

	private static void solve(int n, int[] ar, char[] op) {
		System.out.println(Arrays.toString(op));
		System.out.println(Arrays.toString(ar));
		
		PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
		PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(1, Collections.reverseOrder());
		
		double m = 0.0;
		
		for(int i = 0; i < n; i++) {
			m = getMedian(ar[i], m, minHeap, maxHeap);
		}
	}

	private static double getMedian(int e, double m,
			PriorityQueue<Integer> minHeap, PriorityQueue<Integer> maxHeap) {
		int size1 = minHeap.size();
		int size2 = maxHeap.size();
		
		if(size1 == size2) {
			if(e < m) {
				maxHeap.add(e);
				m = maxHeap.element();
			} else {
				minHeap.add(e);
				m = minHeap.element();
			}
		} else if (size1 > size2) {
			if(e < m) {
				maxHeap.offer(e);
			} else {
				maxHeap.offer(minHeap.poll());
			}
			m = (minHeap.element() + maxHeap.element())/2.0;
		} else if (size1 < size2) {
			if(e < m) {
				minHeap.add(e);
			} else {
				minHeap.offer(maxHeap.poll());
			}
			m = (minHeap.element() + maxHeap.element()) / 2.0;
		}
		
		return m;
	}
}
