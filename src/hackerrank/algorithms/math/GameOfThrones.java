package hackerrank.algorithms.math;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class GameOfThrones {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		String line = in.nextLine();

		int n = line.length();

		Map<Character, Integer> freqMap = new HashMap<Character, Integer>();

		char[] charArr = line.toCharArray();

		for (int i = 0; i < n; i++) {
			Character c = charArr[i];
			Integer f = freqMap.get(c);
			if (f == null)
				f = 0;
			freqMap.put(c, f + 1);
		}

		int oddCount = 0;
		for (Integer f : freqMap.values()) {
			if ((f & 1) == 1) // odd
				oddCount++;
		}
		if ((n & 1) == 0 && oddCount > 0) {
			System.out.println("NO");
		} else if ((n & 1) == 1 && oddCount > 1) {
			System.out.println("NO");
		} else
			System.out.println("YES");

		return;

	}
}
