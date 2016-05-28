public class Palindrome{


	public static void main(String[] args) {
		//System.out.println("Hi");

		String phrase = "tacocat";
		System.out.println(isPermutationOfPalindrome(phrase));
	}

	static boolean isPermutationOfPalindrome(String phrase){
		int bitvector = createBtVector(phrase);
		return bitvector == 0 | checkExactlyOneBitSet(bitvector);
	}

	static int createBtVector(String phrase){
		int bitvector = 0;
		for (char c : phrase.toCharArray()) {
			int x = getCharNumber(c);
			bitvector = toggle(bitvector, x);
		}
		return bitvector;
	}

	static int toggle(int bitvector, int index){
		if (index<0) {
			return bitvector;
		}

		int mask = 1 << index;
		if ((bitvector & mask) == 0) {
			bitvector |= mask;
		}else{
			bitvector &= ~mask;
		}
		return bitvector;
	}

	static int getCharNumber(Character c){
		int a = Character.getNumericValue('a');
		int z = Character.getNumericValue('z');
		int val = Character.getNumericValue(c);
		if (a <= val && val <= z) {
			return val - a;
		}
		return -1;
	}

	static boolean checkExactlyOneBitSet(int bitvector){
		return (bitvector & (bitvector-1)) == 0;
	}
}