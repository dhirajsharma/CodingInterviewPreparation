/*
Evaluate the value of a Postfix expression, also known as expression in Reverse Polish Notation.
Given: An array of strings, every string being either an operand or an operator, in Reverse Polish Notation, find out the value of the expression.

Assumptions: The given postfix expression will be a valid expression.
1. String operands will be valid Integers (positive or negative)
2. Operators will be valid operators in: + - / *
3. 0 will not be passed as a divisor for division operation.

Example:
Input:
20    30    +
Output: 
50

Input:
5    1    2    +    4    *    +    3    -
Output: 
14

Note: Input is an array of strings to allow numbers with multiple digits as operands.
For example "20", "45" etc.
*/

import java.util.Stack;
public class PostfixExpressionEvaluation {

	public static int evalPostfixExpression(String[] op){
		if (op.length == 1) {
			return Integer.parseInt(op[0]);
		}

		Stack<Integer> stack = new Stack<Integer>();
		for (String exp : op) {
			Integer value = null;
			String operators = null;

			if ((exp.charAt(0) >= '0' && exp.charAt(0) <= '9') || (exp.charAt(0) == '-' && exp.length() > 1)) {
				value = Integer.parseInt(exp);
			} else {
				operators = exp;
			}

			if (operators != null) {
				Integer y = stack.pop();
				Integer x = stack.pop();
				
				switch (operators) {
					case "+" : value = x + y; break;
					case "-" : value = x - y; break;
					case "*" : value = x * y; break;
					case "/" : value = x / y; break;
				}
			}

			stack.push(value);
		}
		return stack.pop();
	}

	public static void main(String[] args) {
		String[] op = {"5", "1", "2", "+", "4", "*", "+", "3", "-"};
        System.out.println("Value of the expression is " + evalPostfixExpression(op));
	}
}