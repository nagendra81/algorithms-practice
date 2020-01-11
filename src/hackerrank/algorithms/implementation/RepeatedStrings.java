package hackerrank.algorithms.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RepeatedStrings {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		long N = Long.parseLong(br.readLine().trim());

		int a = 0;
		for (char c : s.toCharArray()) {
			if (c == 'a') {
				a++;
			}
		}

		long res = a * (N / s.length());

		a = 0;
		for (int i = 0; i < (N % s.length()); i++) {
			if (s.charAt(i) == 'a') {
				a++;
			}
		}
		res += a;
		System.out.println(res);

	}
}
