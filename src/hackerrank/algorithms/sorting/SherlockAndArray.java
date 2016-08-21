package hackerrank.algorithms.sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class SherlockAndArray {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 0; t < T; t++) {
			int N = Integer.parseInt(br.readLine());
			int[] A = new int[N];
			String[] tmp = br.readLine().split( " ");
			for(int n = 0; n < N; n++) {
				A[n] = Integer.parseInt(tmp[n]);
			}
			solve(A);
					
		}
		

	}
	
	static void solve(int[] A)
	{
		int[] pre = new int[A.length];
		
		pre[0] = A[0];
		for(int i = 1; i < A.length; i++) {
			pre[i] = pre[i-1] +  A[i];
		}
	//	System.out.println(Arrays.toString(pre));
		for(int i = 1; i <= pre.length - 1; i++) {
			if(pre[i-1]== pre[pre.length - 1] - pre[i])
			{
				System.out.println("YES");
				return;
			}
		}
		System.out.println("NO");
	}

}
