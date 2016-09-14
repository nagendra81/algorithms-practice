package hackerrank.algorithms.strings;

import java.util.Scanner;

public class CamelCase {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String line = sc.next();

		int cnt = 0;

		for (int i = 1; i < line.length(); i++) {
			if (Character.isUpperCase(line.charAt(i))) {
				cnt++;
			}
		}
		System.out.println(cnt + 1);

	}
}
