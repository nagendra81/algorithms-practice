package hackerearth.datastructures.hashing;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class NeedleHayStack {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int t = 0; t < T; t++) {
			String pattern = sc.next();
			String text = sc.next();

			solve(text, pattern);
		}
	}

	private static void solve(String text, String pattern) {
		int plen = pattern.length();
		Map<Character, Integer> freqMap = new HashMap<>();
		Map<Character, Integer> patternMap = new HashMap<>();

		for (int i = 0; i < plen; i++) {
			add(freqMap, text.charAt(i));
			add(patternMap, pattern.charAt(i));
		}

		// System.out.println(freqMap);
		for (int i = 1; i < text.length() - plen + 1; i++) {
			// String subText = text.substring(i, i + plen);

			if (isMatch(patternMap, freqMap, text, pattern, i)) {
				System.out.println("YES");
				return;
			}
		}
		System.out.println("NO");
	}

	private static void add(Map<Character, Integer> freqMap, char c) {
		Integer cv = freqMap.get(c);
		if (cv == null) {
			cv = 0;
		}
		cv++;
		freqMap.put(c, cv);
	}

	private static void remove(Map<Character, Integer> freqMap, char c) {
		Integer cv = freqMap.get(c);
		if (cv == null) {
			cv = 0;
		}
		cv--;
		if (cv <= 0) {
			freqMap.remove(c);
		} else {
			freqMap.put(c, cv);
		}
	}

	private static boolean isMatch(Map<Character, Integer> patternMap, Map<Character, Integer> freqMap, String text,
			String pattern, int pos) {
		if (pos - 1 >= 0) {
			char c = text.charAt(pos - 1);
			remove(freqMap, c);
		}

		if (pos + pattern.length() <= text.length()) {
			char c = text.charAt(pos + pattern.length() - 1);
			add(freqMap, c);
		}
		// System.out.println(freqMap);
		return patternMap.equals(freqMap);

	}

}
