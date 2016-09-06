
/**
 * Given two nodes in a binary tree, check if they are cousins.
 * Two nodes are cousins if: 
 * 1: they are not siblings.
 * 2: they are on the same level.
 * 
 */


public class Tree {
	private Node root;

	public void setRoot(Node root){
		this.root = root;
	}

	public boolean isCousin(Node node1, Node node2){
		if (node1 == node2) {
			return false;
		}
		return (!isSiblings(node1,node2) && getLevel(node1) == getLevel(node2));
	}

	public boolean isSiblings(Node node1, Node node2){
		return isSiblings(root, node1, node2);
	}

	public boolean isSiblings(Node root, Node node1, Node node2){
		if (root == null) {
			return false;
		}
		return ((root.leftNode == node1 && root.rightNode == node2) || (root.rightNode == node1 && root.leftNode == node2) || isSiblings(root.leftNode, node1, node2) || isSiblings(root.rightNode, node1, node2));
	}

	public int getLevel(Node node){
		return getLevel(root, node, 1);
	}

	public int getLevel(Node root, Node node, int currentLevel){
		if (root == null) {
			return 0;
		}
		if (root == node) {
			return currentLevel;
		}
		int level = getLevel(root.leftNode, node, currentLevel+1);
		if (level != 0) {
			return level;
		}else {
			return getLevel(root.rightNode, node, currentLevel+1);
		}
	}

	public static void main(String[] args) {
		Tree tree = new Tree();
		Node root = new Node(1);
		Node n2 = new Node(2);
		Node n3 = new Node(3);
        Node n4 = new Node(4);
        Node n5 = new Node(5);
        Node n6 = new Node(6);
        Node n7 = new Node(7);
 
        root.leftNode = n2;
        root.rightNode = n3;
 
        n2.leftNode = n4;
        n2.rightNode = n5;
         
        n3.leftNode = n6;
        n3.rightNode = n7;

        tree.setRoot(root);


		System.out.println(tree.isCousin(n5,n6)? "cousins" : "not cousins");
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
}