package ctci.arrays_strings;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class RemoveDups {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] word = br.readLine().toCharArray();
		
		removeDups1(Arrays.copyOf(word, word.length));
		removeDups2(Arrays.copyOf(word, word.length));
		
		
	}
	
	static void removeDups2(char[] word)
	{
		boolean[] vis = new boolean[256];
		Arrays.fill(vis, false);
				
		vis[word[0]] = true;
		
		int n = word.length;
		int t = 1;
		for(int i = 1; i < n; i++) {
			if(! vis[word[i]])
			{
				word[t] = word[i];
				vis[word[i]] = true;
				t++;
			}
		}
		word[t] = 0;
		System.out.println(Arrays.toString(word));
		
	}
	
	static void removeDups1(char[] word)
	{
		int n = word.length;
		
		int t = 1;
		for(int i = 1; i < n; i++) {
			int j;
			for(j = 0; j < t; j++) {
				if(word[i] == word[j]) //skip duplicate
					break;
			}
			if(j == t) //not duplicate, copy
			{
				word[t] = word[i];
				t++;
			}
		}
		word[t] = ' ';
		System.out.println(Arrays.toString(word));
		
	}

}
