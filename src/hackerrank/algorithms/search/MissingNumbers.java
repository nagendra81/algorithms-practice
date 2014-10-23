package hackerrank.algorithms.search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class MissingNumbers {

	private void solve(int[] a, int[] b) {
		Map<Integer, Integer> bMap = new HashMap<Integer, Integer>();

		for (int i : b) {
			Integer c = bMap.get(i);
			if (c == null)
				c = 0;
			bMap.put(i, c + 1);
		}

		for (int i : a) {
			Integer c = bMap.get(i);
			if (c > 0)
				c -= 1;
			bMap.put(i, c);
		}

		Set<Integer> res = new TreeSet<Integer>();

		for (Map.Entry<Integer, Integer> e : bMap.entrySet()) {
			if (e.getValue() > 0)
				res.add(e.getKey());
		}

		for (int i : res) {
			System.out.print(i + " ");
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String line = br.readLine();

		int m = Integer.parseInt(line);
		int[] A = new int[m];

		line = br.readLine();
		String[] temp = line.split(" ");
		for (int i = 0; i < m; i++) {
			A[i] = Integer.parseInt(temp[i]);
		}

		line = br.readLine();
		int n = Integer.parseInt(line);

		int[] B = new int[n];

		line = br.readLine();
		temp = line.split(" ");

		for (int i = 0; i < n; i++) {
			B[i] = Integer.parseInt(temp[i]);
		}

		MissingNumbers mn = new MissingNumbers();
		mn.solve(A, B);
	}

}
