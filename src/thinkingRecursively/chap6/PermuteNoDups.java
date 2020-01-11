package thinkingRecursively.chap6;

public class PermuteNoDups {
	public static void main(String[] args) {
		permute("ABB");
	}

	static void permute(String word) {
		// word = removeDups(word);
		permute("", word);
	}

	private static String removeDups(String word) {
		StringBuilder sb = new StringBuilder();
		for (char c : word.toCharArray()) {
			if (sb.toString().indexOf(c) == -1) {
				sb.append(c);
			}
		}
		return sb.toString();
	}

	private static void permute(String prefix, String word) {
		if (word.length() == 0) {
			System.out.println(prefix);
		} else {
			for (int i = 0; i < word.length(); i++) {
				char c = word.charAt(i);
				String rest = word.substring(0, i) + word.substring(i + 1);
				String prefix2 = prefix;
				if (prefix.indexOf(c) == -1) {
					prefix2 = prefix + c;
				}
				permute(prefix2, rest);
			}
		}
	}

}
