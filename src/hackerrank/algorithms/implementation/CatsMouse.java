package hackerrank.algorithms.implementation;

import java.util.Scanner;

public class CatsMouse {
	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			int q = sc.nextInt();

			for (int i = 0; i < q; i++) {
				int x = sc.nextInt();
				int y = sc.nextInt();
				int z = sc.nextInt();

				if (abs(x, z) == abs(y, z)) {
					System.out.println("Mouse C");
				} else if (abs(x, z) < abs(y, z)) {
					System.out.println("Cat A");
				} else {
					System.out.println("Cat B");
				}
			}
		}
	}

	private static int abs(int x, int z) {
		if (x < z)
			return z - x;
		return x - z;
	}

}
