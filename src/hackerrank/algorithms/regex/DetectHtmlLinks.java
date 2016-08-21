package hackerrank.algorithms.regex;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DetectHtmlLinks {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		String[] line = new String[N];
		for (int i = 0; i < N; i++) {
			line[i] = br.readLine();
		}
		solve(line);
	}
	static void solve(String[] line) {
	//	String regex = "<a\\s*href=\"([\\w!@#$%^&*()-_+=/]+)\"" +
		//			   "\\s*[>]{1,}([.*]+[<?])";
//		String regex = "<a.*?href=\"(.*?)\".*?>(.*?)";
		String regex = "<a.*?href=\"(.*?)\".*?>\\b([.*?&&^</]+)</a>";
		Pattern pat = Pattern.compile(regex);
		for(String str : line) {
			Matcher mat = pat.matcher(str);
			if(mat.find()) {
				System.out.printf("%s,%s\n", mat.group(1), mat.group(2));
			}
			
		}
	}

}
