package thinkingRecursively.chap6;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;

public class TelephoneNumbers {
	private static final HashSet<String> dictWords = new HashSet<>();
	static {
		try {

			BufferedReader br = new BufferedReader(new FileReader(
					"G:/work/Git_Repos/github/algorithms-practice/src/thinkingRecursively/dat/enable1.txt"));
			String s;
			while ((s = br.readLine()) != null) {
				dictWords.add(s);
			}

			System.out.println(dictWords.size());
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void main(String[] args) {
		// 0 1 2 3 4 5 6 7 8 9
		String[] letters = { "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };
		String in = "3948";

		generate(letters, "", in);

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
