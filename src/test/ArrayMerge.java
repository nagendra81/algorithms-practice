package test;

import java.util.Arrays;

public class ArrayMerge {
	public static void main(String[] args) {
		int[] a1 = { 1,3};
		int[] a2 = {2,4,6};
		
		int[] a3 = merge(a1,a2);
		System.out.println(Arrays.toString(a3));
	}

	static int[] merge(int[] a1, int[] a2) {
		int n1 = a1.length;
		int n2 = a2.length;
		
		int[] a3 = new int[n1 + n2];
		
		int i = 0, j = 0, k = 0;

		while (i < n1 || j < n2) {
			if (i < n1)
				a3[k++] = a1[i++];
			if (j < n2)
				a3[k++] = a2[j++];
		}

		return a3;
	}

}
