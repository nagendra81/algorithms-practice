package hackerrank.algorithms.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class ExtraLongFactorial {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine().trim());

		BigInteger factorial = BigInteger.ONE;

		for (int i = 1; i <= N; i++) {
			factorial = factorial.multiply(BigInteger.valueOf(i));
		}
		System.out.println(factorial);
	}

}
