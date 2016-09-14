package hackerrank.wcs6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;

public class Abbreviation {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int Q = sc.nextInt();

		for (int i = 0; i < Q; i++) {
			String src = sc.next();
			String trg = sc.next();

			boolean ok = solve(src.trim().toCharArray(), trg.toCharArray());
			System.out.println(ok ? "YES" : "NO");
		}

	}

	private static boolean solve(char[] src, char[] dst) {
		char[] dst_cpy = Arrays.copyOf(dst, dst.length);
		Map<Character, Set<Integer>> map = new LinkedHashMap<>();

		for (int i = 0; i < src.length; i++) {
			char c = src[i];
			Set<Integer> li = map.get(c);
			if (li == null)
				li = new HashSet<>();
			else
				li.add(i);

			map.put(c, li);

		}

		for (int i = 0; i < dst.length; i++) {
			Set<Integer> li = map.get(dst[i]);
			if (li != null && li.size() > 0) {

				map.put(dst[i], li);
				dst[i] = 0;
			}
		}

		for (int i = 0; i < dst.length; i++) {
			if (dst[i] == 0) {
				continue;
			}
			char c = Character.toLowerCase(dst[i]);
			Set<Integer> v = map.get(c);
			if (v != null && v.size() > 0) {
				v.remove(i);
				map.put(c, v);
				dst[i] = 0;
			}
		}

		for (int i = 0; i < dst.length; i++) {
			if (dst[i] != 0) {
				return false;
			}
		}

		for (Entry<Character, Set<Integer>> en : map.entrySet()) {
			if (en.getValue() != null && en.getValue().size() > 0 && Character.isUpperCase(en.getKey())) {
				return false;
			}
		}

		List<Character> li = new ArrayList<>();

		for (Entry<Character, Set<Integer>> en : map.entrySet()) {
			Set<Integer> se = en.getValue();
			if (se != null && se.size() > 0) {
				for (Integer idx : se) {
					li.set(idx, en.getKey());
				}
			}
		}

		Character[] out = li.toArray(new Character[1]);
		System.out.println(String.valueOf(out));
		if (String.valueOf(out).toUpperCase().equals(String.valueOf(dst_cpy))) {
			return true;
		}

		return false;

	}

}
