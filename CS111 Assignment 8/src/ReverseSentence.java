import java.util.Scanner;
import java.util.Stack;

public class ReverseSentence {
	public static void main(String [] args){
		System.out.println("Please enter a string: ");
		Scanner sc = new Scanner(System.in);
		String original = sc.nextLine();
		System.out.println(original);
		String[] userString = original.split(" ");
		Stack<String> sentence = new Stack<String>();
		String reversed = "";
		for(int i = 0; i < userString.length; i++){
			String word = userString[i];
			sentence.push(word);	
		}
		for(int j = 0; j < userString.length; j++){
			String newWord = sentence.pop(); 
			reversed += newWord + " ";
		}
		System.out.println(reversed);
	}
}