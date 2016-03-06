package topcoder.recursion;

public class TruckLoads {
	public int numTrucks(int n, int lo) {
		if (n <= lo) {
			return 1;
		} else {
			return numTrucks(n/2, lo) + numTrucks((n/2) + (n%2), lo);
		}
	}

	public static void main(String[] args) {
		TruckLoads tl = new TruckLoads();

		int n = 1024;
		int lo = 8;
		int res = tl.numTrucks(n, lo);
		System.out.println(res);

	}

}
