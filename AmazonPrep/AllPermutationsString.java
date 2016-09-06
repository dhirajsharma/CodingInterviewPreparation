/*Given a string, find all the permutations of the string.
 * For example:
 * Input String: abc
 * Output: {bca, acb, abc, cba, bac, cab}
 */

import java.util.HashSet;

public class AllPermutationsString{
	public static HashSet<String> getAllPermutationSting(String string){
		HashSet<String> permutationHashSet = new HashSet<String>();

		if ((string.length() == 0) || (string == null)) {
			permutationHashSet.add("");
			return permutationHashSet;
		}

		char firstChar = string.charAt(0);
		String remainingString = string.substring(1);

		HashSet<String> words = getAllPermutationSting(remainingString);

		for (String word : words) {
			for (int i = 0; i <= word.length(); i++) {
				String prefix = word.substring(0,i);
				String suffix = word.substring(i);
				permutationHashSet.add(prefix + firstChar + suffix);
			}
		}

		return permutationHashSet;
	}

	public static void main(String[] args) {
		String string = "abcd";
		HashSet<String> permutationHashSet = getAllPermutationSting(string);
		System.out.println(permutationHashSet.toString());
	}
	
}