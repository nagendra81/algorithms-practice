package thinkingRecursively.chap4;

public class DigitSum {
	public static void main(String[] args) {
		int num = 987654;
		int sum = digitSum(num);
		System.out.println(sum);
	}

	private static int digitSum(int num) {
		if (num <= 9) {
			return num;
		}
		return (num % 10) + digitSum(num / 10);
	}
}
