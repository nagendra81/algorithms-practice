package thinkingRecursively.chap4;

public class PrintIntegerNegative {
	public static void main(String[] args) {
		int num = -129876;
		printInteger(num);
	}

	private static void printInteger(int num) {
		if(num < 10 && num >=0) {
			System.out.print( (char) ('0' + num));
		} else if(num < 0) {
			System.out.print('-');
			printInteger(num * -1);
		} else { 
			printInteger(num/10);
			System.out.print((char) ('0' + num%10));
		}
	}

}
