package hackerrank.algorithms.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class PriyankaToys {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine().trim());

		int[] toys = new int[N];
		String[] line = br.readLine().split(" ");
		for (int i = 0; i < N; i++) {
			toys[i] = Integer.parseInt(line[i].trim());
		}

		Arrays.sort(toys);

		int cnt = 1;
		int wt = toys[0];

		for (int i = 1; i < N; i++) {
			if ((toys[i] - wt) <= 4)
				continue;
			cnt++;
			wt = toys[i];
		}
		System.out.println(cnt);

	}

}
