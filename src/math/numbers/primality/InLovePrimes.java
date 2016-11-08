package math.numbers.primality;

import java.util.Scanner;

public class InLovePrimes {
	static final String ARIJIT = "Arijit\n";
	static final String DEEPA = "Deepa\n";

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		int[] arr = new int[T];

		for (int i = 0; i < T; i++) {
			arr[i] = sc.nextInt();
		}

		StringBuilder res = new StringBuilder();
		for (int t = 0; t < T; t++) {
			if (arr[t] == 2) {
				res.append(ARIJIT);
			} else {
				res.append(DEEPA);
			}
		}
		System.out.println(res.toString().trim());
	}

}
