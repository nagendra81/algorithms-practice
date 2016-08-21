package hackerrank.algorithms.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LisaWorkbook {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] line = br.readLine().split(" ");

		int N = Integer.parseInt(line[0].trim());
		int K = Integer.parseInt(line[1].trim());

		int[] problems = new int[N + 1];

		line = br.readLine().split(" ");

		for (int i = 1; i <= line.length; i++) {
			problems[i] = Integer.parseInt(line[i - 1].trim());

		}
		solve(problems, N, K);

	}

	private static void solve(int[] problems, int chapters, int k) {

		int ch = 1;
		int res = 0;
		int index = 1;

		while (ch <= chapters) {

			int pages = problems[ch] / k;
			if ((problems[ch] % k) != 0) {
				pages++;
			}

			for (int i = 1; i <= pages; i++) {

				int end = Math.min(i * k, problems[ch]);
				int st = (i * k) - k + 1;
				if (index >= st && index <= end) {
					res++;
				}

				index++;

			}

			ch++;

		}
		System.out.println(res);
	}

}
