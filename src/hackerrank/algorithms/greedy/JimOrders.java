package hackerrank.algorithms.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;

public class JimOrders {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine().trim());

		PriorityQueue<Customer> q = new PriorityQueue<>();
		for (int i = 0; i < N; i++) {
			String[] line = br.readLine().split(" ");
			Customer c = new Customer(i + 1, Integer.parseInt(line[0].trim()), Integer.parseInt(line[1].trim()));
			q.add(c);
		}

		StringBuilder sb = new StringBuilder();
		while (!q.isEmpty()) {
			Customer c = q.remove();
			sb.append(c.id + " ");
		}
		System.out.println(sb.toString().trim());

	}

	static class Customer implements Comparable<JimOrders.Customer> {
		int id;
		int ti;
		int di;

		Customer(int id, int ti, int di) {
			this.id = id;
			this.ti = ti;
			this.di = di;
		}

		@Override
		public int compareTo(Customer that) {
			int cmp = Integer.compare(this.ti + this.di, that.ti + that.di);
			if (cmp != 0) {
				return cmp;
			}
			return Integer.compare(this.id, that.id);
		}

		@Override
		public boolean equals(Object obj) {
			Customer that = (Customer) obj;
			return this.id == that.id && this.ti == that.ti && this.di == that.di;
		}

		@Override
		public int hashCode() {
			int[] arr = { this.id, this.ti, this.di };
			return Arrays.hashCode(arr);
		}

	}

}
