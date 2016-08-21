package hackerrank.algorithms.search;

import java.util.Scanner;

public class Encryption {

	private void solve(String line) {
		int len = line.length();
		int w = (int) Math.floor(Math.sqrt((double) line.length()));
		int h = (int) Math.ceil(Math.sqrt((double) line.length()));
		
		//System.out.println("W = " + w + ", H = " + h);
		while(h * w < len) {
			w++;
		}
		
		int rows = Math.min(w, h);
		int cols = Math.max(w, h);

	//	System.out.println("rows = " + rows + ", cols = " + cols);

//		System.out.println(len);
		char[][] split = new char[rows][cols];

		int start = 0;
		for (int i = 0; i < rows; i++) {
			split[i] = (i == rows - 1) ? line.substring(start).toCharArray()
					: line.substring(start, start + cols).toCharArray();
	//		System.out.println(split[i]);
			start += cols;
		}

		StringBuilder encoded = new StringBuilder();

		//System.out.println("============");

		for (int i = 0; i < cols; i++) {
			StringBuilder sb = new StringBuilder();
			for (int j = 0; j < rows && i < split[j].length; j++) {
				sb.append(split[j][i]);
			}
		//	System.out.println(sb);
			encoded.append(sb.toString().trim());
			if(i < cols -1)
				encoded.append(' ');
		}
		System.out.println(encoded);
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		String line = in.nextLine();
		Encryption ep = new Encryption();
		ep.solve(line);
	}
}
