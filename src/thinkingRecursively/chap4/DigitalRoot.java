package thinkingRecursively.chap4;

public class DigitalRoot {
	public static void main(String[] args) {
		int num = 1111;
		int root = digitRoot(num);
		System.out.println(root);
	}

	private static int digitRoot(int num) {
		if (num <= 9) {
			return num;
		}
		return digitRoot((num % 10) + (num / 10));
	}

}
