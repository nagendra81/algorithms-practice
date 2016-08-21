package hackerrank.algorithms.warmup;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ArraySum {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine().trim());
		long sum = 0;

		String[] line = br.readLine().split(" ");
		for (int i = 0; i < N; i++) {
			sum += Long.parseLong(line[i]);

		}
		System.out.println(sum);

	}

}
