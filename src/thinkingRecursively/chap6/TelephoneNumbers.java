package thinkingRecursively.chap6;

public class TelephoneNumbers {
	public static void main(String[] args) {
		String[] letters = { "", "", "ABC", "DEF", "GHI", "JKL", "MNO", "PRS", "TUV", "WXY" };
		String in = "6378687";

		generate(letters, "", in);

	}

	private static void generate(String[] letters, String prefix, String input) {
		if (input.length() == 0) {
			System.out.println(prefix);
		} else {
			String keys = letters[input.charAt(0) - '0'];
			for (int k = 0; k < keys.length(); k++) {
				generate(letters, prefix + keys.charAt(k), input.substring(1));
			}
		}

	}

}
