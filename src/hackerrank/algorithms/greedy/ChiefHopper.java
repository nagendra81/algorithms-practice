package hackerrank.algorithms.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ChiefHopper {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		long[] arr = new long[N];

		String[] line = br.readLine().split(" ");
		for (int i = 0; i < N; i++) {
			arr[i] = Long.parseLong(line[i]);
		}

		long res = 0;
		for (int i = N - 1; i >= 0; i--) {
			res = (arr[i] + res + 1) / 2;
		}
		System.out.println(res);
	}
}
