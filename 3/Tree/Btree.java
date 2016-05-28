public class Btree {
	Node root;

	public void addNode(int num){
		Node newNode = new Node(num);
		if (root == null) {
			root = newNode;
		}else{
			Node focusNode = root;
			Node parent;
			while(true){
				parent = focusNode;

				if(num < focusNode.key){
					focusNode = focusNode.leftNode;
					if (focusNode == null) {
						parent.leftNode = newNode;
						return;
					}
				}else{
					focusNode = focusNode.rightNode;
					if (focusNode == null) {
						parent.rightNode = newNode;
						return;
					}
				}
			}
		}
	}

	public void inOrder(Node focusNode){
		if (focusNode != null) {
			inOrder(focusNode.leftNode);
			System.out.print(focusNode);
			inOrder(focusNode.rightNode);
		}
	}

	public void preOrder(Node focusNode){
		if (focusNode != null) {
			System.out.println(focusNode);
			preOrder(focusNode.leftNode);
			preOrder(focusNode.rightNode);
		}
	}

	public void postOrder(Node focusNode){
		if (focusNode != null) {
			postOrder(focusNode.leftNode);
			postOrder(focusNode.rightNode);
			System.out.println(focusNode);
		}
	}

	public int theight(Node focusNode){
		if (focusNode != null) {
			int leftHeight = theight(focusNode.leftNode);
			int rightHeight = theight(focusNode.rightNode);
			int maxHeight = max(leftHeight, rightHeight)+1;
			return maxHeight;
		}else{
			return 0;
		}
	}

	public int max(int leftHeight, int rightHeight){
		if(leftHeight<rightHeight){
			return rightHeight;
		}else{
			return leftHeight;
		}
	}

	public int findElement(Node focusNode, int ele){
		if (focusNode != null) {
			if (ele < focusNode.key) {
				focusNode = focusNode.leftNode;
				return findElement(focusNode, ele);
			}else if (ele > focusNode.key) {
				focusNode = focusNode.rightNode;
				return findElement(focusNode, ele);
			}else{
				return focusNode.key;
			}
		}else{
			return 0;
		}
	}

/*	public int breathFirstSearch(Node focusNode, int ele){
		if (focusNode != null) {
			queu

		}
	}
*/
	int []queueArray = new int[15];
	int top = 0;
	int bottom = 0;
	
	public void queuePush(int num){
		if(top < queueArray.length){
			queueArray[top] = num;
			top++;
			//System.out.println("bottom: "+bottom+ " | top: "+top);
		}else if (top == queueArray.length) {
			System.out.println("Queue full");
		}else{
			System.out.println("Queue Empty");
		}
	}

	public void queuePop(){
		if (bottom <= queueArray.length) {
			queueArray[bottom] = 0;
			int i;
			for (i = 1; i < top; i++) {
				queueArray[i-1] = queueArray[i];
			}
			top = i-1;
			for (i=top; i<queueArray.length; i++) {
				queueArray[i]=0;
			}
			//System.out.println("bottom: "+bottom+ " | top: "+top);
		}else if (bottom == 0) {
			System.out.println("Queue Empty");
		}
	}

	

	public void printArray(){
		System.out.print(" | ");
		for (int ele : queueArray) {
			System.out.print(ele+" | ");
		}
		System.out.println("\n");
	}

	public int size(Node focusNode){
		int treeSize = 0;
		if (focusNode == null) {
			return 0;
		}else{
			return size(focusNode.leftNode)+1+size(focusNode.rightNode);
		}
	}

	/*public Node deleteNode(Node focusNode, int ele){
		if (focusNode == null) {
			return focusNode;
		}
		if (focusNode.key > ele) {
			focusNode = focusNode.leftNode;
			focusNode = deleteNode(focusNode, ele);
		}else if (focusNode.key < ele) {
			focusNode = focusNode.rightNode;
			focusNode = deleteNode(focusNode, ele);
		}else{
			if (focusNode.leftNode != null) {
				focusNode = focusNode.leftNode;
				focusNode = deleteNode(focusNode, ele);
			}else if (focusNode.rightNode != null) {
				focusNode = focusNode.rightNode;
				focusNode = deleteNode(focusNode, ele);
			}else{
				
				focusNode = (focusNode.leftNode != null)? focusNode.leftNode : focusNode.rightNode;
			}
		}
		return focusNode;
	}*/

/*	public boolean remove(int ele){

	}
*/
	public static void main(String[] args) {
		Btree bt = new Btree();
		bt.addNode(50);
		bt.addNode(25);
		bt.addNode(15);
		bt.addNode(30);
		bt.addNode(60);
		bt.addNode(75);
		bt.addNode(55);
		bt.addNode(40);
		bt.addNode(35);
		bt.addNode(65);
		bt.addNode(45);
		
		System.out.println("-----------------InOrder------------------");
		bt.inOrder(bt.root);
		/*
		System.out.println("-----------------PreOrder------------------");
		bt.preOrder(bt.root);
		System.out.println("-----------------PostOrder------------------");
		bt.postOrder(bt.root);
		System.out.println("-----------------------------------");
		System.out.println("maxHeight : "+bt.theight(bt.root));
		System.out.println("-----------------------------------");
		System.out.println("Match found : "+ bt.findElement(bt.root, 55));
		System.out.println("-----------------------------------");
		System.out.println("Match not found : "+ bt.findElement(bt.root, 555));
		System.out.println("-----------------------------------");
		*/
		//System.out.println("Size : "+ bt.size(bt.root));
		System.out.println();
		System.out.println("------------------------------------------------------------------");
		//bt.deleteNode(bt.root,55);
//		bt.addNode(28);
//		System.out.println("-----------------InOrder------------------");
//		bt.inOrder(bt.deleteNode(bt.root, 55));
		//Btree nbt = bt.deleteNode(bt, bt.root, 60);
		//System.out.println("Size : "+ bt.size(nbt.root));
		bt.queuePush(1);
		bt.queuePush(2);
		bt.queuePush(3);
		bt.queuePush(4);
		bt.queuePush(5);
		bt.queuePush(6);
		bt.queuePush(7);
		bt.queuePush(8);
		bt.queuePush(9);
		bt.queuePush(10);
		bt.queuePush(11);
		bt.queuePush(12);
		bt.printArray();
		bt.queuePop();
		bt.queuePop();
		bt.queuePop();
		bt.queuePop();
		bt.queuePop();
		bt.queuePop();
		bt.printArray();
		bt.queuePush(13);
		bt.printArray();

	}
}

class Node{
	int key;
	Node leftNode, rightNode;
	Node(int key){
		this.key = key;
	}
	public String toString(){
		return " | "+key;
	}
}