package test;

public class LowerRange {
	
	public static void main(String[] args) {
		String s = "Hello, World";
		String t = "Hello, Worl";
		if(s == t) {
			System.out.println("Trueeeee1");
		}
		t = "Hello, World";
		if(s == t) {
			System.out.println("Trueeeee2");
		}
	}
	public int lower_range(int[] arr, int start, int end, int key) {
		int mid = (start + end) / 2;
		if (arr[mid] == key) {
			return key;
		} else if (mid == 0 || mid == arr.length - 1) {
			return arr[mid];
		} else if (arr[mid - 1] < key && key < arr[mid + 1]) {
			return arr[mid + 1];
		} else if (arr[mid] > key) {
			return lower_range(arr, start, mid - 1, key);
		} else {
			return lower_range(arr, mid + 1, end, key);
		}
	}
}
