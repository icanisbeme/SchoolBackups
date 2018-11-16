import java.util.Scanner;

public class BasicCalc {
	static Scanner sc = new Scanner(System.in);
	static double num1;
	static double num2;
	static Boolean cont;
	public static void main (String[] args){
		for(int i = 0; i < 100; i++){
			if (cont = true){
				getNums();
				operations();
			}else if(cont = false){
				System.out.println("Thank you for using this BasicCalc program.");
			}
		System.out.println("Would you like to continue?");
		String contChoice = sc.next();
		if(contChoice.equals("no")){
			cont = false;
		}
		}
	}
	
	public static void getNums(){
		System.out.println("What is the first number?");
		num1 = sc.nextInt();
		System.out.println("What is the second number?");
		num2 = sc.nextInt();
	}
	
	private static void operations(){
		System.out.println("What would you like to do with those numbers? (sub, add, mult, divide)");
		String choice = sc.next();
		if(choice.equals("sub")){
			System.out.println(sub());
		}else if(choice.equals("add")){
			System.out.println(add());
		}else if(choice.equals("mult")){
			System.out.println(mult());
		}else if(choice.endsWith("divide")){
			System.out.println(divide());
		}
	}
	
	private static double mult(){
		return num1*num2;
	}
	private static double divide(){
		return num1/num2;
	}
	private static double add(){
		return num1+num2;
	}
	private static double sub(){
		return num1-num2;
	}
	
}
