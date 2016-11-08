package math.numbers.primality;

import java.util.BitSet;
import java.util.Scanner;

public class KaranPrime {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		for (int t = 0; t < T; t++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			solve(a, b);
		}
	}

	private static void solve(int a, int b) {
		BitSet sieve = new BitSet(b + 1);
		sieve.clear();
		sieve.set(1);

		int sq = (int) Math.ceil(Math.sqrt(b));
		// System.out.println(sq);

		for (int i = 2; i <= sq; i++) {
			for (int j = 2 * i; j <= b; j += i) {
				sieve.set(j);
			}
		}

		// System.out.println(sieve);

		long sum = 0;
		for (int i = a; i <= b; i++) {
			if (sieve.get(i) == false) { // prime
				sum += (i * 1L);
			}
		}
		System.out.println(sum);

	}
}
