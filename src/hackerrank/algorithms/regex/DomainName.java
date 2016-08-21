package hackerrank.algorithms.regex;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Set;
import java.util.TreeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DomainName {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		String[] line = new String[N];
		for (int i = 0; i < N; i++) {
			line[i] = br.readLine();
		}
		solve(line);
	}

	static void solve(String[] line) {
		Set<String> domains = new TreeSet<String>();

		String reg_dom = "\\b(https?)://((www\\.|ww2\\.))?" +
						"(([\\w-]+\\.)+([\\w-]+))\\/??";

		Pattern patt = Pattern.compile(reg_dom);

		for (String s : line) {
			Matcher mat = patt.matcher(s);
			while (mat.find()) {
				domains.add(mat.group(4));
			}
		}

		int size = domains.size();
		int i = 0;

		for (String s : domains) {
			System.out.print(s);

			if (i < size - 1)
				System.out.print(";");
			i++;
		}

	}

}
