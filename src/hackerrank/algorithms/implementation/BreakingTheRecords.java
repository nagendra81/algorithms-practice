package hackerrank.algorithms.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BreakingTheRecords {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine().trim());
		String[] line = br.readLine().split(" ");

		int[] scores = new int[N];

		for (int i = 0; i < N; i++) {
			scores[i] = Integer.parseInt(line[i]);
		}

		int currMax = scores[0];
		int currMin = scores[0];
		int best = 0;
		int worst = 0;
		for (int i = 1; i < scores.length; i++) {
			if (scores[i] < currMin) {
				worst++;
				currMin = scores[i];
			}
			if (scores[i] > currMax) {
				best++;
				currMax = scores[i];
			}
		}
		System.out.println(best + " " + worst);
	}

}
