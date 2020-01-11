package hackerrank.algorithms.implementation;

import java.util.Arrays;
import java.util.Scanner;

public class MigratoryBirds {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			int n = sc.nextInt();

			int[] birds = new int[n];
			Arrays.fill(birds, 0);

			for (int i = 0; i < n; i++) {
				int s = sc.nextInt();
				birds[s]++;
			}

			int max = findMax(birds);
			// Arrays.sort(birds);
			for (int i = 0; i < n; i++) {
				if (birds[i] == max) {
					System.out.println(i);
					return;
				}
			}

		}
	}

	private static int findMax(int[] birds) {
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < birds.length; i++) {
			if (birds[i] > max) {
				max = birds[i];
			}
		}
		return max;
	}

}
