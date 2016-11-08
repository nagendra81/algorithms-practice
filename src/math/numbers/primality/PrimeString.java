package math.numbers.primality;

import java.util.Arrays;
import java.util.Scanner;

public class PrimeString {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		String[] input = new String[T];
		for (int t = 0; t < T; t++) {
			input[t] = sc.next();
		}

		for (int i = 0; i < T; i++) {
			boolean ok = solve(input[i]);
			if (ok) {
				System.out.println("YES");
			} else {
				System.out.println("NO");
			}
		}

	}

	private static boolean solve(String next) {
		int[] freq = new int[26];
		Arrays.fill(freq, 0);

		for (int i = 0; i < next.length(); i++) {
			freq[next.charAt(i) - 'a']++;
		}

		int cnt = 0;

		for (int i = 0; i < freq.length; i++) {
			if (freq[i] > 0) {
				cnt++;
				if (!isPrime(freq[i])) {
					return false;
				}
			}
		}

		if (!isPrime(cnt)) {
			return false;
		}

		return true;
	}

	private static boolean isPrime(int num) {
		if (num < 2)
			return false;
		if (num == 2)
			return true;
		if (num % 2 == 0)
			return false;
		for (int i = 3; i * i <= num; i += 2)
			if (num % i == 0)
				return false;
		return true;
	}

}
