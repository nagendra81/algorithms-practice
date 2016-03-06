package thinkingRecursively.chap6;

public class PowerSets {

	public static void main(String[] args) {
		String s = "ABC";
		generate("", s);
	}

	public static void generate(String prefix, String word) {
			for (int i = 0; i < word.length(); i++) {
				String newPrefix = prefix + word.charAt(i);
				generate(newPrefix, word.substring(i + 1));
				System.out.printf("{%s}\n", newPrefix);
			}
	}
}