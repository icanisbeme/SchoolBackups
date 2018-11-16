
public class Student{
	char letterGrade;
	private String lastName, firstName;
	double pointTotal = 0;
	private double test1score, test2score, test3score, hw1score, hw2score, hw3score, finalGrade;
	/**
	 * This student method establishes Student as something that takes many parameters, all of them information
	 * about the student and their grades that can be used later on in the information printing part of 
	 * the program. It also assigns these parameters to corresponding variables
	 * 
	 * @param last
	 * @param first
	 * @param test1
	 * @param test2
	 * @param test3
	 * @param hw1
	 * @param hw2
	 * @param hw3
	 * @param finalScore
	 */
	public Student(String last, String first, double test1, double test2, double test3,
				double hw1, double hw2, double hw3, double finalScore){
		lastName = last;
		firstName = first;
		test1score = test1;
		test2score = test2;
		test3score = test3;
		hw1score = hw1;
		hw2score = hw2;
		hw3score = hw3;
		finalGrade = finalScore;
	}
	
	/**
	 * This method is used to compute the total points that a student has earned and also will analyze that 
	 * number though different loops so that a letter grade value is assigned to that student 
	 */
	public void computeLetterGrade(){
		double testVal = 0.2;
		double hwVal = 0.15;
		double finalVal = 0.25;	
		double testPoints = (test1score * testVal) + (test2score * testVal) + (test3score *testVal);
		double hwPoints = ((hw1score + hw2score + hw3score) / 0.75) * hwVal;
		double finalPoints = (finalGrade) * finalVal;
		pointTotal = (testPoints + hwPoints + finalPoints);			
		if (pointTotal >= 90){
			letterGrade = 'A';
		} else if (pointTotal >= 80 && pointTotal < 90){
			letterGrade = 'B';
		} else if (pointTotal >= 70 && pointTotal < 80){
			letterGrade = 'C';
		} else if (pointTotal >= 60 && pointTotal < 70){
			letterGrade = 'D';
		} else if (pointTotal < 60){
			letterGrade = 'F';
		}
	}
	
	/**
	 * This method is a format print method that outputs the information about a student, and also formats
	 * it in such a way that it is aligned with columns of text that label what you are looking at 
	 */
	public void printStudent(){
		System.out.printf("%-9s %-10s %-5.2f %-5.2f %-5.2f %-5.2f %-5.2f %-5.2f %-5.2f %-5.2f %-5c", lastName, firstName, test1score, 
				test2score,	test3score, hw1score, hw2score, hw3score, finalGrade, pointTotal, letterGrade);
		}
	
	/**
	 * This method simply returns the letter grade of a student
	 * @return
	 */
	public char getGrade(){
		return letterGrade;
	}
}