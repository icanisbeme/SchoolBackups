//C:/Users/User/Downloads/Coordinates.txt
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
public class FileReadingProblem {
	public static void main (String [] args){
		//These Std.Draw methods establish the chart
		StdDraw.setXscale(-25, 25);
		StdDraw.setYscale(-25, 25);
		StdDraw.setPenRadius(0.01);
		StdDraw.line(-25, 0, 25, 0);
		StdDraw.line(0, -25, 0, 25);
		//These lines prompt and check the user for a valid file
		Boolean validInput = false;
		while(!validInput){
		Scanner keyboard = new Scanner(System.in);
		System.out.print("Input the file with coordinates: ");
		String location = keyboard.nextLine();
		File coords = new File(location);
		//These lines plot the points given in the file
			try{
				Scanner sc = new Scanner (coords);
				while(sc.hasNext()){
					int x = sc.nextInt();
					int y = sc.nextInt();
					if ( x >= 0 && y >= 0){
						StdDraw.setPenColor(StdDraw.GREEN);
						StdDraw.point(x, y);
					}
					
					if ( x > 0 && y < 0){
						StdDraw.setPenColor(StdDraw.BLACK);
						StdDraw.point(x, y);
					}
					
					if ( x < 0 && y > 0){
						StdDraw.setPenColor(StdDraw.RED);
						StdDraw.point(x, y);
					}
					
					if ( x < 0 && y < 0){
						StdDraw.setPenColor(StdDraw.BLUE);
						StdDraw.point(x, y);
					}
					
					if ( x == 0 || y == 0){
						StdDraw.setPenColor(StdDraw.BLACK);
						StdDraw.point(x, y);
					}
					
				}
			//This rejects an invalid file
			}catch(FileNotFoundException e){
				System.out.println("File not found. Please try again.");
			}
		}
	}
}