package hackerrank.algorithms.warmup;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ServiceLane {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] line = br.readLine().split(" ");
		int N = Integer.parseInt(line[0]);
		int T = Integer.parseInt(line[1]);
		
		int[] width = new int[N];
		line = br.readLine().split(" ");
		for(int i = 0; i < N; i++)
			width[i] = Integer.parseInt(line[i]);
		
		for(int t = 0; t < T; t++) {
			line = br.readLine().split(" ");
			int s = Integer.parseInt(line[0]);
			int e = Integer.parseInt(line[1]);
			solve(width, s, e);
		}
	}
	static void solve(int[] width, int si, int ei)
	{
		int min = Integer.MAX_VALUE;
		
		for(int w = si; w <= ei; w++)
			if(width[w] < min)
				min = width[w];
		System.out.println(min);
		
	}

}
