class mvcs{
	public int sumVal(int arr[]){
		int sum = 0, max = 0;
		for (int i=0;i<arr.length;i++ ) {
			sum +=arr[i];
			if (sum < 0) {
				sum = 0;
			}
			if (sum > max) {
				max = sum;
			}
		}
		return max;
	}

	public static void main(String[] args) {
		mvcs mv = new mvcs();
		int arr[] = new int[]{-2,11,-4,13,-5,2};
		int arrr[] = new int[]{1,-3,4,-2,-1,6};
		
		System.out.println(mv.sumVal(arr));
		System.out.println(mv.sumVal(arrr));
	}
}