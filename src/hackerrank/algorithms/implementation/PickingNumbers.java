package hackerrank.algorithms.implementation;

import java.util.Arrays;
import java.util.Scanner;

public class PickingNumbers {
	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			int n = sc.nextInt();

			int[] num = new int[n];
			for (int i = 0; i < n; i++) {
				num[i] = sc.nextInt();
			}

			Arrays.sort(num);

			int[] res = new int[n];
			Arrays.fill(res, 1);
			for (int i = 0; i < n; i++) {
				for (int j = i + 1; j < n; j++) {
					if (abs(num[j], num[i]) <= 1) {
						res[i] = res[i] + 1;
					} else {
						break;
					}
				}
			}
			int max = -1;
			for (int i : res) {
				if (i > max)
					max = i;
			}
			System.out.println(max);

		}

	}

	private static int abs(int x, int z) {
		if (x < z)
			return z - x;
		return x - z;
	}

}
