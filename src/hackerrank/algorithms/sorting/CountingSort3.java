package hackerrank.algorithms.sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class CountingSort3 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine().trim());

		int[] arr = new int[N];

		for (int i = 0; i < N; i++) {
			String[] line = br.readLine().split(" ");
			arr[i] = Integer.parseInt(line[0]);
		}

		int[] count = new int[100];
		Arrays.fill(count, 0);

		for (int i = 0; i < N; i++) {
			count[arr[i]]++;
		}

		// System.out.println(Arrays.toString(count));

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
