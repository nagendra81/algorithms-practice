package hackerrank.algorithms.regex;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FindSubstring {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		String[] line = new String[N];
		for (int i = 0; i < N; i++) {
			line[i] = br.readLine();
		}
		int T = Integer.parseInt(br.readLine());
		String[] words = new String[T];
		for (int i = 0; i < T; i++) {
			words[i] = br.readLine();
		}
		solve(line, words);
	}

	static void solve(String[] line, String[] words) {
		//System.out.println(Arrays.toString(line));
		//System.out.println(Arrays.toString(words));
		for (String w : words) {
			int cnt = 0;
			String regex = "\\w+(" + w + ")\\w+";
			Pattern pat = Pattern.compile(regex);
			//System.out.println(regex);
			for (String str : line) {
				//System.out.println("str:" + str);
				Matcher mat = pat.matcher(str);
				while(mat.find()) {
					cnt++;
				}
			}
			System.out.println(cnt);
		}
	}
}
