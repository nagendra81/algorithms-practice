package thinkingRecursively.chap6;

public class PowerSets {

	public static void main(String[] args) {
		String s = "ABC";
		generate("", s);
	}

	public static void generate(String prefix, String word) {
		if (word.length() == 0) {
			System.out.println(prefix);
			return;
		}
		generate(prefix, word.substring(1));
		generate(prefix + word.charAt(0), word.substring(1));
	}
}