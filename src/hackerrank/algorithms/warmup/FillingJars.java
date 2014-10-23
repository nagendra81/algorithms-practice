package hackerrank.algorithms.warmup;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FillingJars {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] line = br.readLine().split(" ");

		int N = Integer.parseInt(line[0]);
		int M = Integer.parseInt(line[1]);

		String queries[] = new String[M];

		long total = 0;

		for (int m = 0; m < M; m++) {
			queries[m] = br.readLine();
		}
		for (int m = 0; m < M; m++) {
			line = queries[m].split(" ");
			long a = Long.parseLong(line[0]);
			long b = Long.parseLong(line[1]);
			long k = Long.parseLong(line[2]);

			total += (b - a + 1) * k;

		}
		System.out.println(total / N);

	}

}
