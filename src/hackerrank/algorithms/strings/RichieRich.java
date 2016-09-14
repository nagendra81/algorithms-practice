package hackerrank.algorithms.strings;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class RichieRich {

	public static void main(String[] args) throws FileNotFoundException {
		Scanner sc = new Scanner(System.in);
		// Scanner sc = new Scanner(new
		// File("C:\\users\\nagend~1\\Desktop\\rch8.txt"));
		int N = sc.nextInt();
		int K = sc.nextInt();
		String num = sc.next();

		// String res = solve(num.toCharArray(), 0, N - 1, N, K);
		String res = solve(num.toCharArray(), N, K);
		System.out.println(res);

	}

	private static String solve(char[] num, int N, int k) {
		int lo = 0;
		int hi = N - 1;
		int diffCount = getDiffCount(num, lo, hi);
		// System.out.println("DC : " + diffCount);

		while (lo < hi && k > 0) {
			// System.out.println(String.valueOf(num) + " dc : " + diffCount +
			// ", k = " + k);
			if (num[lo] == '9' && num[hi] == '9') {
				lo++;
				hi--;
				continue;
			} else if (num[lo] == '9' || num[hi] == '9') {
				num[lo++] = num[hi--] = '9';
				k--;
				diffCount--;
			} else if (num[lo] == num[hi]) {
				if (k >= 2 && diffCount - 1 <= k - 2) {
					num[lo++] = num[hi--] = '9';
					k -= 2;
				} else {
					lo++;
					hi--;
				}
			} else {
				if (diffCount > k) {
					return "-1";
				} else if (diffCount - 1 <= k - 2) {
					num[lo++] = num[hi--] = '9';
					k -= 2;
					diffCount--;
				} else if (diffCount - 1 <= k - 1) {
					num[lo] = max(num[lo], num[hi]);
					num[hi] = max(num[lo], num[hi]);
					lo++;
					hi--;
					k--;
					diffCount--;
				}
			}
		}

		if (lo == hi && k > 0) {
			num[lo] = num[hi] = '9';
			return String.valueOf(num);
		} else if (k == 0 || diffCount == 0) {
			return String.valueOf(num);
		} else {
			return "-1";
		}

	}

	private static int getDiffCount(char[] num, int lo, int hi) {
		int cnt = 0;
		while (lo < hi) {
			if (num[lo++] != num[hi--])
				cnt++;
		}
		return cnt;
	}

	static boolean isOdd(int N) {
		return (N & 1) == 1;
	}

	private static char max(char lc, char hc) {
		return hc > lc ? hc : lc;
	}

}
