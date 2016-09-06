/*
 Remove all nodes which lie on path having sum less than k.
*/


public class RemoveNodeTree {
	private Node root;
	public void createTree(){
		root = new Node(1);
		Node n2 = new Node(2);
		Node n3 = new Node(3);
		Node n4 = new Node(4);
		Node n5 = new Node(5);
		Node n6 = new Node(6);
		Node n7 = new Node(7);
		Node n8 = new Node(8);
		Node n9 = new Node(9);
		Node n10 = new Node(10);

		root.leftNode = n2;
		root.rightNode = n3;
		n3.leftNode = n4;
		n3.rightNode = n5;
		n4.leftNode = n6;
		n5.rightNode = n7;
		n6.rightNode = n8;
		n7.leftNode = n9;
		n9.leftNode = n10;
	}

	public void deleteNode(int initialSum){
		int[] sum = new int[1];
		deleteNode(root, sum, initialSum);
		if (sum[0] < initialSum) {
			root = null;
		}
	}

	public Node deleteNode(Node node, int[] sum, int initialSum){
		if (node == null) {
			return null;
		}
		int[] leftSum = new int[1];
		int[] rightSum = new int[1];

		leftSum[0] = rightSum[0] = sum[0] + node.data;

		node.leftNode = deleteNode(node.leftNode, leftSum, initialSum);
		node.rightNode = deleteNode(node.rightNode, rightSum, initialSum);

		sum[0] = leftSum[0] > rightSum[0] ? leftSum[0] : rightSum[0];

		System.out.println("Sum "+ sum[0]);
		if (sum[0] < initialSum) {
			node = null;
		}
		return node;
	}

	public void printPreorder(){
		printPreorder(root);
	}

	public void printPreorder(Node node){
		if (node == null) {
			return;
		}
		System.out.println(node.data + " ");
		printPreorder(node.leftNode);
		printPreorder(node.rightNode);
	}

	public static void main(String[] args) {
		RemoveNodeTree tree = new RemoveNodeTree();
		tree.createTree();
		tree.printPreorder();
		tree.deleteNode(23);
		tree.printPreorder();
	}
}

class Node {
	int data;
	Node leftNode;
	Node rightNode;

	public Node(int data, Node leftNode, Node rightNode){
		this.leftNode = leftNode;
		this.rightNode = rightNode;
		this.data = data;
	}

	public Node(int data){
		this.data =data;
	}
}