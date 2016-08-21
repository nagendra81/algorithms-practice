package hackerrank.algorithms.dynamic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class FibonacciModified {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] line = br.readLine().split(" ");
		int A = Integer.parseInt(line[0]);
		int B = Integer.parseInt(line[1]);
		int N = Integer.parseInt(line[2]);

		BigInteger[] F = new BigInteger[N];
		F[0] = BigInteger.valueOf(A);
		F[1] = BigInteger.valueOf(B);

		for (int i = 2; i < N; i++) {
			F[i] = (F[i - 1].multiply(F[i - 1])).add(F[i - 2]);
			// F[i] = (F[i - 1] * F[i - 1]) + F[i - 2];
		}

		System.out.println(F[N - 1]);
	}

}
