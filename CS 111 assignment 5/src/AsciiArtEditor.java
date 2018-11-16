import java.io.IOException;
import java.util.Scanner;
public class AsciiArtEditor {
	public static void main (String[] args) throws IOException{
		Scanner input = new Scanner(System.in);
		System.out.println("Please supply a file path");
		String filename = input.nextLine();
		System.out.println("How many rows?");
		int numRows = input.nextInt();
		System.out.println("How many columns?");
		int numCols = input.nextInt();
		boolean repeat = true;
		asciiArt ascii = new asciiArt(filename, numRows, numCols);
		
		while(repeat){
		System.out.println("Please make a selection: ");
		System.out.println("1. Apply Flood Fill");
		System.out.println("2. Crop the image");
		System.out.println("3. Display Information");
		System.out.println("4. Save");
		System.out.println("5. Exit");
		int selection = input.nextInt();
		
		switch(selection){
		case 1: System.out.println("Enter the row from which you would like to perform Flood Fill.");
		int rowFF = input.nextInt();
		System.out.println("Enter the column from which you would like to perform Flood Fill.");
		int colFF = input.nextInt();
		System.out.println("Enter the target character.");
		char targetFF = input.next().charAt(0);
		System.out.println("Enter the replacement character");
		char replacementFF = input.next().charAt(0);
		ascii.floodFill(rowFF, colFF, targetFF, replacementFF);
		break;
		
		case 2: System.out.println("Enter the first column from which to crop.");
		int col1 = input.nextInt();
		System.out.println("Enter the first row from which to crop.");
		int row1 = input.nextInt();
		System.out.println("Enter the second column from which to crop.");
		int col2 = input.nextInt();
		System.out.println("Enter the second row from which to crop.");
		int row2 = input.nextInt();
		ascii.crop(col1, row1, col2, row2);
		break;
		
		case 3: System.out.println("The dimensions are " + numRows + " by " + numCols);
		break;
		
		case 4: System.out.println("What would you like to name the file?");
		String suppliedName = input.nextLine();
		ascii.save(suppliedName);
		System.out.println("Your image has been saved as " + suppliedName + ".");
		break;
		
		case 5: System.out.println("Thank you for using the Ascii Art Editor.");
		repeat = false;
		break;
			}
		}
	}	


}
