package hackerrank.algorithms.warmup;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PlusMinus {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine().trim());

		double pos_sum = 0;
		double neg_sum = 0;
		double zero_sum = 0;

		String[] line = br.readLine().split(" ");
		for (int i = 0; i < N; i++) {
			int k = Integer.parseInt(line[i]);
			if (k > 0) {
				pos_sum++;
			} else if (k < 0) {
				neg_sum++;
			} else {
				zero_sum++;
			}
		}
		System.out.printf("%.6f\n", pos_sum / N);
		System.out.printf("%.6f\n", neg_sum / N);
		System.out.printf("%.6f\n", zero_sum / N);

	}

}
