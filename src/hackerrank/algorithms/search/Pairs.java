package hackerrank.algorithms.search;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Pairs {

	private void solve(int[] arr, int k) {

		Set<Integer> set = new HashSet<Integer>();
		
		int res = 0;
		int n = arr.length;
		
		//System.out.println(Arrays.toString(arr));

		for (int i = 0; i < n; i++) {
			set.add(arr[i]);
		}
		
		for(int i = 0; i < n; i++) {
			if(set.contains(arr[i] - k))
				res++;
			if(set.contains(arr[i] + k))
				res++;
		}
		
		res /= 2;

		System.out.println(res);

	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		int n = in.nextInt();
		int k = in.nextInt();

		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = in.nextInt();
		}

		Pairs p = new Pairs();
		p.solve(arr, k);
	}

}
