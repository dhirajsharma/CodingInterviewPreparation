public class MirrorTree {

	private Node root;


	/*
				1								1
		2				3				3				2
	4		5		6		7		7		6		5		4

	*/
	public static Node createTree(){
		return new Node(1, new Node(2, new Node(4), new Node(5)), new Node(3, new Node(6), new Node(7)));
	}

	public static Node createMirrorTree(){
		return new Node(1, new Node(3, new Node(7), new Node(6)), new Node(2, new Node(5), new Node(4)));
	}

	public static boolean isMirrorTree(Node root1, Node root2){
		if (root1 == null && root2 == null) {
			return true;
		}

		if ((root1 == null && root2 != null)&& (root1 != null && root2 == null)) {
			return true;
		}

		if (root1 != null && root2 != null) {
			return (root1.getValue() == root2.getValue()) &&
				   (isMirrorTree(root1.getLeftNode(), root2.getRightNode())) &&
				   (isMirrorTree(root1.getRightNode(), root2.getLeftNode()));
		}

		return false;
	}


	public static void main(String[] args) {
		Node root1 = MirrorTree.createTree();
		Node root2 = MirrorTree.createMirrorTree();
		System.out.println(MirrorTree.isMirrorTree(root1, root2) ? "Mirror" : "Not Mirror");
	}
}

class Node {
	int data;
	Node leftNode;
	Node rightNode;

	public Node(int data){
		this.data = data;
	}

	public Node(int data, Node leftNode, Node rightNode){
		this.data = data;
		this.leftNode = leftNode;
		this.rightNode = rightNode;
	}

	public int getValue(){
		return data;
	}

	public Node getLeftNode(){
		return leftNode;
	}

	public Node getRightNode(){
		return rightNode;
	}
}