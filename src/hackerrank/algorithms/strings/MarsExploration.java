package hackerrank.algorithms.strings;

import java.util.Scanner;

public class MarsExploration {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String msg = sc.next();

		int ans = 0;
		for (int i = 0; i < msg.length(); i += 3) {
			String sos = msg.substring(i, i + 3);
			if (sos.equals("sos")) {
				continue;
			} else {
				if (sos.charAt(0) != 'S')
					ans++;
				if (sos.charAt(1) != 'O')
					ans++;
				if (sos.charAt(2) != 'S')
					ans++;
			}
		}
		System.out.println(ans);

	}
}
