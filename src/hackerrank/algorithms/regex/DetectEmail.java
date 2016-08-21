package hackerrank.algorithms.regex;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Set;
import java.util.TreeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DetectEmail {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		String[] line = new String[N];
		for (int i = 0; i < N; i++) {
			line[i] = br.readLine();
		}
		solve(line);
	}
	static void solve(String[] line)
	{
		Set<String> emails = new TreeSet<String>();
		
		String regex = "\\b([\\w-\\.]+\\@[\\w-\\.]+[\\w-])+";
		Pattern patt = Pattern.compile(regex);
		for (String s : line) {
			Matcher mat = patt.matcher(s);
			while (mat.find()) {
				emails.add(mat.group(1));
			}
		}
		
		int size = emails.size();
		int i = 0;

		for (String s : emails) {
			System.out.print(s);

			if (i < size - 1)
				System.out.print(";");
			i++;
		}
		
	}


}
