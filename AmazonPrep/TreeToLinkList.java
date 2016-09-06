public class TreeToLinkList {
	
	public void createSampleTree() {
        root = new Node(1, new Node(2, new Node(4), new Node(5)), new Node(3, new Node(6), new Node(7)));       
    }

    private Node root;
    public Node convertToDoublyLinkList(){
    	if (root == null) {
    		return null;
    	}

    	root = convertToDoublyLinkList(root);

    	while(root.getLeft() != null){
    		root = root.getLeft();
    	}

    	return root;
    }

    private Node convertToDoublyLinkList(Node currentRoot){
    	if (currentRoot.getLeft() != null) {
    		Node left = convertToDoublyLinkList(currentRoot.getLeft());
    		while(left.getRight() != null){
    			left = left.getRight();
    		}

    		left.setRight(currentRoot);
    		currentRoot.setLeft(left);
    	}

    	if (currentRoot.getRight() != null) {
    		Node right = convertToDoublyLinkList(currentRoot.getRight());
    		while(right.getLeft() != null){
    			right = right.getLeft();
    		}

    		right.setLeft(currentRoot);
    		currentRoot.setRight(right);
    	}

    	return currentRoot;
    }

    public static void printList(Node linkedList){
    	System.out.println("Output: ");
    	while(linkedList != null){
    		System.out.print(linkedList.getData() + " ");
    		linkedList = linkedList.getRight();
    	}
    	System.out.println();   	
    }

    public static void main(String[] args) {
    	TreeToLinkList tree = new TreeToLinkList();
    	tree.createSampleTree();
    	Node linkedList = tree.convertToDoublyLinkList();
    	printList(linkedList);
    }

}

class Node {
 
    private int data;
    private Node left;
    private Node right;
 
    public Node(int data, Node left, Node right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }
 
    public Node(int data) {
        this.data = data;
    }
 
    public int getData() {
        return data;
    }
 
    public void setData(int data) {
        this.data = data;
    }
 
    public Node getLeft() {
        return left;
    }
 
    public void setLeft(Node left) {
        this.left = left;
    }
 
    public Node getRight() {
        return right;
    }
 
    public void setRight(Node right) {
        this.right = right;
    }
}