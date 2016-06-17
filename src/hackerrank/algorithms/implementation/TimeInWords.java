package hackerrank.algorithms.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class TimeInWords {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int H = Integer.parseInt(br.readLine().trim());
		int M = Integer.parseInt(br.readLine().trim());

		Map<Integer, String> hourMap = new HashMap<>();
		Map<Integer, String> minuteMap = new HashMap<>();
		setupMaps(hourMap, minuteMap);

		StringBuilder sb = new StringBuilder();
		if (M == 0) {
			sb.append(hourMap.get(H) + " " + minuteMap.get(M));
		} else if (M == 15 || M == 30) {
			sb.append(minuteMap.get(M) + " past " + hourMap.get(H));
		} else if (M == 45) {
			sb.append(minuteMap.get(M) + " to " + hourMap.get(H + 1));
		} else if (M < 30) {
			sb.append(minuteMap.get(M) + " minutes past " + hourMap.get(H));
		} else if (M > 30) {
			sb.append(minuteMap.get(M) + " minutes to " + hourMap.get(H + 1));
		}
		System.out.println(sb.toString());

	}

	private static void setupMaps(Map<Integer, String> hourMap, Map<Integer, String> minuteMap) {
		hourMap.put(1, "one");
		hourMap.put(2, "two");
		hourMap.put(3, "three");
		hourMap.put(4, "four");
		hourMap.put(5, "five");
		hourMap.put(6, "six");
		hourMap.put(7, "seven");
		hourMap.put(8, "eight");
		hourMap.put(9, "nine");
		hourMap.put(10, "ten");
		hourMap.put(11, "eleven");
		hourMap.put(12, "twelve");

		minuteMap.put(0, "o' clock");
		for (int i = 1; i <= 12; i++) {
			minuteMap.put(i, hourMap.get(i));
		}

		minuteMap.put(13, "thirteen");
		minuteMap.put(14, "fourteen");
		minuteMap.put(15, "quarter");
		minuteMap.put(16, "sixteen");
		minuteMap.put(17, "seventeen");
		minuteMap.put(18, "eighteen");
		minuteMap.put(19, "nineteen");

		minuteMap.put(20, "twenty");
		for (int i = 21; i <= 29; i++) {
			minuteMap.put(i, minuteMap.get(20) + " " + minuteMap.get(i - 20));
		}
		minuteMap.put(30, "half");
		for (int i = 31; i < 60; i++) {
			minuteMap.put(i, minuteMap.get(60 - i));
		}
	}
}
