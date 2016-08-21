package hackerrank.algorithms.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class CuttingBoards {

	private static final long MOD = 1000_000_007;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine().trim());

		for (int t = 0; t < T; t++) {
			PriorityQueue<Long> cy = new PriorityQueue<>(Collections.reverseOrder());
			PriorityQueue<Long> cx = new PriorityQueue<>(Collections.reverseOrder());

			String[] line = br.readLine().split(" ");
			int M = Integer.parseInt(line[0].trim());
			int N = Integer.parseInt(line[1].trim());

			line = br.readLine().split(" ");
			for (int m = 0; m < M - 1; m++) {
				cy.add(Long.parseLong(line[m].trim()));
			}

			line = br.readLine().split(" ");
			for (int n = 0; n < N - 1; n++) {
				cx.add(Long.parseLong(line[n].trim()));
			}

			solve(cy, cx);
		}
	}

	private static void solve(PriorityQueue<Long> cy, PriorityQueue<Long> cx) {
		long res = 0;

		int segx = 1;
		int segy = 1;
		while (cx.size() + cy.size() > 0) {
			if (cx.size() == 0) {
				res = res + ((cy.remove() % MOD) * (segx % MOD));
				segy++;
			} else if (cy.size() == 0) {
				res = res + ((cx.remove() % MOD) * (segy % MOD));
				segx++;

			} else if (cy.peek() > cx.peek()) {
				res = res + ((cy.remove() % MOD) * (segx % MOD));
				segy++;
			} else if (cx.peek() > cy.peek()) {
				res = res + ((cx.remove() % MOD) * (segy % MOD));
				segx++;
			} else if (segy > segx) {
				res = res + ((cy.remove() % MOD) * (segx % MOD));
				segy++;
			} else {
				res = res + ((cx.remove() % MOD) * (segy % MOD));
				segx++;
			}
			res = res % MOD;
		}
		System.out.println(res);
	}
}
