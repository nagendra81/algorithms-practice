package thinkingRecursively.chap4;

public class PrintInteger {
	public static void main(String[] args) {
		int num = 129876;
		printInteger(num);
	}

	private static void printInteger(int num) {
		if (num < 10) {
			System.out.print( (char)( '0' + num));
		} else {
			printInteger(num / 10);
			System.out.print((char) ('0' + num % 10));
		}
	}

}
