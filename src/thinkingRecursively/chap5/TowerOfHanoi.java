package thinkingRecursively.chap5;

public class TowerOfHanoi {
	static String moves = "Moved tower #%d from %s -> %s\n";

	public static void main(String[] args) {
		moveTowers(2, "A", "B", "C");
	}

	private static void moveTowers(int n, String start, String end, String tmp) {
		if (n > 0) {
			moveTowers(n - 1, start, tmp, end);
			System.out.printf(moves, n, start, end);
			moveTowers(n - 1, tmp, end, start);
		}
	}
}
