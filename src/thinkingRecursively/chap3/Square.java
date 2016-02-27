package thinkingRecursively.chap3;

public class Square {

	private static int square(int n) {
		return square_rec(1, 1, n);
	}

	private static int square_rec(int c, int res, int n) {
		if (c == n)
			return res;
		return res + square_rec(c + 1, res + 2, n);

	}

	public static void main(String[] args) {
		int res = square(12);
		System.out.println(res);

	}
}
