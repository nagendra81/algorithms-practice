package hackerearth.algorithms.dynamic;

import java.util.Arrays;
import java.util.Scanner;

public class XsquareTwoArrays {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int Q = sc.nextInt();

		long[] A = new long[N];
		long[] B = new long[N];

		for (int i = 0; i < N; i++) {
			A[i] = sc.nextLong();
		}

		for (int i = 0; i < N; i++) {
			B[i] = sc.nextLong();
		}

		long[] odda = new long[N / 2 + 1];
		long[] evena = new long[N / 2 + 1];

		evena[0] = A[0];
		odda[0] = A[1];
		for (int i = 2; i < N; i++) {
			if ((i % 2) == 0) {
				evena[i / 2] = evena[(i / 2) - 1] + A[i];
			} else {
				odda[i / 2] = odda[i / 2 - 1] + A[i];
			}
		}

		long[] oddb = new long[N / 2 + 1];
		long[] evenb = new long[N / 2 + 1];

		evenb[0] = A[0];
		oddb[0] = A[1];
		for (int i = 2; i < N; i++) {
			if ((i % 2) == 0) {
				evenb[i / 2] = evenb[(i / 2) - 1] + B[i];
			} else {
				oddb[i / 2] = oddb[i / 2 - 1] + B[i];
			}
		}

		System.out.println(Arrays.toString(odda));
		System.out.println(Arrays.toString(evena));

		System.out.println("*** B");
		System.out.println(Arrays.toString(oddb));
		System.out.println(Arrays.toString(evenb));

		for (int q = 0; q < Q; q++) {
			int ch = sc.nextInt();
			int lo = sc.nextInt();
			int hi = sc.nextInt();

		}

	}

}
