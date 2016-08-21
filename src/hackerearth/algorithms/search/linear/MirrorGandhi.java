package hackerearth.algorithms.search.linear;

import java.util.Scanner;

public class MirrorGandhi {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int t = 0; t < T; t++) {
			String num = sc.next();
			solve(num);
		}
	}

	private static void solve(String num) {
		if (!isMirrorable(num)) {
			System.out.println("NO");
			return;
		}
		String rev = new StringBuilder(num).reverse().toString();
		if (rev.equals(num)) {
			System.out.println("YES");
		} else {
			System.out.println("NO");
		}

	}

	private static boolean isMirrorable(String num) {
		for (char c : num.toCharArray()) {
			if (c == '0' || c == '1' || c == '8') {
				continue;
			} else {
				return false;
			}

		}
		return true;
	}

}
