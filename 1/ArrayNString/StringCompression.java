public class StringCompression{

	public static void main(String[] args) {
		String str = "aabccccaaa"; // output: a2b1c4a3
		System.out.println(compress(str));
		System.out.println(compressStringBuilder(str));
	}

	static String compress(String str){
		String compressedString = "";
		int countConsecutive = 0;

		for (int i = 0; i < str.length(); i++) {
			countConsecutive++;
			if (i+1 >= str.length() || str.charAt(i) != str.charAt(i+1)) {
				compressedString += ""+str.charAt(i)+countConsecutive;
				countConsecutive = 0;
			}
		}
		return compressedString.length() < str.length() ? compressedString.toString() : str;
	}

	static String compressStringBuilder(String str){
		StringBuilder compressedString = new StringBuilder();
		int countConsecutive = 0;

		for (int i=0; i<str.length(); i++) {
			countConsecutive++;
			if (i+1 >= str.length() || str.charAt(i) != str.charAt(i+1)) {
				compressedString.append(str.charAt(i));
				compressedString.append(countConsecutive);
				countConsecutive = 0;
			}
		}
		return compressedString.length() < str.length() ? compressedString.toString() : str;
	}
}