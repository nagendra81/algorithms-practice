package hackerrank.algorithms.regex;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class AlienLang {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		String regex = "^[\\_\\.](\\d+)([A-Za-z]*)\\_?$";
		for (int i = 0; i < N; i++) {
			String line = br.readLine();
			if (line.matches(regex)) {
				System.out.println("VALID");
			} else
				System.out.println("INVALID");
		}
	}

}
