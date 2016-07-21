package hackerrank.algorithms.dynamic;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Candies {

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();

		int[] kids = new int[N];
		for (int i = 0; i < N; i++) {
			kids[i] = sc.nextInt();
		}

		int[] opt = new int[N];
		Arrays.fill(opt, 1);

		for (int i = 1; i < N; i++) {
			if (kids[i] > kids[i - 1]) {
				opt[i] = opt[i - 1] + 1;
			}
		}

		for (int i = N - 1; i > 0; i--) {
			if (kids[i - 1] > kids[i]) {
				opt[i - 1] = Math.max(opt[i - 1], opt[i] + 1);
			}
		}

		long s = 0L;
		for (long op : opt) {
			s += op;
		}
		System.out.println(s);
	}
}
