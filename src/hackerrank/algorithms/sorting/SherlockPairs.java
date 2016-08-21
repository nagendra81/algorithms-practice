package hackerrank.algorithms.sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class SherlockPairs {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		for (int t = 0; t < T; t++) {
			int N = Integer.parseInt(br.readLine().trim());
			String[] line = br.readLine().split(" ");

			Map<Integer, Long> freqMap = new HashMap<>();

			for (int i = 0; i < N; i++) {
				int k = Integer.parseInt(line[i]);
				Long v = freqMap.get(k);
				if (v == null) {
					v = 0L;
				}
				v++;
				freqMap.put(k, v);
			}

			// System.out.println(freqMap);
			long res = 0L;
			for (long v : freqMap.values()) {
				res += v * (v - 1);
			}
			System.out.println(res);
		}

	}
}
