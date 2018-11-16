import java.util.Scanner;
import java.util.Stack;
public class ParenthesesChecker {
	public static void main(String [] args){
		System.out.println("Please enter an expression: ");
		Scanner sc = new Scanner(System.in);
		String expression = sc.nextLine();
		System.out.println(expression);
		System.out.println(isBalanced(expression));
	}

	public static boolean isBalanced(String expression){
		Stack<Character> stack = new Stack<Character>();
		for(int i = 0; i < expression.length(); i++){
			if(expression.charAt(i) == '(' || expression.charAt(i) == '[' || expression.charAt(i) == '{'){
				stack.push(expression.charAt(i));
			}
			if(expression.charAt(i) == '}'){
				if (stack.isEmpty()){
					return false;
				}
				else if(stack.peek() =='{'){
					stack.pop();
				}
			}
			if(expression.charAt(i) == ')'){
				if (stack.isEmpty()){
					return false;
				}
				else if(stack.peek() =='('){
					stack.pop();
				}
			}
			if(expression.charAt(i) == ']'){
				if (stack.isEmpty()){
					return false;
				}
				else if(stack.peek() =='['){
					stack.pop();
				}
			}
		}
		if(stack.isEmpty()){
			return true;
		}else {
			return false;
		}
	}
}