package hackerrank.algorithms.math;

import java.util.Scanner;

public class TriangleNumbers {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int T = in.nextInt();
		
		for(int i = 0; i < T; i++) {
			int N = in.nextInt();
			new TriangleNumbers().solve(N);
		}
	}

	private void solve(int N) {
		if( (N&1) == 1) { //odd
			System.out.println(2);
			return;
		}
	}

}
