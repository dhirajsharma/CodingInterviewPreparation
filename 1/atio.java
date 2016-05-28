public class atio{
	public static void main(String[] args) {
		String string = "-12344444";
		System.out.println(myAtio(string));
	}

	static int myAtio(String str){
		str = str.trim();
		System.out.println(str);
		int strLen = str.length();
		long result=0;
		// string = ""
		if (str == null || str.isEmpty()) {
			return 0;
		}

		// string = -/+
		int sign = 1;
		int i = 0;
		if (str.charAt(0) == '-') {
			sign = -1;
			i = 1;
		}else if (str.charAt(0) == '+') {
			sign = 1;
			i = 1;
		}

		while(i < strLen){
			// string = -12
			char ch = str.charAt(i);
			if (!Character.isDigit(ch)) {
				return (int)result*sign;
			}
			result = (result * 10) + ch - '0';

			if (result > Integer.MAX_VALUE) {
				return Integer.MAX_VALUE;
			}else if (result < Integer.MIN_VALUE) {
				return Integer.MIN_VALUE;
			}
			i++;
		}
		return (int)result*sign;
	}
}