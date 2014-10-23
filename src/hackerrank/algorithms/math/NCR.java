package hackerrank.algorithms.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class NCR {

	private void solve(int N, int R) {

		// System.out.println(Long.MAX_VALUE);
		R = Math.min(R, N - R);
		int R1 = R;
		long num = 1;
		long den = R;
		long sum = 0;
		for (int i = 1; i <= R1; i++) {
			num *= N--;
			--R;
			den *= (R == 0) ? 1 : R;

			long g = gcd(num, den);

			System.out.println("num = " + num + ", den = " + den + ", gcd = "
					+ g);

			/*
			 * if(num > Integer.MAX_VALUE && (num / den) > 1) { num -= (den) *
			 * ((num) / den); den = 1; }
			 */

			long n = num / 142857;
			// System.out.println("n = " + n);
			sum += n;
			if (n > 2)
				num = num - ((n - 1) * 142857);

			num /= g;
			den /= g;

			// System.out.println(num + ", den = " + den + ", gcd = " + g);

		}

		System.out.println("sum = " + sum);
		System.out.println("num = " + num + ", den = " + den);

		System.out.println((num / den) % 142857);

	}

	private long gcd(long K, long M) {
		long k = Math.max(K, M);
		long m = Math.min(K, M);

		while (m != 0) {
			long r = k % m;
			k = m;
			m = r;
		}
		return k;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		String line;
		String[] tmp;
		for (int i = 0; i < T; i++) {
			line = br.readLine();
			tmp = line.split(" ");
			new NCR().solve(Integer.parseInt(tmp[0]), Integer.parseInt(tmp[1]));
		}

	}

}
