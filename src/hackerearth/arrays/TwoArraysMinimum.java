package hackerearth.arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class TwoArraysMinimum {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BigInteger cons = BigInteger.valueOf(1000000007);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] line = br.readLine().split(" ");
		BigInteger a = BigInteger.valueOf(Long.parseLong(line[0]));
		BigInteger b = BigInteger.valueOf(Long.parseLong(line[1]));
		BigInteger c = BigInteger.valueOf(Long.parseLong(line[2]));

		int N = Integer.parseInt(br.readLine().trim());

		BigInteger abc = a.multiply(b).multiply(c);
		BigInteger ab = a.multiply(b);
		BigInteger bc = b.multiply(c);
		BigInteger ac = a.multiply(c);

		BigInteger a0 = ac.mod(cons);
		BigInteger a1 = (a0.multiply(abc)).mod(cons);
		a1 = a1.add(a0.multiply(ab).mod(cons));
		a1 = a1.add(a0.multiply(ac).mod(cons));
		a1 = a1.mod(BigInteger.valueOf(1000000007));

		BigInteger b0 = bc.mod(cons);
		BigInteger b1 = b0.multiply(abc).mod(cons);
		b1 = b1.add(b0.multiply(ab).mod(cons));
		b1 = b1.add(b0.multiply(bc)).mod(cons);
		b1 = b1.mod(BigInteger.valueOf(1000000007));

		BigInteger sum1 = (a0.add(b1)).mod(cons);
		BigInteger sum2 = (a1.add(b0)).mod(cons);

		System.out.println("a0: " + a0.mod(cons) + ", a1: " + a1.mod(cons));
		System.out.println("b0: " + b0.mod(cons) + ", b1: " + b1.mod(cons));

		System.out.println(sum1.mod(cons));
		System.out.println(sum2.mod(cons));
	}
}
