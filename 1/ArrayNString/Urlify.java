public class Urlify{

	public static void main(String[] args) {
		String string = "Mr  John Smith   ";
		string = string.trim();
		char[] str = string.toCharArray();
		int trueLength = str.length;
		
		System.out.println(trueLength);
		replaceSpaces(str, trueLength);
	}

	static void replaceSpaces(char[] str, int trueLength){
		int spaceCount = 0, i = 0, index;
		for(i = 0; i < trueLength; i++){
			if (str[i] == ' ') {
				spaceCount++;
			}
		}

		index = trueLength + (spaceCount*2);
		char[] newStr = new char[index];
		System.out.println(index);

		if (trueLength < str.length) {
			str[trueLength] = '\0';
		}
		for (i = trueLength-1; i>=0; i--) {
			if (str[i] == ' ') {

				newStr[index - 1] = '0';
				newStr[index - 2] = '2';
				newStr[index - 3] = '%';
				index = index-3;
			}else{
				newStr[index-1] = str[i];
				index--;
			}
		}
		System.out.println(java.util.Arrays.toString(newStr));
	}
}