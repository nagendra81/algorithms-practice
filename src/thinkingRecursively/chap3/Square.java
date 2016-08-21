package thinkingRecursively.chap3;

public class Square {

	private static int square(int n) {
		return OddSum(2 * n -1 );
	}

	
	private static int OddSum(int odd) {
		if(odd == 1)
			return odd;
		else
		return odd + OddSum(odd - 2);
	}

	public static void main(String[] args) {
		int res = square(12);
		System.out.println(res);

	}
}
