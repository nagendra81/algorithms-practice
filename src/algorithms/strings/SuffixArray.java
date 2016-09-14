package algorithms.strings;

import java.util.Arrays;

public class SuffixArray {

	String word;
	int R;
	int C;
	int[][] P;

	SuffixArray(String word) {
		this.word = word;
		this.R = (int) Math.ceil(Math.log(word.length()) / Math.log(2));
		this.C = word.length();

		P = new int[R + 1][C];
		for (int[] p : P) {
			Arrays.fill(p, 0);
		}
		build();

	}

	void print() {

		for (int[] p : P) {
			System.out.println(Arrays.toString(p));
		}

	}

	void build() {

		SuffixPair[] sp_arr = new SuffixPair[C];

		for (int i = 0; i < C; i++) {
			P[0][i] = word.charAt(i) - 'a';
		}

		int cnt = 1;
		for (int k = 1; cnt < C; k++, cnt <<= 1) {

			for (int i = 0; i < C; i++) {
				sp_arr[i] = new SuffixPair(P[k - 1][i], i + cnt < C ? P[k - 1][i + cnt] : -1, i);
			}

			Arrays.sort(sp_arr);

			for (int i = 0; i < C; i++) {
				P[k][sp_arr[i].idx] = i > 0 && sp_arr[i].curr == sp_arr[i - 1].curr
						&& sp_arr[i].next == sp_arr[i - 1].next ? P[k][sp_arr[i - 1].idx] : i;
			}
		}

	}

	static class SuffixPair implements Comparable<SuffixPair> {

		private final int curr;
		private final int next;
		private final int idx;

		SuffixPair(int curr, int next, int idx) {
			this.curr = curr;
			this.next = next;
			this.idx = idx;
		}

		@Override
		public int compareTo(SuffixPair that) {
			if (this.curr == that.curr) {
				return Integer.compare(this.next, that.next);
			} else {
				return Integer.compare(this.curr, that.curr);
			}
		}

	}

	public static void main(String[] args) {
		String word = "blogger";
		SuffixArray sa = new SuffixArray(word);
		sa.print();
	}

}
