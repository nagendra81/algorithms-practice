package hackerrank.algorithms.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SherlockBeast {

	private void solve(int N) {
		int num_5 = N;
		int num_3 = 0;
		
		while (num_5 >= 0 && num_3 <= N) {
			if ((num_5 % 3) == 0 && (num_3 % 5) == 0) {
				break;
			} else {
				num_5--;
				num_3++;
			}
		}

		if (num_5 < 0 || num_3 > N) {
			System.out.println("-1");
			return;
		}

		StringBuilder sb = new StringBuilder(N);
		for (int i = 0; i < num_5; i++)
			sb.append("5");
		
		for (int i = 0; i < num_3; i++)
			sb.append("3");
		

		System.out.println(sb);
		
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		SherlockBeast sb = new SherlockBeast();

		for (int t = 0; t < T; t++) {
			sb.solve(Integer.parseInt(br.readLine()));
		}

	}

}
