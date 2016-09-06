public class IdenticalTree {
	private Node root;

	public static Node createTree(){
		return new Node(1, new Node(2, new Node(4), new Node(5)), new Node(3, new Node(6), new Node(7)));
	}

	public static boolean checkIdenticalTree(Node root1, Node root2) {
		if (root1 == null && root2 == null) {
			return true;
		}

		if ((root1 == null && root2 != null) || (root1 != null && root2 == null)) {
			return false;
		}

		if (root1 != null && root2 != null) {
			return (root1.getValue() == root2.getValue() && 
					checkIdenticalTree(root1.getLeftNode(), root2.getLeftNode()) && 
					checkIdenticalTree(root1.getRightNode(), root2.getRightNode()));
		}
		return false;
	}

	public static void main(String[] args) {
		Node root1 = IdenticalTree.createTree();
		Node root2 = IdenticalTree.createTree();
		System.out.println(IdenticalTree.checkIdenticalTree(root1, root2) ? "Identical" : "Not Identical");
	}
}


class Node {
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

	public Node getLeftNode(){
		return leftNode;
	}

	public Node getRightNode(){
		return rightNode;
	}

	public int getValue(){
		return data;
	}
}