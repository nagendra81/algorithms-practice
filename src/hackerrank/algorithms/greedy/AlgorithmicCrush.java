package hackerrank.algorithms.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class AlgorithmicCrush {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] line = br.readLine().split(" ");

		int N = Integer.parseInt(line[0]);
		int M = Integer.parseInt(line[1]);

		long[] add = new long[N + 1];
		Arrays.fill(add, 0);

		long[] rem = new long[N + 1];
		Arrays.fill(rem, 0);

		for (int i = 0; i < M; i++) {
			line = br.readLine().split(" ");
			int a = Integer.parseInt(line[0]);
			int b = Integer.parseInt(line[1]);
			int k = Integer.parseInt(line[2]);

			add[a] += k;
			rem[b] += k;
		}
		// System.out.println(Arrays.toString(add));
		// System.out.println(Arrays.toString(rem));

		long max = Long.MIN_VALUE;
		long cmax = 0;

		for (int i = 0; i <= N; i++) {
			cmax += add[i];
			if (cmax > max) {
				max = cmax;
			}
			// System.out.println(max);
			cmax -= rem[i];

		}
		System.out.println(max);
	}

}
