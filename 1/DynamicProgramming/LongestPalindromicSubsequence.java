public class LongestPalindromicSubsequence{
		
	public static void main(String[] args) {
		String input = "GEEKSFOOORGEEKS";
		char inputArray[] = input.toCharArray();
		
		int len = inputArray.length;
		LongestPalindromicSubsequence longestPalindromicSubsequence = new LongestPalindromicSubsequence();

		System.out.println(longestPalindromicSubsequence.lps(inputArray, 0, len-1));
	}

	public int lps(char[] inputArray, int start, int end){
		
		if (start == end) {
			System.out.println("--1--");
			return 1;
		}
		if (inputArray[start] == inputArray[end] && start+1 == end) {
			System.out.println("--2--");
			return 2;
		}
		if (inputArray[start] == inputArray[end]) {
			return 2+lps(inputArray, start+1, end-1);
		}
		return max(lps(inputArray, start, end-1),lps(inputArray,start+1,end));
	}

	public int max(int x, int y){
		return x>y?x:y;
	}
}