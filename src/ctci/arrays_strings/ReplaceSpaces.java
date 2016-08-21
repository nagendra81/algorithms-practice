package ctci.arrays_strings;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class ReplaceSpaces {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] line = br.readLine().toCharArray();
		
		int numSpaces = 0;
		for(int i = 0; i < line.length; i++)
			if(line[i] == ' ')
				numSpaces++;
		
		char[] newLine = Arrays.copyOf(line, line.length +( 2 * numSpaces));
		
		int j = newLine.length - 1;
		for(int i = line.length - 1; i >=0; i--) {
			if(line[i] == ' ') {
				newLine[j--] = '0';
				newLine[j--] = '2';
				newLine[j--] = '%';
			} else {
				newLine[j--]= line[i];
				
			}
		}
		System.out.println(String.valueOf(newLine));
		
		
		
		
		
		
		

	}

}
