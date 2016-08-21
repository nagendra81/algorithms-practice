package hackerrank.algorithms.sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class MakeItAnagram {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String str1 = br.readLine();
		String str2 = br.readLine();

		int[] cm1 = new int[26];
		int[] cm2 = new int[26];
		
		Arrays.fill(cm1, 0);
		Arrays.fill(cm2, 0);
		
		for(Character c : str1.toCharArray()) {
			cm1[c - 'a']++; 
		}

		for(Character c : str2.toCharArray()) {
			cm2[c - 'a']++; 
		}
		
		int res = 0;
		
		for(int i = 0; i < 26; i++) {
			res += Math.abs(cm1[i] - cm2[i]);
		}
		System.out.println(res);
		
		

	}
	

}
