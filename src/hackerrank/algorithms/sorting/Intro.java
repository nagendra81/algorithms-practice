package hackerrank.algorithms.sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Intro {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int V = Integer.parseInt(br.readLine().trim());
		int N = Integer.parseInt(br.readLine().trim());

		String[] line = br.readLine().split(" ");
		for (int i = 0; i < N; i++) {
			if (Integer.parseInt(line[i]) == V) {
				System.out.println(i);
				return;
			}
		}
	}

}
