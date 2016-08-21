package hackerrank.algorithms.stacks;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class PoisonousPlants {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		String[] line = br.readLine().split(" ");
		Plant[] plants = new Plant[N];

		for (int n = 0; n < N; n++) {
			plants[n] = new Plant(Long.parseLong(line[n]), 0);
		}
		solve(plants);

	}

	private static void solve(Plant[] plants) {
		Stack<Plant> stack = new Stack<>();

		for (int i = 0; i < plants.length; i++) {
			Plant p = plants[i];
			int maxDays = -1;
			while (!stack.isEmpty() && p.pesticide <= stack.peek().pesticide) {
				Plant next = stack.pop();
				if (p.pesticide > next.pesticide) {
					if (maxDays != -1) {
						p.days = maxDays + 1;
					} else {
						p.days = 1;
					}
					break;
				} else {
					maxDays = Math.max(next.days, maxDays);
				}
			}
			stack.push(p);
		}

		for (Plant p : stack) {
			System.out.println(p.days);
		}
	}

	static class Plant {
		long pesticide;
		int days;

		Plant(long pesticide, int days) {
			this.pesticide = pesticide;
			this.days = days;
		}

		@Override
		public String toString() {
			return "Pest: " + pesticide + ", days: " + days;
		}

	}
}
