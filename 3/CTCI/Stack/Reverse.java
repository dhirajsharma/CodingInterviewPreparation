import java.io.*;
public class Reverse{
	private int maxSize;
	private char[] stackArray;
	private int top;

	public Reverse(int maxSize){
		maxSize = maxSize;
		stackArray = new char[maxSize];
		top = -1;
	}

	public void push(char ch){
		stackArray[++top] = ch;
	}

	public char pop(){
		return stackArray[top--];
	}

	public char peek(){
		return stackArray[top];
	}

	public boolean isEmpty(){
		return (top == -1);
	}

	public boolean isFull(){
		return (top == maxSize);
	}
}

class Reverser{
	private String input;
	private String output;

	public Reverser(String input){
		this.input = input;
	}

	public String doRev(){
		int stackSize = input.length();
		Reverse reverse = new Reverse(stackSize);

		for (int j = 0; j < input.length(); j++) {
			char ch = input.charAt(j);
			reverse.push(ch);
		}
		
		output = "";

		while(!reverse.isEmpty()){
			char ch = reverse.pop();
			output = output + ch;
		}
		return output;
	}
}

class ReverseApp{
	public static void main(String[] args) throws IOException {
		String input, output;

		while(true){
			System.out.print("Enter a String: ");
			System.out.flush();
			input = getString();

			if(input.equals("")){
				break;
			}

			Reverser reverser = new Reverser(input);
			output = reverser.doRev();
			System.out.println("Reversed: " + output);
		}
	}

	public static String getString() throws IOException{
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);

		String s = br.readLine();

		return s;
	}
}