package hackerrank.algorithms.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class KMarsh {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] tmp = br.readLine().split(" ");
		int M = Integer.parseInt(tmp[0]);
		int N = Integer.parseInt(tmp[1]);
		
		char[][] land = new char[M][N];
		
		for(int i = 0; i < M; i++) {
			land[i] = br.readLine().toCharArray();
		}
		solve(land, M, N);
	}
	static void solve(char[][] land, int M, int N)
	{
		
	}

}
