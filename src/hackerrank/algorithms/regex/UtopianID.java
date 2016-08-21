package hackerrank.algorithms.regex;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UtopianID {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		String[] line = new String[N];
		for(int i = 0; i < N; i++) {
			line[i] = br.readLine();
		}
		solve(line);
		
		
	}
	static void solve(String[] line)
	{
		String regex = "^([a-z]{0,3})([\\d]{2,8})([A-Z]{3,})$";
		Pattern p = Pattern.compile(regex);
		
		for(String str: line) {
			Matcher mat = p.matcher(str);
			if(mat.find())
				System.out.println("VALID");
			else
				System.out.println("INVALID");
		}
		
		
		
	}

}
