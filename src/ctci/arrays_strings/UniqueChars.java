package ctci.arrays_strings;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class UniqueChars {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = br.readLine();
		
		boolean[] chars = new boolean[26];
		Arrays.fill(chars, false);
		
		for(int i = 0; i < line.length(); i++) {
			int c = line.charAt(i) - 'a';
			if(chars[c] == true) {
				System.out.println(false);
				return;
			}
			chars[c] = true;
		}
		System.out.println(true);
		
	}

}
