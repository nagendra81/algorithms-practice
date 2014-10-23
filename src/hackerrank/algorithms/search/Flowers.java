package hackerrank.algorithms.search;

import java.util.Arrays;
import java.util.Scanner;

public class Flowers {

	private long solve(int[] C, int N, int K) {
		
		int[] cnt = new int[K];
		Arrays.fill(cnt, 0);
		Arrays.sort(C);
	
	//	System.out.println("C = " + Arrays.toString(C));

		long sum = 0;
		for (int i = 0; i < K; i++) {
			sum += C[N - 1 - i];
		//	System.out.println("N - i - 1 = " + C[N - i - 1]);
			cnt[i]++;
		}
		
		//System.out.println("before CNT = " + Arrays.toString(cnt));
		
		for(int i = N - K - 1; i >=0; i--) {
			cnt[(i + K) % K] ++;
			sum += cnt[(i + K) % K] * C[i];
		}
		
	//	System.out.println("after CNT = " + Arrays.toString(cnt));
		return sum;

	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		int N, K;
		N = in.nextInt();
		K = in.nextInt();

		int C[] = new int[N];
		for (int i = 0; i < N; i++) {
			C[i] = in.nextInt();
		}

		Flowers f = new Flowers();
		long sum = f.solve(C, N, K);
		System.out.println(sum);

	}

}
