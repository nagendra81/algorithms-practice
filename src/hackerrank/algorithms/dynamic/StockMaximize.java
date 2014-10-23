package hackerrank.algorithms.dynamic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class StockMaximize {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < T; i++) {
			int N = Integer.parseInt(br.readLine());
			int stocks[] = new int[N];
			
			String[] tmp = br.readLine().split(" ");
			for(int j = 0; j < tmp.length ; j++) 
				stocks[j] = Integer.parseInt(tmp[j]);
			
			solve(stocks);
		}
		
	}

	private static void solve(int[] stocks) {
		
		int profit = 0;
		int buy = 0;
		for(int i = 0; i < stocks.length; i++) {
			
		}
		
		
	}

}
