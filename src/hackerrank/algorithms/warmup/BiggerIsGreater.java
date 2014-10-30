package hackerrank.algorithms.warmup;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BiggerIsGreater {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		for (int t = 0; t < T; t++) {
			String line = br.readLine();
			solve(line.toCharArray());
		}

	}

	static void solve(char[] buff) {
		int len = buff.length;
		int i = 0;
		for (i = 0; i < len - 1; i++) {
			if (buff[i] < buff[i + 1])
				continue;
			break;
		}
		if (i > len - 1) {
			System.out.println("no answer");
			return;
		}

		char c = buff[i];
		buff[i] = buff[i+1];
		buff[i+1] = c;
		System.out.println(c);
		
		char[] tmp = new char[len - i + 1];
		
		tmp = Arrays.copyOfRange(buff, i+1, tmp.length);
		Arrays.sort(tmp);
		
		char[] res = new char[len];
		
		for(int k = 0; k <= i; k++) {
			res[k] = buff[i];
		}
		
		for(int k = i+1, j = 0; k < len; k++, j++)
			res[k] = tmp[j];
		
		System.out.println(String.valueOf(res));

	}
	

}
