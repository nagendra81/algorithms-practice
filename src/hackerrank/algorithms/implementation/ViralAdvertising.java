package hackerrank.algorithms.implementation;

import java.util.Scanner;

public class ViralAdvertising {
	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			int n = sc.nextInt();

			int[] liked = new int[n];

			liked[0] = 2;
			for (int i = 1; i < n; i++) {
				liked[i] = (liked[i - 1] * 3) / 2;
			}

			int res = 0;
			for (int l : liked) {
				res += l;
			}
			System.out.println(res);
		}
	}

}
