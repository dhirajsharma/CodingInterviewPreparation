public class Atoi{

	Atoi(String str){
		System.out.println(str);

		int number = convert(str);

		System.out.println(number);
	}

	private int convert(String str){
		char sign = '+';
		double number = 0;
		int i = 0;
		str = str.trim();
		
		if (str == null || str == "") {
			return 0;
		}else if(str.charAt(i) == '-'){
			sign = '-';
			i++;
		}

		while(str.length() > i && Character.isDigit(str.charAt(i))){
			//System.out.println(str.charAt(i)-48);
			number = number * 10 + (str.charAt(i)-48);
			//System.out.println(number);
			i++;
		}
		if (sign == '-') {
			number = -number;
		}
		return (int) number;
	}


	public static void main(String[] args) {
		String str = "-12435A";

		Atoi atoi = new Atoi(str);
	}
}