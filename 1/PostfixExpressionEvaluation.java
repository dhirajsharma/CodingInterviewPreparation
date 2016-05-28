
import java.util.*;
public class PostfixExpressionEvaluation {
	public static void main(String[] args) {
					 // -2+1 = -1*4 = -4+5 = 1 -3 = 2
		String[] op = {"5", "1", "2", "+", "A", "*", "+", "3", "-"};
		PostfixExpressionEvaluation solution = new PostfixExpressionEvaluation();
		System.out.println(solution.evaluate(op));
	}

	public int evaluate(String[] op) {
		if (op==null || op.length == 0) {
			return Integer.MIN_VALUE;
		}
		
		if (op.length==1) {
			return Integer.parseInt(op[0]);
		}
		Integer x,y;
		Stack<Integer> stack = new Stack<Integer>();
		for (String value: op) {
//			System.out.print(value+"|");
			if (value == null) {
				return -1;
			}
			if (value == "+" || value == "-" || value == "*" || value == "/") {
				y = stack.pop();
				x = stack.pop();
				switch (value) {
					case "+": stack.push(x+y); break;
					case "-": stack.push(x-y); break;
					case "*": stack.push(x*y); break;
					case "/": stack.push(x/y); break;
				}
			} else if (Integer.parseInt(value) > Integer.MIN_VALUE || Integer.parseInt(value) < Integer.MAX_VALUE) {
				stack.push(Integer.parseInt(value));
			}
		}
		System.out.println(stack.peek());
		return stack.pop();
	}
}