package thinkingRecursively.chap6;

public class Count15 {
	public static void main(String[] args) {
		int[] vals = { 1, 5, 10, 4, 9 };
		int target = 28;

		int res = countSum(vals, 0, 0, target);
		System.out.println(res);

	}

	static int countSum(int[] vals, int vi, int sum, int target) {
		if (vi == vals.length && sum == target) {
			return 1;
		} else if (vi == vals.length) {
			return 0;
		} else if (sum == target) {
			return 1;
		} else {
			return countSum(vals, vi + 1, sum + vals[vi], target) + countSum(vals, vi + 1, sum, target);
		}
	}
}
