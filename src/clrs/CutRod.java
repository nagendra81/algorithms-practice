package clrs;

public class CutRod {
	public static void main(String[] args) {
		int[] prices = { 0, 1, 5, 8, 9, 10, 17, 17, 20, 24, 30 };

		int k = 10;
		int[] vals = new int[100];
		solve(vals, 0, k, k, 0);

	}

	static void solve(int[] vals, int vi, int N, int K, int sum) {
		if (sum == K) {
			print(vals, vi);
		} else {
			for (int i = 1; i <= N; i++) {
				vals[vi] = i;
				solve(vals, vi + 1, N - i, K, sum + i);
			}
		}
	}

	private static void print(int[] vals, int vi) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < vi; i++) {
			sb.append(vals[i]);
			if (i < vi - 1) {
				sb.append(" + ");
			}
		}
		System.out.println(sb);

	}

}
