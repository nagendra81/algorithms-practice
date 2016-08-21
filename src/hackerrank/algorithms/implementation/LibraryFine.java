package hackerrank.algorithms.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LibraryFine {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] line = br.readLine().split(" ");

		int ad = Integer.parseInt(line[0].trim());
		int am = Integer.parseInt(line[1].trim());
		int ay = Integer.parseInt(line[2].trim());

		line = br.readLine().split(" ");

		int dd = Integer.parseInt(line[0].trim());
		int dm = Integer.parseInt(line[1].trim());
		int dy = Integer.parseInt(line[2].trim());

		int fine = 0;
		if (ay > dy) {
			fine = 10000;
		} else if (ay >= dy && am > dm) {
			fine = (am - dm) * 500;
		} else if (ay >= dy && am >= dm && ad > dd) {
			fine = 15 * (ad - dd);
		} else {
			fine = 0;
		}

		System.out.println(fine);

	}

}
