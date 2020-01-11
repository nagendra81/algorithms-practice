package thinkingRecursively.chap3;

public class CannonnBall {

	private static int compute(int layers) {
		if (layers == 1)
			return 1;
		return (layers * layers) + compute(layers - 1);
	}

	public static void main(String[] args) {
		int n = compute(4);
		System.out.println(n);

	}
}
