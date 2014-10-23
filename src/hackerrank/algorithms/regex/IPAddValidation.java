package hackerrank.algorithms.regex;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class IPAddValidation {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < N; i++) {
			solve(br.readLine());
		}
	}
	
	static void solve(String line)
	{
		line = line.trim();
		String reg_ipv4 = "^([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\." +
				"([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\." +
				"([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\." +
				"([01]?\\d\\d?|2[0-4]\\d|25[0-5])$";
		 
		String reg_ipv6 = "^\\p{XDigit}{1,4}\\:\\p{XDigit}{1,4}\\:\\p{XDigit}{1,4}\\:\\p{XDigit}{1,4}\\:\\p{XDigit}{1,4}\\:\\p{XDigit}{1,4}\\:\\p{XDigit}{1,4}\\:\\p{XDigit}{1,4}$";
		
		if(line.matches(reg_ipv4))
			System.out.println("IPv4");
		else if(line.matches(reg_ipv6)) {
			System.out.println("IPv6");
		} else {
			System.out.println("Neither");
		}
		
	}

}
