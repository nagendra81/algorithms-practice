package hackerearth.arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BiasedChandan {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		Stack<Integer> stack = new Stack<>();

		int N = Integer.parseInt(br.readLine().trim());

		for (int i = 0; i < N; i++) {
			stack.push(Integer.parseInt(br.readLine()));
		}

		long sum = 0;

		int remCnt = 0;
		int c = 0;
		while (!stack.isEmpty()) {
			c = stack.pop();
			if (c != 0 && remCnt == 0) {
				sum += c;
			} else if (c == 0) {
				remCnt++;
			} else if (c != 0 && remCnt > 0) {
				remCnt--;
			}
		}

		System.out.println(sum);
	}
}
