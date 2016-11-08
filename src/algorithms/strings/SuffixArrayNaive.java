package algorithms.strings;

import java.util.Arrays;

public class SuffixArrayNaive {

	private String text;
	private int[] suffix_array;

	public int[] build(String word) {
		if (word == null || word.isEmpty()) {
			return new int[] {};
		}

		this.text = word;

		int N = word.length();
		Suffix[] suffs = new Suffix[N];

		for (int i = 0; i < N; i++) {
			suffs[i] = new Suffix(i, word.substring(i));
		}

		Arrays.sort(suffs);

		int[] suffArray = new int[N];

		int i = 0;
		for (Suffix su : suffs) {
			suffArray[i++] = su.index;
		}

		this.suffix_array = Arrays.copyOf(suffArray, suffArray.length);

		return suffArray;
	}

	public boolean search(String pat) {
		int lo = 0;
		int hi = suffix_array.length - 1;

		while (lo <= hi) {
			int mid = lo + (hi - lo) / 2;

			int res = compare(pat, text.substring(suffix_array[mid]));
			if (res == 0) {
				return true;
			} else if (res < 0) {
				lo = mid + 1;
			} else {
				hi = mid - 1;
			}
		}

		return false;

	}

	private int compare(String pat, String substring) {
		int len = Math.min(pat.length(), substring.length());

		for (int i = 0; i < len; i++) {
			if (substring.charAt(i) < pat.charAt(i)) {
				return -1;
			} else if (substring.charAt(i) > pat.charAt(i)) {
				return 1;
			}
		}

		if (substring.length() > pat.length()) {
			return 0;
		} else {
			return -1;
		}

	}

	public static void main(String[] args) {
		SuffixArrayNaive san = new SuffixArrayNaive();
		int[] suffArray = san.build("blogger");
		System.out.println(Arrays.toString(suffArray));
		System.out.println(san.search("ge"));

	}

	static class Suffix implements Comparable<Suffix> {
		private final int index;
		private final String suffix;

		Suffix(int index, String suffix) {
			if (index < 0 || suffix == null || suffix.isEmpty()) {
				throw new IllegalArgumentException();
			}
			this.index = index;
			this.suffix = suffix;
		}

		@Override
		public int compareTo(Suffix that) {
			if (that == null) {
				return -1;
			}

			return this.suffix.compareTo(that.suffix);
		}

	}
}
