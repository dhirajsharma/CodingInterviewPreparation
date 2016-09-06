class MissingNumberInDuplicateArray {
	
	public static void missingNumberInDuplicateArray(int[] array1, int[] array2){
		if (array1 == null && array2 == null) {
			System.out.println("Invalid input");
		}else if (array1 == null) {
			if (array2.length == 1) {
				System.out.println("Missing number: " + array2[0]);
			} else {
				System.out.println("Invalid input");
			}
		} else if (array2 == null) {
			if (array1.length == 1) {
				System.out.println("Missing number :" + array1[0]);
			} else {
				System.out.println("Invalid input");
			}
		} else {
			int length1 = array1.length;
			int length2 = array2.length;

			if (Math.abs(length1-length2) != 1) {
				System.out.println("Invalid input");
				return;
			}
			if (length1 > length2) {
				findMissingNumber(array1, array2);
			} else {
				findMissingNumber(array2, array1);
			}
		}
	}

	public static void findMissingNumber(int[] array1, int[] array2){
		int result = array1[0];
		for (int i=1; i<array1.length; i++) {
			result = result^array1[i];
			System.out.println(result);
		}
		System.out.println("------");
		System.out.println(result);
		System.out.println("------");
		for (int i = 0; i<array2.length; i++) {
			result = result^array2[i];
			System.out.println(result);
		}
		System.out.println("Missing number: "+result);
	}

	public static void main(String[] args) {
        int[] array1 = {9, 7, 8, 5, 4, 6, 2, 3, 1};
        int[] array2 = {2, 3, 4, 9, 1, 8, 5, 6};
        missingNumberInDuplicateArray(array1, array2);
    }
}