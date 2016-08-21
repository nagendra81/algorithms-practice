package hackerrank.algorithms.regex;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ValidPan {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		String regex = "^([A-Z]){5}([0-9]){4}[A-Z]$";
		for(int i = 0; i < N; i++) {
			String line = br.readLine();
			if(line.matches(regex)) {
				System.out.println("YES");
			} else
				System.out.println("NO");
		}
	}

}
