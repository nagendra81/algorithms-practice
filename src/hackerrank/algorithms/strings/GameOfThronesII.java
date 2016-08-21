package hackerrank.algorithms.strings;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class GameOfThronesII {

	static final int P = 1000000007;

	public static void main(String[] args) throws FileNotFoundException {
		 //Scanner in = new Scanner(System.in);
		Scanner in = new Scanner(new File(
				"C:\\users\\nchumbal\\Desktop\\gameofThronesII\\input.txt"));

		String line = in.nextLine();

		int n = line.length();

		Map<Character, Integer> freqMap = new HashMap<Character, Integer>();

		char[] charArr = line.toCharArray();

		for (int i = 0; i < n; i++) {
			Character c = charArr[i];
			Integer f = freqMap.get(c);
			if (f == null)
				f = 0;
			freqMap.put(c, f + 1);
		}

		long kSum = 0;
		long res = 1;

		for (Integer v : freqMap.values()) {
			if (v / 2 == 0)
				continue;
			kSum += v / 2;
			// res *= nCr(kSum, v/2);
			res *= nCr(kSum, v / 2, P);
			res %= P;
		}

		/*
		 * for(Integer v: kList) { System.out.println("V:" + v); //
		 * System.out.println(res); }
		 */

		System.out.println(res);
		return;

	}

	static long modPow(long a, long x, long p) {
		long res = 1;
		while (x > 0) {
			if (x % 2 != 0) {
				res = (res * a) % p;
			}
			a = (a * a) % p;
			x /= 2;
		}
		return res;
	}

	static long modInverse(long a, long p) {
		return modPow(a, p - 2, p);
	}

	static long nCr(long n, long k, long p) {
		long num = 1;
		for (int i = 0; i < k; i++) {
			num = (num * (n - i)) % p;
		}

		long den = 1;
		for (int i = 1; i <= k; i++) {
			den = (den * i) % p;
		}

		return (num * modInverse(den, p)) % p;
	}

	public int calculate(int k, int n) {
		return (int) (nCr(n + k, k + 1, 1000000007));
	}

}
