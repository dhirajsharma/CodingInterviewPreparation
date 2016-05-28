import java.util.*;
public class MinStack{
	public static void main(String[] args) {
		

		MinStack ms = new MinStack();
		ms.push(5);
		ms.push(4);
		ms.push(3);
		ms.push(2);
		ms.push(1);
		System.out.println(ms.getMin());
	}

	//public MinStack(){
		private Stack<Integer> stack = new Stack<Integer>();
		private Stack<Integer> minStack = new Stack<Integer>();
	//}

	public void push(int x){
		this.stack.push(x);
		if (this.minStack.isEmpty()) {
			this.minStack.push(x);
		}else if (x <= this.minStack.peek()) {
			this.minStack.push(x);
		}
	}

	public void pop(){
		int n = this.stack.pop();
		if (n <= this.minStack.pop()) {
			this.minStack.pop();
		}
	}

	public int top(){
		return this.minStack.peek();
	}

	public int getMin(){
		assert this.minStack.isEmpty() == false;
		return this.minStack.peek();
	}
}