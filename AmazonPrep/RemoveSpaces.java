import java.util.Arrays;

public class RemoveSpaces {
	public static String removeSpaces(String strWithSpaces){
		char[] charArray = strWithSpaces.toCharArray();
		int numSpaces = 0;
		for (int i = 0; i < charArray.length; i++) {
			if (charArray[i] == ' ') {
				numSpaces++;
			} else {
				charArray[i-numSpaces] = charArray[i];
			}
		}
		charArray = Arrays.copyOf(charArray, charArray.length - numSpaces);
		return new String(charArray);
	}

	public static void main(String[] args) {
		String strWithSpaces    = "  Hi there, how  are you   doing? ";
        String strWithoutSpaces = removeSpaces(strWithSpaces);
         
        System.out.println(strWithoutSpaces);
	}
}