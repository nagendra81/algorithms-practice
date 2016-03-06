package topcoder.recursion;

import java.util.Arrays;

// https://community.topcoder.com/stat?c=problem_statement&pm=6665
// SRM 322
public class DerivativeSequence {
	public int[] derSeq(int[] arr, int n) {
		if(n == 0) {
			return arr;
		} else {
			for(int j = 1; j < arr.length; j++) {
				arr[j-1] = arr[j] - arr[j-1];
			}
			return derSeq(Arrays.copyOf(arr,  arr.length -1), n-1);
		}
	}

	public static void main(String[] args) {
		int[] arr = {-100};
		int n = 1;
		
		DerivativeSequence seq = new DerivativeSequence();
		int[] res = seq.derSeq(arr, n);
		System.out.println(Arrays.toString(res));
		
	}

}
