package hackerrank.algorithms.strings;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LatLongPairs {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < N; i++) {
			solve(br.readLine());
		}
	}

	private static void solve(String line) {
		String regex = "^\\((\\+|-)?\b\\d+\b.+, (\\+|-)?\b\\d+\b.+\\)$";
		
		Pattern p = Pattern.compile(regex);
		Matcher matcher = p.matcher(line);
		
			
		System.out.println(line.matches(regex));
	}
	

}
