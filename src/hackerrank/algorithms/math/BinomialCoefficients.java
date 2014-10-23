package hackerrank.algorithms.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BinomialCoefficients {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		for (int i = 0; i < T; i++) {
			String[] tmp = br.readLine().split(" ");
			long N = Long.parseLong(tmp[0]);
			long P = Long.parseLong(tmp[1]);
			solve(N, P);
		}
	}

	private static void solve(long n, long p) {
		long res = 0;
		System.out.printf("n:%d p:%d\n", n, p);
		for (int k = 0; k <= n; k++) {
			long nc = modBinomial(n, k, p);
			System.out.println("k = " + k + ", ncr: " + nc);
			if (nc == 0) {
				System.out.println("add");
				res++;
			}
		}
		System.out.println(res);
	}
	
	// Use 64 bits integers to avoid overflow errors during multiplication.
	static long modPow(long a, long x, long p) {
	    //calculates a^x mod p in logarithmic time.
	    long res = 1;
	    while(x > 0) {
	        if( x % 2 != 0) {
	            res = (res * a) % p;
	        }
	        a = (a * a) % p;
	        x /= 2;
	    }
	    return res;
	}

	static long modInverse(long a, long p) {
	    //calculates the modular multiplicative of a mod m.
	    //(assuming p is prime).
	    return modPow(a, p-2, p);
	}
	static long modBinomial(long n, long k, long p) {
	// calculates C(n,k) mod p (assuming p is prime).

	    long numerator = 1; // n * (n-1) * ... * (n-k+1)
	    for (int i=0; i<k; i++) {
	        numerator = (numerator * (n-i) ) % p;
	    }
	    
	    long denominator = 1; // k!
	    for (int i=1; i<=k; i++) {
	        denominator = (denominator * i) % p;
	    }
	    
	    // numerator / denominator mod p.
	    return ( numerator* modInverse(denominator,p) ) % p;
	}

}
