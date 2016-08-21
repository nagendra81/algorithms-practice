package hackerrank.algorithms.warmup;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class IsFibo {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		for (int t = 0; t < T; t++) {
			long N = Long.parseLong(br.readLine());
			if (isPerfectSquare(5 * N * N + 4) || isPerfectSquare(5 * N * N - 4))
				System.out.println("IsFibo");
			else
				System.out.println("IsNotFibo");
		}

	}

	private final static boolean isPerfectSquare(long n)
	{
	  if (n < 0)
	    return false;

	  switch((int)(n & 0x3F))
	  {
	  case 0x00: case 0x01: case 0x04: case 0x09: case 0x10: case 0x11:
	  case 0x19: case 0x21: case 0x24: case 0x29: case 0x31: case 0x39:
	    long sqrt;
	    if(n < 410881L)
	    {
	      //John Carmack hack, converted to Java.
	      // See: http://www.codemaestro.com/reviews/9
	      int i;
	      float x2, y;

	      x2 = n * 0.5F;
	      y  = n;
	      i  = Float.floatToRawIntBits(y);
	      i  = 0x5f3759df - ( i >> 1 );
	      y  = Float.intBitsToFloat(i);
	      y  = y * ( 1.5F - ( x2 * y * y ) );

	      sqrt = (long)(1.0F/y);
	    }
	    else
	    {
	      //Carmack hack gives incorrect answer for n >= 410881.
	      sqrt = (long)Math.sqrt(n);
	    }
	    return sqrt*sqrt == n;

	  default:
	    return false;
	  }
	}

}
