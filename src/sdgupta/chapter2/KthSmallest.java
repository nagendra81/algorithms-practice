package sdgupta.chapter2;

public class KthSmallest {
	public static void main(String[] args) {
		int[] A = { 2, 4, 6, 8, 10 };
		int[] B = { 1, 3, 5, 7, 9 };

		int k = 6;
		int res = findKthSmallest(A, B, k);
		System.out.println(res);

	}

	private static int findKthSmallest(int[] A, int[] B, int k) {
		if (A.length + B.length < k) {
			return -1;
		}
		return -1;

	}
}
