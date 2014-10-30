package hackerrank.algorithms.warmup;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MaximizeXOR {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int L = Integer.parseInt(br.readLine());
		int R = Integer.parseInt(br.readLine());

		int res = Integer.MIN_VALUE;

		int t;
		for (int i = L; i <= R; i++) {
			for (int j = L; j <= R; j++) {
				t = i ^j;
				res = Math.max(res, t);

			}
		}
		System.out.println(res);

	}

}
