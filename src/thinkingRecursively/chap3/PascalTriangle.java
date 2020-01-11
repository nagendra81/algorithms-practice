package thinkingRecursively.chap3;

public class PascalTriangle {

	public static void main(String[] args) {
		int res = compute(5, 2);
		System.out.println(res);
	}

	static int compute(int n, int k) {
		if (k == 0 || n == k) {
			return 1;
		}
		return compute(n - 1, k) + compute(n - 1, k - 1);
	}

}
