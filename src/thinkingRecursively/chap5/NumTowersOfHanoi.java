package thinkingRecursively.chap5;

public class NumTowersOfHanoi {
	static String moves = "Move tower #%d from %s -> %s\n";

	public static void main(String[] args) {
		int cnt = moveTowers(4, "A", "B", "C");
		System.out.println(cnt);
	}

	private static int moveTowers(int n, String start, String end, String tmp) {
		int res = 0;
		if (n > 0) {
			res += moveTowers(n - 1, start, tmp, end);
			System.out.printf(moves, n, start, end);
			res++;
			res += moveTowers(n - 1, tmp, end, start);
		}
		return res;
	}

}
