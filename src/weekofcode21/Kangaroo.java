package weekofcode21;

import java.io.IOException;
import java.util.Scanner;

public class Kangaroo {
	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(System.in);
		int x1 = in.nextInt();
		int v1 = in.nextInt();
		int x2 = in.nextInt();
		int v2 = in.nextInt();

		int num = x1 - x2;
		int den = v2 - v1;

		if (den == 0) {
			System.out.println("NO");
			return;
		}

		if ((num % den) == 0 && (num / den) > 0) {
			System.out.println("YES");
		} else {
			System.out.println("NO");
		}
	}

}
