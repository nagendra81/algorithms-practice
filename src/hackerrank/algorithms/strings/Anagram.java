package hackerrank.algorithms.strings;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Anagram {

	private int solve(String line) {
		int len = line.length();
		if ((len & 1) == 1)
			return -1;
		Map<Character, Integer> fMap = new HashMap<Character, Integer>();
		Map<Character, Integer> sMap = new HashMap<Character, Integer>();

		for (int i = 0; i < len / 2; i++) {
			Character c = line.charAt(i);
			Integer f = fMap.get(c);
			if (f == null)
				f = 0;
			fMap.put(c, f + 1);
		}

		for (int i = len / 2; i < len; i++) {
			Character c = line.charAt(i);
			Integer f = sMap.get(c);
			if (f == null)
				f = 0;
			sMap.put(c, f + 1);
		}

		for (Map.Entry<Character, Integer> e : fMap.entrySet()) {
			Integer sc = sMap.get(e.getKey());
			if (sc == null)
				continue;
			Integer fc = fMap.get(e.getKey());
			int x = Math.min(fc, sc);

			fMap.put(e.getKey(), Math.abs(fc - x));
		}

		int res = 0;
		for (Integer v : fMap.values())
			res += v;

		return res;

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		int res;
		Anagram ana = new Anagram();
		for (int t = 0; t < T; t++) {
			res = ana.solve(br.readLine());
			System.out.println(res);
		}
	}

}
