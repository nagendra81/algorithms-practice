package hackerrank.algorithms.warmup;

import java.util.Scanner;

public class CompareTriplets {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int[] a = new int[3];
		for (int i = 0; i < 3; i++) {
			a[i] = sc.nextInt();
		}
		int[] b = new int[3];
		for (int i = 0; i < 3; i++) {
			b[i] = sc.nextInt();
		}

		int sa = 0, sb = 0;

		for (int i = 0; i < 3; i++) {
			if (a[i] < b[i]) {
				sb++;
			} else if (a[i] > b[i]) {
				sa++;
			}
		}
		System.out.printf("%d %d\n", sa, sb);

	}
}
