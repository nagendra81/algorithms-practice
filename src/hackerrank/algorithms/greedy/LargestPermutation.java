package hackerrank.algorithms.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LargestPermutation {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] line = br.readLine().split(" ");
		int N = Integer.parseInt(line[0].trim());
		int K = Integer.parseInt(line[1].trim());

		int[] entries = new int[N];
		int[] pos = new int[N + 1];

		line = br.readLine().split(" ");
		for (int i = 0; i < N; i++) {
			int t = Integer.parseInt(line[i].trim());
			entries[i] = t;
		}

		for (int i = 0; i < entries.length; i++) {
			pos[entries[i]] = i;
		}
		// System.out.println(Arrays.toString(pos));

		// System.out.println("N = " + N);
		for (int i = 0, k = 0; i < N && k < K; i++) {
			if (entries[i] != N - i) {
				int s = entries[i];
				entries[i] = N - i;
				int p = pos[N - i];

				pos[N - i] = i;
				entries[p] = s;
				pos[s] = p;
				/*
				 * for (int j = i + 1; j < N; j++) { if (entries[j] == N - i) {
				 * entries[j] = s; } }
				 */
				k++;
			}
		}
		StringBuilder sb = new StringBuilder();
		for (int e : entries) {
			sb.append(e);
			sb.append(" ");
		}
		System.out.println(sb.toString().trim());

	}

}
