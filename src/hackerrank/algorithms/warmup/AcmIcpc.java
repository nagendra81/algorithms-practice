package hackerrank.algorithms.warmup;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Map;
import java.util.TreeMap;

public class AcmIcpc {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] tmp = br.readLine().split(" ");
		int N = Integer.parseInt(tmp[0]);
		int M = Integer.parseInt(tmp[1]);

		String t;
		@SuppressWarnings("unchecked")
		HashSet<Integer>[] topics = new HashSet[N];

		for (int n = 0; n < N; n++) {
			t = br.readLine();
			topics[n] = new HashSet<Integer>();
			for(int i = 0; i < t.length(); i++) {
				if(t.charAt(i) == '1')
					topics[n].add(i);
			}
		}
		
		TreeMap<Integer, Integer> res = new TreeMap<Integer, Integer>();
		
		for(int i = 0; i < topics.length; i++) {
			for(int j = i+1; j < topics.length; j++) {
				if(i == j)
					continue;
				HashSet ht = new HashSet(topics[i]);
				ht.addAll(topics[j]);
				
				Integer cnt = res.get(ht.size());
				if (cnt == null)
					cnt = 0;
				res.put(ht.size(), cnt+1);
				
			}
		}
		
		Map.Entry<Integer, Integer> et = res.lastEntry();
		System.out.println(et.getKey());
		System.out.println(et.getValue());

	}
}
