package hackerrank.algorithms.strings;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class SherlockValidStrings {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String line = br.readLine().trim();

		solve(line.toCharArray());

	}

	private static void solve(char[] line) {
		Map<Character, Integer> freqMap = new HashMap<>();

		for (int i = 0; i < line.length; i++) {
			Integer val = freqMap.get(line[i]);
			if (val == null) {
				val = 0;
			}
			val++;
			freqMap.put(line[i], val);
		}
		int majority = findMajority(freqMap);
		// System.out.println("Majority: " + majority);
		if (majority == -1) {
			System.out.println("NO");
			return;
		}

		int near = 0;
		int away = 0;
		for (int val : freqMap.values()) {
			if (val == majority) {
				continue;
			}
			if (val - 1 == majority) {
				near++;
			} else {
				away++;
			}
		}
		if (away > 1) {
			System.out.println("NO");
			return;
		}
		if (near <= 1) {
			System.out.println("YES");
		} else {
			System.out.println("NO");
		}

	}

	private static int findMajority(Map<Character, Integer> freqMap) {
		Integer[] values = freqMap.values().toArray(new Integer[0]);

		int cand = values[0];
		int cnt = 0;

		for (int i : values) {
			if (cand == i) {
				cnt++;
			} else {
				cnt--;
			}
			if (cnt == 0) {
				cand = i;
				cnt = 1;
			}
		}

		cnt = 0;
		for (int i : values) {
			if (cand == i) {
				cnt++;
			}
		}

		if (cnt < (values.length + 1) / 2) {
			return -1;
		} else {
			return cand;
		}
	}

}
