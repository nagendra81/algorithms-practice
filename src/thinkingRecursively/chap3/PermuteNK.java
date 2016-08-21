package thinkingRecursively.chap3;

import java.util.Scanner;

public class PermuteNK {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (true) {
			int N = sc.nextInt();
			int K = sc.nextInt();

			int res = permuteNK(N, K);
			System.out.println(res);
			System.out.println();
		}
	}

	private static int permuteNK(int n, int k) {
		if (k == 0) {
			return 1;
		}
		return n * permuteNK(n - 1, k - 1);
	}

}
