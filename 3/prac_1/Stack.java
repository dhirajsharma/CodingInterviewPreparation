import java.util.*;
class Stack{
	int top = 0;
	List array = new ArrayList();
	
	public boolean isEmpty(){
		return (top == 0);
	}
	public void pop(){
		if(isEmpty()){
			System.out.println("Empty");
		}
		else{
			array.remove(top-1);
			top = top - 1;
		}		
		System.out.println(array.toString());
	}

	public void push(String value){
		array.add(value);
		top = top + 1;
		System.out.println(array.toString());
	}

	public static void main(String[] args){
		String exp = "{a+[b-c+d(e-f)+k]-j)";
		char[] expr = exp.toCharArray();
		Stack stack = new Stack();
		stack.pop();
		for(char ch: expr){
			stack.push(String.valueOf(ch));
		}
		stack.pop();
		stack.pop();
		stack.pop();
		stack.pop();
		stack.pop();
		stack.pop();
		stack.pop();
		stack.pop();
		stack.pop();
		stack.pop();
		stack.pop();
		stack.pop();
		
	}
}
