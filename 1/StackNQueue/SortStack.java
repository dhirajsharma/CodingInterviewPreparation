public class SortStack{
	public static void main(String[] args) {
		int[] stack = new int[]{-5,14,-3,18,-2,30}; // 30, 18,14,-3,-5
		int top = 5;
		final long startTime = System.currentTimeMillis();
		sortStack(stack, top);

		System.out.println(java.util.Arrays.toString(stack));

		final long endTime = System.currentTimeMillis();

		System.out.println("Total execution time: " + (endTime - startTime) );
	}

	static void sortStack(int[] stack, int top){
		System.out.println(java.util.Arrays.toString(stack)+" "+"top:- "+top);
		int temp;

		for (int i = top; i > 0; i--) {
			if(stack[i-1] < stack[i]){
				temp = stack[i];
				stack[i] = stack[i-1];
				stack[i-1] = temp;
				sortStack(stack, top);
			}
		}
	}
}