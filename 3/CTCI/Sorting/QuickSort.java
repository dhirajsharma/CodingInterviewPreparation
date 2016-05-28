import java.util.*;
public class QuickSort{

	int[] numbers;
	int[] lArray;
	int[] rArray;

	public void sort(int[] array){
		this.numbers = array;
		System.out.println(Arrays.toString(numbers));
		int pivot = (numbers.length-1)/2;
		System.out.println(pivot);

		int[] lArray = new int[numbers.length];
		int[] rArray = new int[numbers.length];

		int i =0;
		int j =0;
		int k =0;

		for (i = 0; i < numbers.length; i++) {
			if (numbers[i] < numbers[pivot]) {
				lArray[j] = numbers[i];
				j++;
			}else if (numbers[i] == numbers[pivot]) {
				lArray[j] = -1;
				j++;
			}else{
				rArray[k] = numbers[i];
				k++;
			}
		}

		/*for (int i = 0; i < numbers.length; i++) {
			
		}*/

		System.out.println(Arrays.toString(lArray));
		System.out.println(Arrays.toString(rArray));
	}

/*	public quickSort(){

	}*/


	public static void main(String[] args){
		QuickSort qs = new QuickSort();
		int[] array = {8, 4, 1, 6, 7, 2, 5, 3};
		qs.sort(array);
	}
}