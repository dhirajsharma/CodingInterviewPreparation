

public class reverse {

	public static String reverse(char []strChar){
		StringBuilder str = new StringBuilder();
		int start = 0;
		int end = 0;

		for (int i=0; i<strChar.length; i++) {
			if(strChar[i] == ' '){
				end = i;
				reverse(strChar, str, start, end);
				start = end;
			}else if(i == strChar.length-1) {
				end = i;
				reverse(strChar, str, start, end);
			}
		}
		if(start == 0 && end == strChar.length-1){
			reverse(strChar, str, start, end);
		}

		return str.toString();
	}

	public static String reverse(char[] strChar, StringBuilder str, int start, int end){
		for (int i=end; i>=start; i--) {
			str.append(strChar[i]);
		}
		return str.toString();
	}

	public static void main(String[] args) {
		String input = "Dhiraj's Kumar Sharma";

		//String input = args[0];
		char[] strChar = input.toCharArray();

		System.out.println(reverse(strChar));

	}
}