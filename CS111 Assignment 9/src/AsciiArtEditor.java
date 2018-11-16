import java.io.IOException;
import java.util.Scanner;

public class AsciiArtEditor {

	public static void main(String[] args) throws IOException{
		Scanner input = new Scanner(System.in);
		System.out.println("Please supply a file path");
		String filename = input.nextLine();
		System.out.println("How many rows?");
		int numRows = input.nextInt();
		System.out.println("How many columns?");
		int numCols = input.nextInt();
		AsciiArt art = new AsciiArt(filename, numRows, numCols);

		boolean repeat = true;

		while(repeat){

			System.out.println("Please indicate your choice with a number: ");
			System.out.println("1. Apply floodfill.");
			System.out.println("2. Replace character.");
			System.out.println("3. Replace an area of the image.");
			System.out.println("4. Display information.");
			System.out.println("5. Save image.");
			System.out.println("6. Exit.");
			int choice = input.nextInt();
			switch(choice){

			case 1: System.out.println("Indicate the row at which to begin: ");
			int startRow = input.nextInt();
			System.out.println("Indicate the col at which to begin: ");
			int startCol = input.nextInt();
			System.out.println("Indicate the character to replace: ");
			String replacementString = input.next();
			char replacementChar = replacementString.charAt(0);
			System.out.println("Indicate the character to replace it with: ");
			String newCharString = input.next();
			char newChar = newCharString.charAt(0);
			art.floodFill(startRow, startCol, replacementChar, newChar);
			art.toString();
			break;

			case 2: System.out.println("What character would you like to replace?");
			char targetChar = input.nextLine().charAt(0);
			System.out.println("What would you like to replace it with?");
			char newReplacementChar = input.nextLine().charAt(0);
			art.replaceChar(targetChar, newReplacementChar);
			art.toString();
			break;

			case 3: System.out.println("Input the leftmost x coordinate you'd like to start replacing at: ");
			int row1 = input.nextInt();
			System.out.println("Input the right most x coordinate you'd like to end replacing at: ");
			int row2 = input.nextInt();
			System.out.println("Input the highest y coordinate to start replacing at: ");
			int col1 = input.nextInt();
			System.out.println("Input the lowest y coordinate to end replacing at: ");
			int col2 = input.nextInt();
			System.out.println("What character would you like to replace the are with?");
			char areaReplacementChar = input.nextLine().charAt(0);
			art.replaceArea(row1, col1, row2, col2, areaReplacementChar);
			art.toString();
			break;

			case 4: System.out.println("The dimensions are " + numRows + " x " + numCols);
			break;

			case 5: System.out.println("What would you like to name the file?");
			String newFilename = input.next();
			art.save(newFilename);
			break;
			
			case 6: System.out.println("Thank you for using the Ascii Art Editor.");
			repeat = false;
			}
		}
	}	
}