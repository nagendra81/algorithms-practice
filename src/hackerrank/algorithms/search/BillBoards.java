package hackerrank.algorithms.search;

import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class BillBoards {
	public static void main(String[] args) throws FileNotFoundException {

		Scanner in = new Scanner(System.in);
		// Scanner in = new Scanner(new
		// FileInputStream("C:\\Users\\nchumbal\\Desktop\\billboards\\input.txt"));

		int N = in.nextInt();
		int K = in.nextInt();

		int[] bb = new int[N];
		for (int i = 0; i < N; i++)
			bb[i] = in.nextInt();

		new BillBoards().solve(bb, N, K);
	}

	private void solve(int[] bb, int N, int K) {
		long[] leftSum = new long[N];
		long[] rightSum = new long[N];
		
		
		System.out.println("bb: " + Arrays.toString(bb));
		long total = 0;

		leftSum[0] = bb[0];
		for (int i = 1; i < N; i++) {
			leftSum[i] = leftSum[i - 1] + bb[i];
		}
		
		total = leftSum[N-1];

		rightSum[N - 1] = bb[N - 1];
		for (int i = N - 2; i >= 0; i--) {
			rightSum[i] = rightSum[i + 1] + bb[i];
		}

		long[] prof = new long[N];

		for (int i = 0; i < K; i++) {
			prof[i] = leftSum[i];
		}

		for (int i = K ; i < N; i++) {
			prof[i] = Math.max(getSubSum(bb, total,  i - K + 1, i) + ((i > K) ? prof[i - K - 1] : 0),
					prof[i - 1]);
		}

		System.out.println("prof: " + Arrays.toString(prof));
		System.out.println(prof[N - 1]);

	}
	
	


	private long getSubSum(int[] bb, long total, int i, int j) {
		long subSum = 0;
		//System.out.println(" i = " + i + ", j = " + j);

		for (int k = i; k <= j; k++)
			subSum += bb[k];
		
	//	System.out.println(subSum);

		return subSum;
	}
}
