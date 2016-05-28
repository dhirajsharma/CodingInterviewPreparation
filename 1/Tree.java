import java.util.*;
public class Tree {
	private TreeNode root;

	class TreeNode{
		private int value;
		private TreeNode leftChild;
		private TreeNode rightChild;
		public TreeNode(int value){
			this.value = value;
		}
	}	

	public void createTree() {
        root = new TreeNode(5);
        root.leftChild = new TreeNode(4);
        root.rightChild = new TreeNode(6);
        root.leftChild.leftChild = new TreeNode(3);
        root.leftChild.rightChild = new TreeNode(7);
        root.rightChild.leftChild = new TreeNode(8);
    }

	public void preOrder(){
		TreeNode topNode;
		if (root == null) {
			return;
		}

		Stack<TreeNode> nodeStack = new Stack<TreeNode>();
		nodeStack.push(root);

		while(!nodeStack.empty()){
			topNode = nodeStack.pop();
			System.out.print(topNode.value+" | ");
			if (topNode.rightChild != null) {
				nodeStack.push(topNode.rightChild);
			}
			
			if (topNode.leftChild != null) {
				nodeStack.push(topNode.leftChild);
			}
			
		}
	}

	public static void main(String args[]) {
		Tree tree = new Tree();
        tree.createTree();
        tree.preOrder();
        System.out.println();
    }
}