public class MinimalTree{

	public static void main(String[] args) {
		
	}

	static TreeNode createMinimalTree(int array[]){
		createMinimalTree(array, 0, array.length());
	}

	static TreeNode createMinimalTree(int array[], int start, int end){
		if (end < start) {
			return null;
		}
		int mid = (start + end)/2;
		TreeNode root = new TreeNode(array[mid]);
		root.left = createMinimalTree(array, start, mid-1);
		root.right = createMinimalTree(array, mid+1, end);
		return root;
	}
}