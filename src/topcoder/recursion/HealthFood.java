package topcoder.recursion;

public class HealthFood {
	class Meal implements Comparable {
		int p;
		int c;
		int f;
		int t;
		int i;
		
		public Meal(int p, int c, int f, int i) {
			this.p = p;
			this.c = c;
			this.f = f;
			this.t = p * 5 + c * 5 + f * 9;
			this.i = i;
		}

		@Override
		public int compareTo(Object o) {
			return 0;
		}
	}


}
