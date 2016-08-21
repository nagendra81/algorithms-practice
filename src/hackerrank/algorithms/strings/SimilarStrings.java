package hackerrank.algorithms.strings;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.TreeMap;

public class SimilarStrings {
	private int solve(String A) {
		int n = A.length();
		
        TreeMap<String, Integer> suffixMap = new TreeMap<String, Integer>();
		
		for(int i = 0; i < n; i++) {
			suffixMap.put(A.substring(i), i);
		}
		
		for(Map.Entry<String, Integer> e : suffixMap.entrySet())
			System.out.println(e.getKey() + ":" + e.getValue());
			
		return 0;

	}

	public static void main(String[] args) throws IOException {
		//Scanner in = new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String line = br.readLine();
		int n = Integer.parseInt(line);
		
		
		SimilarStrings ss = new SimilarStrings();
		int[] res = new int[n];
		for(int i = 0; i < n; i++) {
			line = br.readLine();
			String s = line;
			res[i] = ss.solve(s);
			
		}
		
		for(int r: res)
			System.out.println(r);

	}

}
