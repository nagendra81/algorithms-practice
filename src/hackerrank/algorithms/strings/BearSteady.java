package hackerrank.algorithms.strings;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class BearSteady {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine().trim());
		String line = br.readLine().trim();
		solve(line.toCharArray(), N);
	}

	private static void solve(char[] arr, int N) {
		Map<Character, Integer> freqMap = new HashMap<>();

		N /= 4;

		for (char c : arr) {
			Integer v = freqMap.get(c);
			if (v == null)
				v = 0;
			freqMap.put(c, ++v);
		}

		System.out.println(freqMap);

	}

}
