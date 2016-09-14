package hackerrank.algorithms.implementation;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class AbsolutePermutation {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int t = 0; t < T; t++) {
			solve(sc.nextInt(), sc.nextInt());
		}

	}

	private static void solve(int N, int K) {

		int[] res = new int[N + 1];
		Set<Integer> used = new HashSet<>();

		res[1] = K + 1;
		used.add(res[1]);
		for (int i = 2; i <= N; i++) {
			int a = used.contains(K + i) ? Integer.MAX_VALUE : K + i;
			int b = Math.abs(K - i);
			if (b == 0 || used.contains(b))
				b = Integer.MAX_VALUE;

			if (a == Integer.MAX_VALUE && b == Integer.MAX_VALUE) {
				System.out.println("-1");
				return;
			}

			System.out.println("a =  " + a + ",b = " + b);
			res[i] = Math.min(a, b);
			if (res[i] > N) {

				System.out.println(res[i]);
				System.out.println("NN-1");
				return;
			}
			used.add(res[i]);

		}

		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= N; i++) {
			sb.append(res[i]);
			sb.append(" ");
		}
		System.out.println(sb.toString().trim());
	}

}
