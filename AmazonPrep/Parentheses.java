public class Parentheses {
	
	public static boolean isValid(String string){
		if (string == null || string == ""){
			return false;
		}
		int count = 0;
		int i = 0;
		while(i < string.length()){
			char ch = string.charAt(i);
			if (ch == '(') {
				count++;
			}else if (ch == ')') {
				if (count != 0) {
					count--;
				}else {
					return false;
				}
			}
			i++;
		}

		if (count != 0) {
			return false;
		}
		return true;
	}

	public static void main(String[] args) {
		String string = "((BCD)AE)";
        System.out.println("isValid: " + isValid(string));
        string = ")(PH)N(X)";
        System.out.println("isValid: " + isValid(string));
	}
}