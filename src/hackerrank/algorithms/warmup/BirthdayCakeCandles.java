package hackerrank.algorithms.warmup;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BirthdayCakeCandles {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		String[] line = br.readLine().split(" ");

		int[] height = new int[N];
		for (int i = 0; i < N; i++) {
			height[i] = Integer.parseInt(line[i]);
		}

		int max = max(height);
		int res = count(max, height);
		System.out.println(res);

	}

	private static int count(int max, int[] height) {
		int res = 0;

		for (int h : height) {
			if (h == max) {
				res++;
			}
		}
		return res;
	}

	private static int max(int[] height) {
		int max = -1;

		for (int i = 0; i < height.length; i++) {
			if (height[i] > max) {
				max = height[i];
			}
		}

		return max;
	}
}
