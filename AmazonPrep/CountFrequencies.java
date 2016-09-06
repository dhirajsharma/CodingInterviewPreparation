public class CountFrequencies {
	
	public static void countfrequenciesEfficient(int[] input){
		int n = input.length;

		for (int i=0; i<n; i++) {
			input[i]--;
		}

		for (int i=0; i<n; i++) {
			System.out.println(input[i]+" - "+n+" - "+input[i]%n+" - "+input[input[i]%n]);
			input[input[i]%n] +=n;
		}

		for (int i=0; i<n; i++) {
			System.out.println((i+1)+" "+input[i]/n);
			input[i] = input[i]%n+1;
		}
	}

	public static void main(String[] args) {
        int[] input = { 2, 3, 3, 2, 5 };
        countfrequenciesEfficient(input);
    }
}