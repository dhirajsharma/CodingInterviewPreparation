public class BinarySearchTree {
	private Node root;

	public void createTree(){
		root = new Node(4, new Node(2, new Node(1), new Node(3)), new Node(6,new Node(5), new Node(7)));
	}

	public boolean isBinarySearchTree(){
		return isBinarySearchTree(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}

	public boolean isBinarySearchTree(Node root, int low, int high){
		if (root == null) {
			return true;
		}
		if (root.data <= low || root.data >= high) {
			return false;
		}

		return isBinarySearchTree(root.leftNode, low, root.data) && isBinarySearchTree(root.rightNode, root.data, high);
	}

	public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();
        tree.createTree();
        System.out.println(tree.isBinarySearchTree());
    }
}

class Node{
	int data;
	Node leftNode;
	Node rightNode;

	public Node(int data, Node leftNode,Node rightNode){
		this.data = data;
		this.leftNode = leftNode;
		this.rightNode = rightNode;
	}

	public Node(int data){
		this.data = data;
	}
}