package thinkingRecursively.chap5;

public class NumTowersOfHanoi {
	static String moves = "Move tower #%d from %s -> %s\n";

	public static void main(String[] args) {
		int cnt = moveTowers(4, "A", "B", "C");
		System.out.println(cnt);
	}

	private static int moveTowers(int n, String start, String end, String tmp) {
		if (n == 1) {
			return 1;
		}
		return moveTowers(n - 1, start, tmp, end) + 1 + moveTowers(n - 1, tmp, end, start);
	}

}
