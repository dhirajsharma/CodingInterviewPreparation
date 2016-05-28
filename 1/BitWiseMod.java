public class BitWiseMod {
	public static void main(String[] args) {
		int[] input = {1,1,3,4,3,5,6,4,6};
		BitWiseMod bwm = new BitWiseMod();
		System.out.println(bwm.findNumber(input));
	}

	public int findNumber(int[] input){
		if (input == null || input.length == 0) {
			return Integer.MIN_VALUE;
		}
		int result = Integer.MIN_VALUE;
		int[] helperArray = new int[input.length];

		for (int i = 0; i<= input.length-1; i++) {
			helperArray[i] = 0;
		}

		//int helper = input[0];
		for (int i = 0; i<= input.length-1; i++) {
			++helperArray[input[i]];
		}

		System.out.println();
		int k;
		for (int i = 0; i<=helperArray.length-1; i++) {
			System.out.print(helperArray[i]+" | ");
			if (helperArray[i] != 0 && helperArray[i+1] != 0) {
				k = helperArray[i] < helperArray[i+1] ? i : i+1;
				result = input[k];
			}
		}

		System.out.println();

		return input[result];
	}
}