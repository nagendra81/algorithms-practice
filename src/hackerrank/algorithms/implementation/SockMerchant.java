package hackerrank.algorithms.implementation;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class SockMerchant {
	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			int n = sc.nextInt();

			Map<Integer, Integer> socks = new HashMap<>();

			for (int i = 0; i < n; i++) {
				int c = sc.nextInt();
				Integer cnt = socks.get(c);
				if (cnt == null) {
					cnt = 0;
				}
				socks.put(c, cnt + 1);
			}

			int res = 0;
			for (int val : socks.values()) {
				res += (val / 2);
			}
			System.out.println(res);
		}
	}

}
