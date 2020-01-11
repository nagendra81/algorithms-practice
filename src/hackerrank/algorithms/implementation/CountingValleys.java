
package hackerrank.algorithms.implementation;

import java.util.Scanner;

public class CountingValleys {
	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			int n = sc.nextInt();
			sc.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

			String path = sc.nextLine().trim();

			int res = 0, prev = 0, curr = 0;
			for (char c : path.toCharArray()) {
				if (c == 'D') {
					prev = curr;
					curr--;
				} else if (c == 'U') {
					prev = curr;
					curr++;
				}
				if (prev == 0 && curr == -1) {
					res++;
				}
			}
			System.out.println(res);

		}
	}

}
