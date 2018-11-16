import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class FileReadProblem {
	public static void main (String [] args){
		Scanner keyboard = new Scanner(System.in);
		System.out.println("Input the file with coordinates: ");
		String location = keyboard.nextLine();
		File coords = 
		
		StdDraw.setXscale(-25, 25);
		StdDraw.setYscale(-25, 25);
		StdDraw.circle(0, 0, 5);
		StdDraw.setPenRadius(0.01);
		StdDraw.line(-25, 0, 25, 0);
		StdDraw.line(0, -25, 0, 25);
		
		
		
	}
}
