public class SpiralLevelOrderTraversal{
	public static void main(String[] args) {
		SpiralLevelOrderTraversal slot = new SpiralLevelOrderTraversal();
		slot.createTree();
		System.out.println(slot.findDepth(root));
		slot.spiralTraversal();
	}


	static TreeNode root;

	public void spiralTraversal() {
		int maxDepth = findDepth(root);

		boolean rightToLeft = true;

		for (int level = 0; level < maxDepth; level++) {
			printTree(root, 0, level, rightToLeft);			
			rightToLeft = !rightToLeft;
		}
	}

	public void printTree(TreeNode currentNode, int currentLevel, int maxDepth, boolean rightToLeft){
		if (currentNode == null) {
			return;
		}

		if (currentLevel == maxDepth) {
			System.out.print(currentNode.value+", ");
			return;
		}

		if (rightToLeft) {
			printTree(currentNode.right, currentLevel+1, maxDepth, rightToLeft);
			printTree(currentNode.left, currentLevel+1, maxDepth, rightToLeft);
		}else{
			printTree(currentNode.left, currentLevel+1, maxDepth, rightToLeft);
			printTree(currentNode.right, currentLevel+1, maxDepth, rightToLeft);
		}
	}

	public int findDepth(TreeNode root){
		if (root == null) {
			return 0;
		}
		return 1 + Math.max(findDepth(root.left), findDepth(root.right));
	}

	private class TreeNode {
        TreeNode left;
        TreeNode right;
        int value;
     
        public TreeNode(int value)
        {
            this.value = value;
        }
    }

    public void createTree() {
        this.root = new TreeNode(0);
 
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);
        TreeNode n6 = new TreeNode(6);
        TreeNode n7 = new TreeNode(7);
        TreeNode n8 = new TreeNode(8);
        TreeNode n9 = new TreeNode(9);
 
        root.left  = n1;
        root.right = n2;
         
        n1.left  =  n4;
        n1.right = n5;
         
        n2.left  = n3;
        n2.right = n6;
         
        n5.left  = n7;
        n5.right = n8;
         
        n6.left  = n9;
    }
}