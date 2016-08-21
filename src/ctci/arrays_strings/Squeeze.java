package ctci.arrays_strings;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Squeeze {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] line = br.readLine().toCharArray();
		
		char[] res = squeeze(line, ' ');
		System.out.println(new String(res));
	}
	
	static char[] squeeze(char[] line, char c)
	{
		int t = 0;
		for(int i = 0; i < line.length; i++) {
			if(line[i] != ' ')
				line[t++] = line[i];
			
		}
		return Arrays.copyOf(line, t);
		
		
	}

}
