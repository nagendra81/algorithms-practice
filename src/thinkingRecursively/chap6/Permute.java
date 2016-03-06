package thinkingRecursively.chap6;

import java.util.Arrays;

public class Permute {
	
	private static int cnt = 1;

	public static void main(String[] args) {
		String[] vals = { "A", "B", "B", "C" };
		// Integer[] vals = { 1,2,3};
		// permute(vals, 0, vals.length);
		permute("", "ABC");
	}

	static void permute(Object[] vals, int s, int e) {
		if (s == e) {
			System.out.println("e: " + Arrays.toString(vals));
		} else {
			for (int p = s; p < e; p++) {
				swap(vals, p, s);
				permute(vals, s + 1, e);
				swap(vals, p, s);
			}
		}
	}

	private static void permute(String prefix, String word) {
		if (word.length() == 0) {
			//System.out.println(prefix);
		} else {
			for (int i = 0; i < word.length(); i++) {
				char c = word.charAt(i);
				System.out.println(prefix + c + ", " + cnt);
				String rest = word.substring(0, i) + word.substring(i + 1);
				cnt++;
				permute(prefix + c, rest);
			}
		}

	}

	private static void swap(Object[] vals, int p, int s) {
		Object t = vals[p];
		vals[p] = vals[s];
		vals[s] = t;
	}
}
