package hackerrank.algorithms.regex;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HackerRankLang {
	static String all_lang = "C:CPP:JAVA:PYTHON:PERL:PHP:RUBY:CSHARP:HASKELL:CLOJURE:BASH:SCALA:ERLANG:CLISP:LUA:BRAINFUCK:JAVASCRIPT:GO:D:OCAML:R:PASCAL:SBCL:DART:GROOVY:OBJECTIVEC";

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		String regex_split = "^(\\d+)\\s(\\w+)$";
		
		Pattern split_pattern = Pattern.compile(regex_split);
		for (int i = 0; i < N; i++) {
			String line = br.readLine();
			String lang = "";
			Matcher match_split = split_pattern.matcher(line);
			if(match_split.find())
				lang = match_split.group(2);
			
			String regex_lang_start = "^" + lang + "\\:.*";
			String regex_lang_middle = "^.*[\\:]" + lang + "[\\:].*";
			String regex_lang_end = "^.*\\:" +lang + "$";
		//	System.out.println(regex_lang_middle);
			if(all_lang.matches(regex_lang_start))
				System.out.println("VALID");
			else if (all_lang.matches(regex_lang_middle))
				System.out.println("VALID");
			else if (all_lang.matches(regex_lang_end))
				System.out.println("VALID");
			else
				System.out.println("INVALID");
			
			
		}
	}

}
