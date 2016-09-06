public class BalancedBinaryTree{

	private Node root;

	public int checkBalance(Node currentRoot){
		if (currentRoot == null) {
			return 0;
		}

		int leftSubTreeHeight = checkBalance(currentRoot.leftNode);
		if (leftSubTreeHeight == -1) {
			return -1;
		}

		int rightSubTreeHeight = checkBalance(currentRoot.rightNode);
		if (rightSubTreeHeight == -1) {
			return -1;
		}

		if (Math.abs(leftSubTreeHeight - rightSubTreeHeight) > 1) {
			return -1;
		}

		return (Math.max(leftSubTreeHeight, rightSubTreeHeight) + 1);
	}

	public boolean isBalanced(){
		if (checkBalance(root) == -1) {
			return false;
		}
		return true;
	}

	public void createTree(){
		root = new Node(0, new Node(1, new Node(3, null, new Node(6, null, new Node(8))), new Node(4)), new Node(2, new Node(5, null, new Node(7)),null));
	}

	public static void main(String[] args) {
		BalancedBinaryTree tree = new BalancedBinaryTree();
		tree.createTree();
		System.out.println(tree.isBalanced());
	}
}

class Node{
	int data;
	Node leftNode;
	Node rightNode;

	public Node(int data, Node leftNode, Node rightNode){
		this.data = data;
		this.leftNode = leftNode;
		this.rightNode = rightNode;
	}

	public Node(int data){
		this.data = data;
	}
}