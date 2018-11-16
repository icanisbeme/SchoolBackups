import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
//C:\Users\User\Desktop\students.dat
public class StudentReport {
	public static void main (String[] args){
		int numStudents;
		Scanner sc = new Scanner(System.in);
		Boolean validFile = false;
		while (!validFile){
			/**
			 * lines 14-16 take user input for the location of a file and then
			 * assigns the file name studentInfo to that file 
			 */
			System.out.println("Input the file path: ");
			String fileLoc = sc.nextLine();
			File studentInfo = new File(fileLoc);
			try{
				Scanner fileData = new Scanner(studentInfo);
				while (fileData.hasNext()){
					validFile = true;
					numStudents = fileData.nextInt();
					Student [] students = new Student[numStudents];
					for (int i = 0; i < numStudents; i++){
						/**
						 * these following lines assign the values from the given file to a variable that 
						 * will be output later on in the program
						 */
						String last = fileData.next();
						String first = fileData.next();
						double test1 = fileData.nextDouble();
						double test2 = fileData.nextDouble();
						double test3 = fileData.nextDouble();
						double hw1 = fileData.nextDouble();
						double hw2 = fileData.nextDouble();
						double hw3 = fileData.nextDouble();
						double finalScore = fileData.nextDouble();
						Student student = new Student(last, first, test1, test2, test3, hw1, hw2, hw3, finalScore);
						students[i] = student;
						student.computeLetterGrade();
					}
					System.out.println("Enter 1 to print summary of all the students. Enter 2 to print grade summary.");
					int choice = sc.nextInt();
					/**
					 * The switch method takes the option that the user inputs and then acts out 1 of 2 cases
					 * depending on the users choice. The first one will output every students information, and
					 * it is formatted in such a way that it stays within the columns and is formatted correctly.
					 * The second case outputs the number of A B C D or F grades, which is calculated by the 
					 * method that exists in student.java
					 */
					switch(choice){
					case 1:
						System.out.printf("%-9s %-10s %-5s %-5s %-5s %-5s %-5s %-5s %-5s %-5s %-5s", "Last Name",
								"First Name", "Test1", "Test2", "Test3", "HW1", "HW2", "HW3", "Final", "AVG", "Grade");
						System.out.println();
						for(int i = 0; i < students.length; i++){
							students[i].printStudent();
							System.out.println();
						}
						break;
					case 2: 
						int numA=0, numB=0, numC=0, numD=0, numF=0;
						for(int i = 0; i < students.length; i++){
							if(students[i].getGrade() == 'A'){
								numA++;
							} else if(students[i].getGrade() == 'B'){
								numB++;
							} else if(students[i].getGrade() == 'C'){
								numC++;
							} else if (students[i].getGrade() == 'D'){
								numD++;
							} else if (students[i].getGrade() == 'F'){
								numF++;
							}

						}
						System.out.println("The number of A grades was : " + numA);
						System.out.println("The number of B grades was : " + numB);
						System.out.println("The number of C grades was : " + numC);
						System.out.println("The number of D grades was : " + numD);
						System.out.println("The number of F grades was : " + numF);
					}
				}
			}
			catch(FileNotFoundException e){
				System.out.println("Invalid file path.");
			}
		}
	}
}
