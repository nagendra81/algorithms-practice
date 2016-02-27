package thinkingRecursively.chap4;

public class DigitalSum {
	public static void main(String[] args) {
		int num = 987654;
		int sum = digitalSum(num);
		System.out.println(sum);
	}

	private static int digitalSum(int num) {
		if(num < 10) {
			return num;
		} else {
			return digitalSum(num/10) + (num%10);
		}
	}
}
