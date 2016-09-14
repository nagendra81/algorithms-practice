package hackerrank.algorithms.implementation;

import java.util.Scanner;

public class StrangeCounter {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		long T = sc.nextLong();
		long t = 1L;
		long v = 3L;

		while (t < T && T > (v + t - 1)) {
			t += v;
			v *= 2L;
		}

		System.out.println(v - (T - t));

	}
}
