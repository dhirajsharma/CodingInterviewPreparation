public class FindMissingNumber {
	public static void main(String[] args) {
		// 1,2,3,4,5,6
		int[] numberSequence = new int[]{1,2,3,4,5,6,8};
		for (int value : numberSequence) {
			System.out.print("|"+value);
		}
		System.out.println("|");
		FindMissingNumber solution = new FindMissingNumber();
		System.out.println(solution.findNumber(numberSequence, 0, numberSequence.length-1));
	}

	public int findNumber(int[] numberSequence, int low, int high) {
		if (numberSequence == null || numberSequence.length == 0 || low < 0 || high > numberSequence.length || high < low) {
			return -1;
		}

		if (low == high) {
			return numberSequence[high]-1;
		}

		int mid = (low+high)/2;

		if (mid+1 == numberSequence[mid]) {
			return findNumber(numberSequence, mid+1, high);
		}else{
			return findNumber(numberSequence, low, mid);
		}
	}
}