package hackerrank.algorithms.search;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class LonelyInteger {

	static int lonelyinteger(int[] a) {
		Map<Integer, Integer> intMap = new HashMap<Integer, Integer>();

		for (int i : a) {
			Integer cnt = intMap.get(i);
			if (cnt == null)
				cnt = 0;
			intMap.put(i, cnt + 1);
		}

		for (Map.Entry<Integer, Integer> e : intMap.entrySet()) {
			if (e.getValue() == 1)
				return e.getKey();
		}
		return 0;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int res;

		int _a_size = Integer.parseInt(in.nextLine());
		int[] _a = new int[_a_size];
		int _a_item;
		String next = in.nextLine();
		String[] next_split = next.split(" ");

		for (int _a_i = 0; _a_i < _a_size; _a_i++) {
			_a_item = Integer.parseInt(next_split[_a_i]);
			_a[_a_i] = _a_item;
		}

		res = lonelyinteger(_a);
		System.out.println(res);
	}

}
