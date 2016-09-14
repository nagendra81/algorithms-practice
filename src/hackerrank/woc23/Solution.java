package hackerrank.woc23;

import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int Q = sc.nextInt();

		for (int q = 1; q <= Q; q++) {
			int N = sc.nextInt();

			if ((N & 1) == 1) {
				System.out.println("No");
			} else {
				System.out.println("Yes");
			}
		}
	}

}
