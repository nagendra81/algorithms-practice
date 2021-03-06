package hackerrank.algorithms.sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class CountingSort1 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int[] values = new int[N];
		String[] line = br.readLine().split(" ");

		for (int i = 0; i < N; i++) {
			values[i] = Integer.parseInt(line[i]);
		}

		int[] count = new int[100];
		Arrays.fill(count, 0);

		for (int i = 0; i < values.length; i++) {
			count[values[i]]++;
		}

		StringBuilder result = new StringBuilder();
		for (int i = 0; i < count.length; i++) {
			result.append(count[i]);
			result.append(" ");

		}
		System.out.println(result.toString().trim());
	}

}
