import java.util.Scanner;
public class GradeCalculator {
	public static void main (String[] args){
		Scanner sc = new Scanner(System.in);
		System.out.println("What was your grade on exam 1?");
		int test1 = sc.nextInt();
		System.out.println("What was your grade on exam 2?");
		int test2 = sc.nextInt();
		System.out.println("What was your grade on exam 3?");
		int test3 = sc.nextInt();
		System.out.println("What was your grade on exam 4?");
		int test4 = sc.nextInt();
		int testTotal = test1 + test2 + test3 + test4;
		System.out.println("Did you get the 20 bonus points?");
		String bonus = sc.next();
		if(bonus.equals("yes") || bonus.equals("Yes")){
			testTotal += 20;
		}
		System.out.println("Your test total, including the bonus, is: " + testTotal);
		System.out.println("What is your webassign percentage?");
		int webassign = sc.nextInt();
		double webassignPer = (webassign * 0.01);
		double webassignPoints = webassignPer * 75;
		double totalPoints = testTotal + webassignPoints;
		System.out.println("What did you get on the workbook check?");
		int wrkbk = sc.nextInt();
		totalPoints = totalPoints + wrkbk;
		System.out.println("Your total points is: " + totalPoints);
		System.out.println("As a percentage, your grade is: " + (totalPoints/5));
	}
}