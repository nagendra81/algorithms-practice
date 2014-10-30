package hackerrank.algorithms.sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SherlockAndWatson {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] tmp = br.readLine().split(" ");

		int N = Integer.parseInt(tmp[0]);
		int K = Integer.parseInt(tmp[1]);
		int Q = Integer.parseInt(tmp[2]);

		tmp = br.readLine().split(" ");

		int[] A = new int[N];

		for (int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(tmp[i]);
		}
		
		K  %= N;

		for (int i = 0; i < Q; i++) {
			int x = Integer.parseInt(br.readLine());

			System.out.println(A[(N - K + x) % N]);

		}

	}

}
