package topcoder.recursion;

public class ListeningIn {
	public String probableMatch(String typed, String phrase) {
		String match = probableMatch("", typed, phrase, 0, 0);
		return match;
	}

	private String probableMatch(String word, String typed, String phrase, int ti, int pi) {
		if (ti == typed.length() && pi == phrase.length()) {
			return word;
		} else if (pi == phrase.length()) {
			return "UNMATCHED";
		} else if (ti == typed.length()) {
			return word + phrase.substring(pi);
		} else if (typed.charAt(ti) == phrase.charAt(pi)) {
			return probableMatch(word, typed, phrase, ti + 1, pi + 1);
		} else {
			return probableMatch(word + phrase.charAt(pi), typed, phrase, ti, pi + 1);
		}
	}

	public static void main(String[] args) {
		ListeningIn lin = new ListeningIn();
		String match = lin.probableMatch ("back  to base", "back to base");

		System.out.println(match);

	}
}
