package test;

public class Convert5 {

	int convertfive(int num) {
		if (num >= 10) {
			int res = convertfive(num / 10);
			res = res * 10 + ((num % 10) == 0 ? 5 : num % 10);
			return res;
		} else {
			return num == 0 ? 5 : num;
		}

	}

	public static void main(String[] args) {
		Convert5 con = new Convert5();
		System.out.println(con.convertfive(107));

	}

}
