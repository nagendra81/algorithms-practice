package hackerrank.algorithms.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class AppendDelete {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine().trim();
		String t = br.readLine().trim();

		int k = Integer.parseInt(br.readLine().trim());

		int len = Math.min(s.length(), t.length());
		int com = 0;
		while (com < len) {
			if (s.charAt(com) != t.charAt(com)) {
				break;
			}
			com++;
		}

		int trem = t.length() - com;
		int srem = s.length() - com;

		if (srem + trem == k || srem + trem + com == k) {
			System.out.println("Yes");
		} else {
			System.out.println("No");
		}

	}

}
