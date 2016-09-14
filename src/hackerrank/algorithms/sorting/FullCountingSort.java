package hackerrank.algorithms.sorting;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class FullCountingSort {
	public static void main(String[] args) throws NumberFormatException, IOException {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();

		int[] keys = new int[N];
		Map<Integer, List<String>> vals = new HashMap<>();

		int cnt = 0;
		for (int i = 0; i < N; i++) {
			keys[i] = sc.nextInt();
			List<String> li = vals.get(keys[i]);
			if (li == null)
				li = new ArrayList<>();
			String s = sc.next();
			if (i < (N / 2))
				s = "-";
			li.add(s);
			vals.put(keys[i], li);
			cnt++;
		}

		int[] count = new int[cnt];
		Arrays.fill(count, 0);

		for (int i = 0; i < N; i++) {
			count[keys[i]]++;
		}

		// System.out.println(Arrays.toString(count));

		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < 100; i++) {
			List<String> li = vals.get(i);
			if (li != null) {
				for (String s : li) {
					sb.append(s);
					sb.append(" ");
				}

			}
		}

		System.out.println(sb);

	}

}
