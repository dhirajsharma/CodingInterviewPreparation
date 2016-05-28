
import java.util.*;

public class PartitionProblem{
	public static void main(String[] args) {
		int[] inputSet = {3,6,7,5,3,2,1,5,4,2,2};
		PartitionProblem solution = new PartitionProblem();
		System.out.println(solution.partitionExists(inputSet));
	}

	public boolean partitionExists(int[] inputSet){
		int sum = 0;
		for (int input : inputSet) {
			sum += input;
		}
		System.out.println(sum);

		if (sum % 2 != 0) {
			System.out.println("Partition not possible");
			return false;
		}

		return partitions(inputSet, sum/2);
	}

	public boolean partitions(int[] inputSet, int halfOfSum){
		int localSum = 0;
		ArrayList<ArrayList<Integer>> numbers = new ArrayList<ArrayList<Integer>>();
		
		for (int i = 0; i<= inputSet.length-1; i++) {
			localSum = inputSet[i];
			numbers.add(new ArrayList<Integer>());
			numbers.get(i).add(inputSet[i]);
			for (int j = i+1; j<= inputSet.length-1; j++) {
				localSum += inputSet[j];
				numbers.get(i).add(inputSet[j]);
//				System.out.println(Arrays.toString(numbers.toArray()));

				if (halfOfSum == localSum) {
					System.out.println("Doone ");
					System.out.println(Arrays.toString(numbers.get(i).toArray()));
					return true;
				}
			}
		}
//		System.out.println(Arrays.toString(numbers.toArray()));
		return false;
	}
}