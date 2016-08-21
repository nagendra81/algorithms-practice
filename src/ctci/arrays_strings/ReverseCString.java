package ctci.arrays_strings;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ReverseCString {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] line = br.readLine().toCharArray();
		
		int st = 0;
		int end = line.length - 1;
		
		while(st < end) {
			char c = line[st];
			line[st] = line[end];
			line[end] = c;
			st++;
			end--;
		}
		
		System.out.println(String.valueOf(line));
	}

}
