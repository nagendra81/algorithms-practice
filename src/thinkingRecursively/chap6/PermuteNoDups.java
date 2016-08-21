package thinkingRecursively.chap6;

import java.util.Scanner;

public class PermuteNoDups {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (true) {
			String word = sc.next();
			if (word.trim().length() == 0)
				break;
			System.out.println(word.trim().length());
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

	private static String removeChar(String word, char c, int i) {
		StringBuilder sb = new StringBuilder();

		for (int j = 0; j < i; j++) {
			sb.append(word.charAt(j));
		}

		for (int j = i; j < word.length(); j++) {
			if (word.charAt(j) != c) {
				sb.append(word.charAt(j));
			}
		}
		return sb.toString();
	}

}
