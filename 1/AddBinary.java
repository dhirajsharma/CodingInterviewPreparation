public class AddBinary{
	public static void main(String[] args) {
		String a = "1010";
		String b = "1101";
		AddBinary addBinary = new AddBinary();
		System.out.println(addBinary.add(a,b));
	}

	public String add(String a, String b){
		if (a == null || b == null) {
			return null;
		}
		
		int carry = 0;
		int i = a.length()-1;
		int j = b.length()-1;
		StringBuilder str = new StringBuilder();

		while(i >= 0 && j >= 0){
			int av = (a.charAt(i) == '0') ? 0:1;
			int bv = (b.charAt(i) == '0') ? 0:1;

			int v = av + bv + carry;
			str.append(v%2);
			carry = v/2;
			i--;
			j--;
		}

		while(i>=0){
			int av = (a.charAt(i) == '0') ? 0:1;
			int v = av + carry;
			str.append(v%2);
			carry = v/2;
			i--;
		}

		while(j>=0){
			int bv = (b.charAt(j) == '0') ? 0:1;
			int v = bv + carry;
			str.append(v%2);
			carry = v/2;
			j--;
		}

		if (carry == 1) {
			str.append(1);
		}

		return str.reverse().toString();
	}
}