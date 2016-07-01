package hackerearth.arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class NiceArches {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int M = Integer.parseInt(br.readLine());

		long res = 0;
		for (int i = 0; i < M; i++) {
			String word = br.readLine().trim();

			if (isBubbly(word)) {
				res++;
			}
		}
		System.out.println(res);

	}

	private static boolean isBubbly(String word) {
		if (word.length() == 0) {
			return false;
		}
		Stack<Character> stack = new Stack<>();

		for (int i = 0; i < word.length(); i++) {
			char c = word.charAt(i);
			if (stack.isEmpty()) {
				stack.push(c);
			} else {
				char d = stack.pop();
				if (d != c) {
					stack.push(d);
					stack.push(c);
				}
			}
		}
		return stack.isEmpty();

	}

}
