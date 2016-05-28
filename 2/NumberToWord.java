public class NumberToWord{

	private String []onesPlace = {"", " One", " Two", " Three", " Four", " Five", " Six", " Seven", " Eight", " Nine", " Ten", 
								  " Eleven", " Twelve", " Thirteen", " Fourteen", " Fifteen", " Sixteen", " Seventeen", " Eighteen", " Nineteen"};
	private String []tensPlace = {"","", " Twenty", " Thirty", " Forty", " Fifty", " Sixty", " Seventy", " Eighty", " Ninety"};
	
	private String []hundredPlace = {" Hundred"};
	
	private String []thousandPlace = {"", " Thousand", " Million", " Billion", " Trillion", " Quadrillion", " Quintillion"};

	public String convert(int number){
		String inWords="";
		int current;
/*		if(number % 100 < 20){
			System.out.println(inWords);
			inWords = onesPlace[number % 100];
			System.out.println(inWords);
			return inWords;
		}else{
*/		
		if(number > 0){
			current = number % 100;
			inWords = onesPlace[current];
			//System.out.println(inWords);
			number = number / 10;

			current = number % 10;
			inWords = tensPlace[current] + inWords;
			//System.out.println(inWords);
			number = number / 10;
			
			current = number % 10;
			inWords = onesPlace[current] + hundredPlace[0] + inWords;
			//System.out.println(inWords);
			number = number / 10;

			current = number % 100;
			inWords = onesPlace[current] + thousandPlace[1] + inWords;
			System.out.println(inWords);
		}
	//	System.out.println(value);
//		inWords = tensPlace[value];
//		inWords = onesPlace[value-1];
		return null;
	}

	public static void main(String [] args){
		NumberToWord ntw = new NumberToWord();
		ntw.convert(12120);
	}
}