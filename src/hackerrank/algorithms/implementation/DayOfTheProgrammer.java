package hackerrank.algorithms.implementation;

import java.util.Scanner;

public class DayOfTheProgrammer {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int year = sc.nextInt();

		boolean isLeap = false;
		if (year < 1918) {
			isLeap = (year % 4) == 0;
		} else if (year > 1918) {
			isLeap = (year % 400) == 0 || ((year % 4) == 0 && (year % 100 != 0));
		}

		if (year == 1918) {
			System.out.println("28.09.1918");
			return;
		}

		int dd = 13;

		if (isLeap) {
			dd--;
		}

		System.out.println(String.format("%d.09.%d", dd, year));

	}

}
