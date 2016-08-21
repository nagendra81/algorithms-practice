package hackerrank.algorithms.regex;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FindHackerRank {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		Pattern both = Pattern.compile("^hackerrank$");
		Pattern starts = Pattern.compile("^(hackerrank)");
		Pattern ends = Pattern.compile("(\\w\\W)+(hackerrank)$");
		Matcher mat;
		int N = Integer.parseInt(br.readLine());
		for (int i = 0; i < N; i++) {
			String line = br.readLine();
			int res = -1;

			mat = starts.matcher(line);
			if (mat.find())
				res = 1;

			mat = ends.matcher(line);
			if (mat.find())
				res = 2;

			mat = both.matcher(line);
			if (mat.find()) {
				res = 0;
			}

			System.out.println(res);

		}
	}

}
