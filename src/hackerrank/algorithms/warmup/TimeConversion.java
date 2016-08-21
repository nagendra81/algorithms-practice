package hackerrank.algorithms.warmup;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TimeConversion {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String time = br.readLine().trim();

		StringBuilder mil_time = new StringBuilder(time);
		if (time.endsWith("PM")) {
			Integer hh = Integer.parseInt(time.substring(0, 2));
			if (hh < 12) {
				hh += 12;
			}
			mil_time.replace(0, 2, String.valueOf(hh));
		} else {
			Integer hh = Integer.parseInt(time.substring(0, 2));
			if (hh == 12) {
				mil_time.replace(0, 2, "00");
			}
		}
		System.out.println(mil_time.substring(0, 8));

	}

}
