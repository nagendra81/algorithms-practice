package thinkingRecursively.chap4;

public class PrintIntegerNegative {
	public static void main(String[] args) {
		int num = -129876;
		printInteger(num);
	}

	static void printInteger(int num) {
		if (num < 0) {
			System.out.println("-");
			printInteger(-num);
		} else if (num <= 9) {
			System.out.println(num);
		} else {
			printInteger(num / 10);
			System.out.println(num % 10);
		}
	}

	// private static void printInteger(int num) {
	// if (num < 0) {
	// System.out.print("-");
	// printInteger(num * -1);
	// } else if (num < 10 && num >= 0) {
	// System.out.print((char) ('0' + num));
	// } else {
	// printInteger(num / 10);
	// System.out.print((char) ('0' + num % 10));
	// }
	// }

}
