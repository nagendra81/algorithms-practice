package thinkingRecursively.chap6;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashSet;

public class TelephoneNumbers {
	private static final HashSet<String> dictWords = new HashSet<>();
	private static final String[] LETTERS = { "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };
	static {
		try {

			BufferedReader br = new BufferedReader(new FileReader(
					"G:/work/Git_Repos/github/algorithms-practice/src/thinkingRecursively/dat/enable1.txt"));
			String s;
			while ((s = br.readLine()) != null) {
				dictWords.add(s);
			}

			System.out.println(dictWords.size());
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void main(String[] args) {
		generate("", "43556");
	}

	static void generate(String prefix, String phoneNum) {
		if (phoneNum.length() == 0) {
			if (dictWords.contains(prefix)) {
				System.out.println(prefix);
			}
		} else {
			int num = phoneNum.charAt(0) - '0';
			String letters = LETTERS[num];
			for (char let : letters.toCharArray()) {
				generate(prefix + let, phoneNum.substring(1));
			}
		}

	}

	private static void generate(String[] letters, String prefix, String input) {
		if (input.length() == 0) {
			// System.out.println(prefix);
			if (dictWords.contains(prefix))
				System.out.println(prefix);
		} else {
			String keys = letters[input.charAt(0) - '0'];
			for (int k = 0; k < keys.length(); k++) {
				generate(letters, prefix + keys.charAt(k), input.substring(1));
			}
		}

	}

}
