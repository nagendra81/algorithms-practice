package thinkingRecursively.chap8;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;

public class InstantInsanity {

	public static void main(String[] args) {
		Cube[] cubes = new Cube[4];
		cubes[0] = new Cube('W', 'B', 'B', 'R', 'G', 'G');
		cubes[1] = new Cube('W', 'W', 'G', 'B', 'R', 'G');
		cubes[2] = new Cube('R', 'R', 'W', 'B', 'W', 'G');
		cubes[3] = new Cube('G', 'R', 'R', 'R', 'B', 'W');

		System.out.println(cubes[2]);
		System.out.println(cubes[2].rotateFlip());

		boolean ok = solve(cubes, 0);
		System.out.println("solved?: " + ok);

		for (Cube cu : cubes) {
			System.out.println(cu);
		}

	}

	private static boolean solve(Cube[] cubes, int idx) {
		if (idx >= cubes.length) {
			return true;
		}

		for (char rotateCycle : Arrays.asList('L', 'R', 'U', 'D', 'F', 'F')) {
			cubes[idx] = cubes[idx].rotate(rotateCycle);
			if (isLegalPosition(cubes, idx)) {
				if (solve(cubes, idx + 1)) {
					return true;
				}
			}
			cubes[idx] = cubes[idx].rotateRevert(rotateCycle);
		}
		return false;
	}

	private static boolean isLegalPosition(Cube[] cubes, int idx) {
		Set<Character> clrs = new LinkedHashSet<>();

		for (int i = 0; i <= idx; i++) {
			if (clrs.contains(cubes[i].front)) {
				return false;
			} else
				clrs.add(cubes[i].front);
		}

		clrs.clear();
		for (int i = 0; i <= idx; i++) {
			if (clrs.contains(cubes[i].top))
				return false;
			else
				clrs.add(cubes[i].top);
		}

		clrs.clear();
		for (int i = 0; i <= idx; i++) {
			if (clrs.contains(cubes[i].back))
				return false;
			else
				clrs.add(cubes[i].back);
		}

		clrs.clear();
		for (int i = 0; i <= idx; i++) {
			if (clrs.contains(cubes[i].bottom))
				return false;
			else
				clrs.add(cubes[i].bottom);
		}
		return true;
	}

	static class Cube {
		private final char back;
		private final char left;
		private final char front;
		private final char right;
		private final char top;
		private final char bottom;

		Cube(char back, char left, char front, char right, char top, char bottom) {
			this.back = back;
			this.left = left;
			this.front = front;
			this.right = right;
			this.top = top;
			this.bottom = bottom;
		}

		Cube rotateFlip() {
			return this.rotateDown().rotateDown();
		}

		Cube rotateUp() {
			return new Cube(top, left, bottom, right, front, back);
		}

		Cube rotateDown() {
			return new Cube(bottom, left, top, right, back, front);
		}

		Cube rotateLeft() {
			return new Cube(left, front, right, back, top, bottom);
		}

		Cube rotateRight() {
			return new Cube(right, back, left, front, top, bottom);
		}

		public Cube rotateRevert(char rotateCycle) {
			switch (rotateCycle) {
			case 'U':
				return rotateDown();
			case 'L':
				return rotateRight();
			case 'D':
				return rotateUp();
			case 'R':
				return rotateLeft();
			case 'F':
				return rotateFlip();
			}
			return null;
		}

		public Cube rotate(char rotateCycle) {
			switch (rotateCycle) {
			case 'U':
				return this.rotateUp();
			case 'L':
				return this.rotateLeft();
			case 'D':
				return this.rotateDown();
			case 'R':
				return this.rotateRight();
			case 'F':
				return this.rotateFlip();
			}
			return null;
		}

		@Override
		public String toString() {
			StringBuilder sb = new StringBuilder();

			sb.append("----\n");
			sb.append(String.format("%c%c%c%c\n", ' ', ' ', top, ' '));
			sb.append(String.format("%c%c%c%c\n", back, left, front, right));
			sb.append(String.format("%c%c%c%c", ' ', ' ', bottom, ' '));

			return sb.toString();
		}

	}

	enum Color {
		R, G, B, W
	}

	enum RotateOption {
		U, D, L, R
	}

}
