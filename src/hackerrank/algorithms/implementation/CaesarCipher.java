package hackerrank.algorithms.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CaesarCipher {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine().trim());

		StringBuilder line = new StringBuilder(br.readLine().trim());
		int K = Integer.parseInt(br.readLine().trim());

		for (int i = 0; i < line.length(); i++) {
			char s = line.charAt(i);
			if (s >= 'a' && s <= 'z') {
				line.setCharAt(i, (char) ('a' + ((s - 'a') + K) % 26));
			} else if (s >= 'A' && s <= 'Z') {
				line.setCharAt(i, (char) ('A' + ((s - 'A') + K) % 26));
			}

		}
		System.out.println(line);

	}

}
