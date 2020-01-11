package hackerrank.algorithms.recursion;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class DigitSum {

	// Complete the superDigit function below.
	static int superDigit(String n, int k) {
		int s = 0;
		for (char c : n.toCharArray()) {
			s += c - '0';
		}
		return digitRoot(s * k);
	}

	static int digitRoot(int n) {
		if (n < 10) {
			return n;
		}
		return digitRoot(n / 10 + (n % 10));
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

		String[] nk = scanner.nextLine().split(" ");

		String n = nk[0];

		int k = Integer.parseInt(nk[1]);

		int result = superDigit(n, k);

		bufferedWriter.write(String.valueOf(result));
		bufferedWriter.newLine();

		bufferedWriter.close();

		scanner.close();
	}
}
