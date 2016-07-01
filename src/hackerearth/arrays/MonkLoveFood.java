package hackerearth.arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class MonkLoveFood {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		Stack<Integer> pile = new Stack<>();

		int Q = Integer.parseInt(br.readLine().trim());

		String[] line = null;
		int op;
		for (int q = 0; q < Q; q++) {
			line = br.readLine().split(" ");
			op = Integer.parseInt(line[0]);
			switch (op) {
			case 1:
				if (pile.isEmpty()) {
					System.out.println("No Food");
				} else {
					System.out.println(pile.pop());
				}
				break;
			case 2:
				pile.push(Integer.parseInt(line[1]));
				break;
			}

		}

	}

}
