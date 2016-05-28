public class IsUnique{
	 static String string = "dhirajsharma";

	 public static void main(String[] args) {
	 	System.out.println(isUniqueChars(string));
	 }

	 static boolean isUniqueChars(String string){
	 	int checker = 0;
	 	for (int i = 0; i < string.length(); i++) {
	 		int val = string.charAt(i) - 'a';

	 		System.out.println(val + " --> "+(1 << val));

	 		if ((checker & (1 << val)) > 0) {
	 			System.out.println("who is right???");
	 			return false;
	 		}
	 		checker |= (1 << val); 
	 		System.out.println((checker));
	 	}

	 	return true;
	 }

}
