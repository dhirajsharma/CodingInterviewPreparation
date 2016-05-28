//|1|2|a|A|+|


public class Stack{
	Node top;

	Object pop(){
		if (top != null) {
			Object data = top.data;
			top = top.next;
			return data;
		}
		return null;
	}

	void push(Object data){
		Node node = new Node(data);
		node.next = top;
		top = node;
	}

	public static void main(String[] args) {
		Stack stack = new Stack();
		stack.push(1);
	//	System.out.println(Integer.toString(stack.toString()));
	}
}

class Node{
	Object data;
	Node next;
	Node(Object data){
		this.data = data;
	}

	public String toString(){
		return " | "+ data;
	}
}