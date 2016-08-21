package hackerrank.algorithms.regex;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SayingHi {
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
		String regex = "(?i)^Hi\\s[^d].*";
		for(String li : line)
		{
			if(li.matches(regex)) {
				System.out.println(li);
			}
			
		}
	}

}
