import java.util.*;
public class MaxAvgSubArray {
	public static void main(String[] args) {
		int[] input = {11, -8, 16, -7, 24, -2, 3};
        int size = 3;
        printMaxAvgSubarray(input, size);
	}

	public static void printMaxAvgSubarray(int[] input, int size) {
		if (input == null || input.length <= 0 || input.length < size) {
			System.out.println("Invalid input");
			return;
		}
		if (size == input.length) {
			System.out.println("Complete array: "+Arrays.toString(input));
			return;
		}
		int max = 0;
		int maxIndex = 0;
		for (int i = 0; i<=(input.length-1)-size; i++) {
			for (int j=i; j<=i+size; j++) {
				int temp = input[i]+input[i+1]+input[i+2];
				if (temp > max) {
					maxIndex = i;
				}
				max = Math.max(max, temp);
			}
		}
		for (int i=maxIndex; i<maxIndex+size; i++) {
			System.out.print(input[i]+",");
		}
		System.out.println("\n"+max);
	}
}