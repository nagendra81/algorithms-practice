package hackerrank.algorithms.regex;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SplitPhone {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		String regex = "^(\\d+)[-\\s](\\d+)[-\\s](\\d+)$";
		Pattern pattern = Pattern.compile(regex);
		Matcher match;
		for (int i = 0; i < N; i++) {
			String line = br.readLine();
			match = pattern.matcher(line);
			if (match.find()) {
				System.out.printf(
						"CountryCode=%s,LocalAreaCode=%s,Number=%s\n",
						match.group(1), match.group(2), match.group(3));
			}

		}
	}

}
