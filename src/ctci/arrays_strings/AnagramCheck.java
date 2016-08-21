package ctci.arrays_strings;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class AnagramCheck {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] word1 = br.readLine().toCharArray();
		char[] word2 = br.readLine().toCharArray();
		
		int[] cnt = new int[256];
		Arrays.fill(cnt,  0);
		
		for(int i = 0; i < word1.length; i++) {
			cnt[word1[i]]++;
		}
		
		for(int i = 0; i < word2.length; i++) {
			cnt[word2[i]]--;
		}
		for(int i = 0; i < cnt.length; i++) {
			if(cnt[i] != 0) {
				System.out.println(cnt[i]);
				System.out.println("NO");
				return;
			}
		}
		System.out.println("YES");
		
		
	}

}
