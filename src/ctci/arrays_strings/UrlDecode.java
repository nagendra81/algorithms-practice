package ctci.arrays_strings;

public class UrlDecode {

	public static char[] urlDecode(char[] str)
	{
		int last = str.length -1;

		int t = 0;
		for(int i = 0; i < last; i++) {
			if(str[i] == '%' && str[i+1] == '2' && str[i+2] == '0') {
				str[i] = ' ';
				t++;

				str[i+1] = str[i+3];
				str[i+2] = str[i+4];
				
				i+=3;
				last -= 2;

			} else {
				str[t++] = str[i++];
			}
		
		}
		return str;
	}
	
	public static void main(String[] args) {
		String s = "abcd%20efghijkl";
		char[] ret = urlDecode(s.toCharArray());
		
	}
}
