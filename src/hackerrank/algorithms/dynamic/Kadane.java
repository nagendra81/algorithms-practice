package hackerrank.algorithms.dynamic;

public class Kadane {
	public static void main(String[] args) {
		int[] a = { 5, 3, -1, 12, 14 };
		int res = maxSubArraySum(a);
		System.out.println(res);

	}

	public static int maxSubArraySum(int a[]) {
		int max_so_far = 0, curr_max = 0;

		for (int i = 0; i < a.length; i++) {
			curr_max = curr_max + a[i];
			if (curr_max < 0)
				curr_max = 0;
			if (max_so_far < curr_max)
				max_so_far = curr_max;
		}
		return max_so_far;
	}

}
