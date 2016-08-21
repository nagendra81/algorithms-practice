package hackerrank.algorithms.regex;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class HackerRankTweets {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		String regex = "(?i)(.*)hackerrank(.*)";

		int res = 0;
		for (int i = 0; i < N; i++) {
			String line = br.readLine();
			if (line.matches(regex)) {
				res++;
			}
		}
		System.out.println(res);
	}

}
