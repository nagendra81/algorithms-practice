package thinkingRecursively.chap4;

public class DigitalRoot {
	public static void main(String[] args) {
		int num = 1576;
		int root = digitalRoot(num);
		System.out.println(root);
	}
	
	private static int digitalRoot(int n) {
		if(n < 10) {
			return n;
		} else {
			return digitalRoot( (n/10) + (n%10) );
		}
	}
}
