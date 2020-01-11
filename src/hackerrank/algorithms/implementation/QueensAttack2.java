package hackerrank.algorithms.implementation;

import java.util.HashSet;
import java.util.Objects;
import java.util.Scanner;
import java.util.Set;

public class QueensAttack2 {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			int n = sc.nextInt();
			int k = sc.nextInt();

			int qx = sc.nextInt();
			int qy = sc.nextInt();

			Set<Point> obs = new HashSet<>();

			for (int i = 0; i < k; i++) {
				Point p = Point.of(sc.nextInt(), sc.nextInt());
				obs.add(p);
			}

			int res = 0;
			res += moveUp(n, qx, qy, obs);
			res += moveDown(n, qx, qy, obs);
			res += moveLeft(n, qx, qy, obs);
			res += moveRight(n, qx, qy, obs);
			res += moveDiagLeftUp(n, qx, qy, obs);
			res += moveDiagLeftDown(n, qx, qy, obs);
			res += moveDiagRightUp(n, qx, qy, obs);
			res += moveDiagRightDown(n, qx, qy, obs);

			System.out.println(res);

		}
	}

	private static int moveUp(int n, int qx, int qy, Set<Point> obs) {
		int cnt = 0;
		for (int i = qx + 1; i <= n; i++) {
			if (obs.contains(Point.of(i, qy))) {
				break;
			}
			cnt++;
		}
		return cnt;
	}

	private static int moveDown(int n, int qx, int qy, Set<Point> obs) {
		int cnt = 0;
		for (int i = qx - 1; i >= 1; i--) {
			if (obs.contains(Point.of(i, qy))) {
				break;
			}
			cnt++;
		}
		return cnt;
	}

	private static int moveLeft(int n, int qx, int qy, Set<Point> obs) {
		int cnt = 0;
		for (int i = qy - 1; i >= 1; i--) {
			if (obs.contains(Point.of(qx, i))) {
				break;
			}
			cnt++;
		}
		return cnt;
	}

	private static int moveRight(int n, int qx, int qy, Set<Point> obs) {
		int cnt = 0;
		for (int i = qy + 1; i <= n; i++) {
			if (obs.contains(Point.of(qx, i))) {
				break;
			}
			cnt++;
		}
		return cnt;
	}

	private static int moveDiagLeftUp(int n, int qx, int qy, Set<Point> obs) {
		int cnt = 0;
		for (int i = qx + 1, j = qy - 1; i <= n && j >= 1; i++, j--) {
			if (obs.contains(Point.of(i, j))) {
				break;
			}
			cnt++;
		}
		return cnt;
	}

	private static int moveDiagLeftDown(int n, int qx, int qy, Set<Point> obs) {
		int cnt = 0;
		for (int i = qx - 1, j = qy - 1; i >= 1 && j >= 1; i--, j--) {
			if (obs.contains(Point.of(i, j))) {
				break;
			}
			cnt++;
		}
		return cnt;
	}

	private static int moveDiagRightUp(int n, int qx, int qy, Set<Point> obs) {
		int cnt = 0;
		for (int i = qx + 1, j = qy + 1; i <= n && j <= n; i++, j++) {
			if (obs.contains(Point.of(i, j))) {
				break;
			}
			cnt++;
		}
		return cnt;
	}

	private static int moveDiagRightDown(int n, int qx, int qy, Set<Point> obs) {
		int cnt = 0;
		for (int i = qx - 1, j = qy + 1; i >= 1 && j <= n; i--, j++) {
			if (obs.contains(Point.of(i, j))) {
				break;
			}
			cnt++;
		}
		return cnt;
	}

	static class Point {
		public final int x;
		public final int y;

		private Point(int x, int y) {
			this.x = x;
			this.y = y;
		}

		public static Point of(int x, int y) {
			return new Point(x, y);
		}

		@Override
		public boolean equals(Object obj) {
			Point that = (Point) obj;
			return this.x == that.x && this.y == that.y;
		}

		@Override
		public int hashCode() {
			return Objects.hash(this.x, this.y);
		}
	}
}
