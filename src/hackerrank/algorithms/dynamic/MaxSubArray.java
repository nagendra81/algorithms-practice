package hackerrank.algorithms.dynamic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MaxSubArray {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine().trim());

		for (int i = 0; i < T; i++) {
			int N = Integer.parseInt(br.readLine().trim());
			int arr[] = new int[N];

			String[] tmp = br.readLine().split(" ");
			for (int j = 0; j < tmp.length; j++)
				arr[j] = Integer.parseInt(tmp[j].trim());

			solve(arr);
		}
	}

	private static void solve(int[] vals) {

		boolean allNegative = true;
		int nc = 0;
		int min = Integer.MIN_VALUE;
		for (int v : vals) {
			if (v >= 0) {
				allNegative = false;
				nc += v;
			} else {
				min = Math.max(min, v);
			}
		}
		if (allNegative) {
			nc = min;
		}

		int curr_max = 0;
		int max_all = Integer.MIN_VALUE;

		for (int v : vals) {

			curr_max += v;
			if (curr_max < 0) {
				curr_max = 0;

			}

			max_all = Math.max(curr_max, max_all);

		}

		if (allNegative) {
			max_all = nc;
		}

		System.out.println(max_all + " " + nc);

	}

}
