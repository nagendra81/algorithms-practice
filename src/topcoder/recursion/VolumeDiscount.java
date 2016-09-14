package topcoder.recursion;

public class VolumeDiscount {
	public static void main(String[] args) {
		VolumeDiscount vd = new VolumeDiscount();
		String[] priceList = { "99 913", "97 173", "50 464", "80 565" };
		int quantity = 18;

		int ans = vd.bestDeal(priceList, quantity);
		System.out.println(ans);

	}

	public int bestDeal(String[] priceList, int quantity) {
		int N = priceList.length;
		int[] units = new int[N];
		int[] price = new int[N];

		BundlePrice[] bundles = new BundlePrice[N];

		for (int i = 0; i < priceList.length; i++) {
			String[] line = priceList[i].split(" ");
			int u = Integer.parseInt(line[0]);
			int p = Integer.parseInt(line[1]);
			units[i] = u;
			price[i] = p;
			bundles[i] = new BundlePrice(u, p);

		}

		/*
		 * System.out.println(Arrays.toString(units));
		 * System.out.println(Arrays.toString(price));
		 * System.out.println(Arrays.toString(bundles));
		 */
		return compute(bundles, quantity);
	}

	private int compute(BundlePrice[] bundles, int Q) {
		if (Q <= 0) {
			return 0;
		}

		int[] dp = new int[Q + 1];

		dp[0] = 0;

		for (int q = 1; q <= Q; q++) {
			int best = Integer.MAX_VALUE;
			for (BundlePrice bp : bundles) {
				if (bp.units <= q) {
					best = Math.min(best, bp.price + dp[q - bp.units]);
				} else {
					best = Math.min(best, bp.price);
				}
			}
			dp[q] = best;
		}

		return dp[Q];

	}

	static class BundlePrice implements Comparable<BundlePrice> {
		int units;
		int price;

		BundlePrice(int units, int price) {
			this.units = units;
			this.price = price;
		}

		@Override
		public int compareTo(BundlePrice that) {
			if (this.units == that.units) {
				return Integer.compare(this.price, that.price);
			} else {
				return Integer.compare(this.units, that.units);
			}
		}

		@Override
		public String toString() {
			return String.format("[U=%d,P=%d]", units, price);
		}

	}
}
