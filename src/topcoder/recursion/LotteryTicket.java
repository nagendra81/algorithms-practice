package topcoder.recursion;

import java.util.Arrays;

// SRM 466
public class LotteryTicket {

	static final String YES = "POSSIBLE";
	static final String NO = "IMPOSSIBLE";

	public String buy(int price, int b1, int b2, int b3, int b4) {
		int[] notes = new int[] { b1, b2, b3, b4 };

		if (buy(price, notes, 0)) {
			return YES;
		} else {
			return NO;
		}
	}

	private boolean buy(int price, int[] notes, int sum) {
		boolean canBuy = false;
		for (int i = 0; i < notes.length; i++) {
			canBuy = buy(price, subArray(notes, i + 1), sum + notes[i]);
			if(canBuy || (sum + notes[i] == price)) {
				return true;
			} else {
				canBuy = false;
			}
		}
		return canBuy;

	}

	private int[] subArray(int[] notes, int i) {
		if (i == notes.length) {
			return new int[] {};
		}
		int[] ret = Arrays.copyOfRange(notes, i, notes.length);
		return ret;
	}

	public static void main(String[] args) {
		LotteryTicket lt = new LotteryTicket();
		String r = lt.buy(75, 10, 5, 10, 50);
		System.out.println(r);

	}

}
