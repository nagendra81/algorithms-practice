package hackerrank.algorithms.warmup;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class GemStones {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		boolean[][] input = new boolean[N][26];
		

		for (int i = 0; i < N; i++) {
			String line = br.readLine();

			for (int j = 0; j < line.length(); j++) {
				input[i][line.charAt(j) - 'a'] = true;
			}
		}
		
		boolean[] res = input[0];
		
		for(int i = 1; i < N; i++) {
			boolean[] t = input[i];
			
			for(int j = 0; j < 26; j++) {
				res[j] = res[j] && t[j];
			}
		}
		
		int c = 0;
		
		for(int i = 0; i < 26; i++) {
			if(res[i])
				c++;
		}
		System.out.println(c);
	}
}
