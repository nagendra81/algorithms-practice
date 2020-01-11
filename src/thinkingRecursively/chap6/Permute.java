package thinkingRecursively.chap6;

import java.util.Scanner;

public class Permute {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (true) {
			String word = sc.next();
			permute(word);
		}
	}

	static void permute(String word) {
		permute("", word);
	}

	private static void permute(String prefix, String word) {
		if (word.length() == 0) {
			System.out.println(prefix);
		} else {
			for (int i = 0; i < word.length(); i++) {
				char c = word.charAt(i);
				String rest = word.substring(0, i) + word.substring(i + 1);
				permute(prefix + c, rest);
			}
		}
	}
}
