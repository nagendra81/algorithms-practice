package hackerrank.algorithms.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class TeamFormation {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine().trim());
		List<int[]> skillList = new ArrayList<>();

		for (int t = 0; t < T; t++) {
			String[] line = br.readLine().split(" ");
			int N = Integer.parseInt(line[0]);

			int[] skills = new int[N];
			for (int i = 1; i < line.length; i++) {
				skills[i - 1] = Integer.parseInt(line[i]);
			}
			skillList.add(skills);
		}

		List<Integer> results = new ArrayList<Integer>();
		for (int[] skills : skillList) {
			if (skills.length == 0) {
				results.add(0);
			} else {
				int res = solve(skills);
				results.add(res);

			}
		}

		for (int res : results) {
			System.out.println(res);
		}

	}

	private static int solve(int[] skills) {
		Arrays.sort(skills);
		System.out.println(Arrays.toString(skills));
		PriorityQueue<TeamEntry> pq = new PriorityQueue<>();
		List<TeamEntry> tmp = new ArrayList<>();

		int currMinSize = Integer.MAX_VALUE;

		for (int sk : skills) {
			// System.out.println("Curr skill: " + sk);
			if (pq.isEmpty()) {
				pq.add(new TeamEntry(sk));
				continue;
			}

			TeamEntry tq = null;
			boolean added = false;
			while (!pq.isEmpty()) {
				tq = pq.poll();
				if (sk - tq.getLast() == 1) {
					tmp.remove(tq);
					tq.add(sk);
					added = true;
					break;
				} else if (sk - tq.getLast() > 1) {
					// drop team;
					currMinSize = Math.min(tq.size, currMinSize);
					tmp.remove(tq);

				} else {
					// System.out.println(tq);
					tmp.add(tq);
				}
			}
			if (!added) {
				tq = new TeamEntry(sk);
			}
			pq.add(tq);
			if (!tmp.isEmpty()) {
				pq.addAll(tmp);
			}
			tmp.clear();
			System.out.println("******** Curr skill: " + sk);
			System.out.println("pq: " + pq);

		}
		return Math.min(pq.peek().size(), currMinSize);
	}

	private static class TeamEntry implements Comparable<TeamEntry> {
		int last;
		int size;

		public TeamEntry(int sk) {
			last = sk;
			size = 1;
		}

		@Override
		public int compareTo(TeamEntry that) {
			return Integer.compare(this.size, that.size);
		}

		public void add(int sk) {
			this.last = sk;
			size++;
		}

		public int getLast() {
			return this.last;
		}

		public int size() {
			return size;
		}

		@Override
		public String toString() {
			return String.format("(%d,%d )", last, size);
		}
	}
}
