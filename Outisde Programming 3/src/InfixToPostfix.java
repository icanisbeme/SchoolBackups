import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class InfixToPostfix {
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		System.out.println("Please input your infix expression: ");
		String newInfix = input.nextLine();
		if(parenthesesBalance(newInfix) && operandBalance(newInfix)){
			System.out.println(postfixConversion(newInfix));
		}
	}

	public static boolean operandBalance(String expression){
		int numOperands = 0;
		int numOperators = 0;
		for(int i = 0; i < expression.length(); i++){
			if(Character.isLetter(expression.charAt(i))){
				numOperands++;
			}else if (expression.charAt(i) == '+' || expression.charAt(i) == '-'
					|| expression.charAt(i) == '*' || expression.charAt(i) == '/'){
				numOperators++;	
			}
		}
		System.out.println("Operands: " + numOperands + " Operators: " + numOperators);
		if(numOperands == numOperators + 1){
			return true;
		}else{
			System.out.println("Error: Unbalanced operands/operators.");
			return false;
		}
	}

	public static boolean parenthesesBalance(String expression){
		Queue<Character> stack = new LinkedList<Character>();
		for(int i = 0; i < expression.length(); i++){
			if(expression.charAt(i) == '(' || expression.charAt(i) == '[' || expression.charAt(i) == '{'){
				stack.add(expression.charAt(i));
			}
			if(expression.charAt(i) == '}'){
				if (stack.isEmpty()){
					return false;
				}
				else if(stack.peek() =='{'){
					stack.remove();
				}
			}
			if(expression.charAt(i) == ')'){
				if (stack.isEmpty()){
					return false;
				}
				else if(stack.peek() =='('){
					stack.remove();
				}
			}
			if(expression.charAt(i) == ']'){
				if (stack.isEmpty()){
					return false;
				}
				else if(stack.peek() =='['){
					stack.remove();
				}
			}
		}
		if(stack.isEmpty()){
			return true;
		}else {
			System.out.println("Error: Unbalanced parentheses.");
			return false;
		}
	}

	private static boolean isOperator(char newChar){
		return newChar == '(' || newChar == ')' || newChar == '*' || newChar == '/' || newChar
				== '-' || newChar == '+' || newChar == '*';
	}

	private static boolean order(char operator1, char operator2){
		switch (operator1){
		case '+':
		case '-': return !(operator2 == '+' || operator1	== '-');
		case '*':
		case '/': return operator2 == '^' || operator2 == '(';
		case '^': return operator2 == '(';
		case '(': return true;
		default: return false;
		}
	}

	public static String postfixConversion(String infix){
		Queue<Character> infixQueue = new LinkedList<Character>();
		for(int i = 0; i < infix.length(); i++){
			infixQueue.add(infix.charAt(i));
		}
		Queue<Character> postfix = new LinkedList<Character>();
		char c;
		for (int i = 0; i < infix.length(); i++){
			c = infix.charAt(i);
			if (!isOperator(c)){
				postfix.add(c);
			}else{
				if (c == ')'){
					while (!infixQueue.isEmpty() && infixQueue.peek() != '('){
						postfix.add(infixQueue.remove());
					}
					if (!infixQueue.isEmpty()){
						infixQueue.remove();
					}
				}else{
					if (!infixQueue.isEmpty() && !order(c, infixQueue.peek())){
						infixQueue.add(c);
					}else{
						while (!infixQueue.isEmpty() && order(c, infixQueue.peek())){
							char ch = infixQueue.remove();
							if (c != '('){
								postfix.add(ch);
							}else{
								c = ch;
							}
						}
						postfix.add(c);
					}
				}
			}
		}
		while (!infixQueue.isEmpty()){
			postfix.add(infixQueue.remove());
		}
		String result = "";
		for(int i = 0; i <= postfix.size(); i++){
			result += postfix.remove();
		}
		return result;
	}
}