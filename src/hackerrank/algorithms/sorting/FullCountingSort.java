package hackerrank.algorithms.sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class FullCountingSort {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine().trim());

		int[] keys = new int[N];
		String[] vals = new String[N];

		for (int i = 0; i < N; i++) {
			String[] line = br.readLine().split(" ");
			keys[i] = Integer.parseInt(line[0]);
			vals[i] = line[1].trim();
		}

		int[] count = new int[1000000];
		Arrays.fill(count, 0);

		for (int i = 0; i < N; i++) {
			count[keys[i]]++;
		}

		StringBuilder sb = new StringBuilder();

		long res = 0;

		for (int i = 0; i < 100; i++) {
			res += count[i];
			sb.append(res);
			sb.append(" ");
		}

		System.out.println(sb);

	}
}
