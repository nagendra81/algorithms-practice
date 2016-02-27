package thinkingRecursively.chap3;

public class GCD {

	private static int gcd(int a, int b) {
		if (b == 0)
			return a;
		return gcd(b, a % b);
	}

	public static void main(String[] args) {
		int res = gcd(28, 63);
		System.out.println(res);
	}

}
