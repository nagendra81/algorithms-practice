package weekofcode21;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class LuckBalance {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] line = br.readLine().split(" ");
		int N = Integer.parseInt(line[0]);
		int K = Integer.parseInt(line[1]);

		PriorityQueue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());
		long lb = 0;

		for (int i = 0; i < N; i++) {
			line = br.readLine().split(" ");
			int li = Integer.parseInt(line[0]);
			int ti = Integer.parseInt(line[1]);

			if (ti == 0) {
				lb += li;
			} else {
				q.add(li);
			}
		}

		for (int i = 0; i < K; i++) {
			if (!q.isEmpty()) {
				lb += q.poll();
			}
		}

		while (!q.isEmpty()) {
			lb -= q.poll();
		}

		System.out.println(lb);

	}

}
