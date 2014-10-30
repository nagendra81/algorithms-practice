package hackerrank.algorithms.warmup;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class CutSticks {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		int[] A = new int[N];
		String[] line = br.readLine().split(" ");

		for (int i = 0; i < N; i++) {
			int a = Integer.parseInt(line[i]);
			A[i] = a;
		}

		Arrays.sort(A);

		int res = 0;
		for (int i = 0; i < N; i++) {
			if (A[i] == 0)
				continue;
			res = 0;

			for (int j = i + 1; j < N; j++) {
				if (A[j] >= A[i]) {
					A[j] -= A[i];
					res++;

				}
			}
			
			A[i] = 0;
			res++;
			System.out.println(res);

		}

	}
}
