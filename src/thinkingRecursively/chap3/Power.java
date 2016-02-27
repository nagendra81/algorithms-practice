package thinkingRecursively.chap3;

public class Power {

	private static long power(long n, long k) {
		if (k == 0)
			return 1;
		return n * power(n, k - 1);
	}

	public static void main(String[] args) {

		long res = power(8L, 3L);
		System.out.println(res);
	}
}
