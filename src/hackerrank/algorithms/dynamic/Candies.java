package hackerrank.algorithms.dynamic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Candies {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		int[] kids = new int[N];

		int minValue = Integer.MAX_VALUE;
		int minPos = -1;

		for (int i = 0; i < N; i++) {
			kids[i] = Integer.parseInt(br.readLine());
			if (kids[i] < minValue) {
				minPos = i;
				minValue = kids[i];
			}
		}

		int[] opt = new int[N];
		opt[minPos] = 1;
		for (int i = minPos - 1; i >= 0; i--) {

			if (kids[i] > kids[i + 1])
				opt[i] = opt[i + 1] + 1;
			else
				opt[i] = 1;

		}

		for (int i = minPos + 1; i < N; i++) {
			if (kids[i] > kids[i - 1]) {
				opt[i] = opt[i - 1] + 1;
			} else {
				opt[i] = 1;
			}
		}

	//	System.out.println(Arrays.toString(opt));

		int sum = 0;
		for (int i = 0; i < N; i++) {
			sum += opt[i];
		}
		System.out.println(sum);

	}
}
