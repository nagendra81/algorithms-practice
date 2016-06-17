package topcoder.recursion;

import java.util.Arrays;

public class Haar1D {

	public int[] transform(int[] data, int L) {
		return transform(data, data.length, L);
	}

	private int[] transform(int[] data, int len, int L) {
		if(L == 0) {
			return data;
		} else {
			int[] newData = Arrays.copyOf(data, data.length);
			int j = 0;
			for(int i = 0; i < len -1 ; i+=2) {
				newData[j++] = data[i] + data[i+1];
			}
			
			for(int i = 0; i < len -1 ; i+=2) {
				newData[j++] = data[i] - data[i+1];
			}
			
			return transform(newData, len/2, L-1);
		}
		
	}

	public static void main(String[] args) {
		Haar1D h1 = new Haar1D();
		int[] data = {94, 47, 46, 28, 39, 89, 75, 4, 28, 62, 69, 89, 34, 55, 81, 24};
		int L = 2;
			
		int[] res = h1.transform(data, L);
		System.out.println(Arrays.toString(res));
	}

}
