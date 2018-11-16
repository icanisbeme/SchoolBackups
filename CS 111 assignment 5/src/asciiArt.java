import java.util.Scanner;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.File;
import java.io.FileNotFoundException;
//C:\Users\User\Downloads\Scream.txt
public class asciiArt {
	private char [][] image;
	private int numRow;
	private int numCol;

	public String toString(){
		String finalImage = "";
		for (int row = 0; row < numRow; row++){
			for (int col = 0; col < numCol; col++){
				finalImage += image[row][col];
			}
			finalImage += "\n";
		}
		return finalImage;
	}
	
	public void crop(int col1, int row1, int col2, int row2){
		col2 = numCol;
		row2 = numRow;
		char [][] croppedImage = new char[row1-row2][col1-col2];
		for(int cols = col1; cols <= col2; cols++){
			for(int rows = row1; rows <= row2; rows++){
				croppedImage[rows-row1][cols-col1] = image[cols][rows];
			}
		}
	}
	
	public asciiArt(String filename, int numRow, int numCol){
		image = new char[numRow][numCol];
		Scanner imageInput = null;
		File imageFile = new File(filename);
		
		try{
			imageInput = new Scanner(imageFile);
		}catch (FileNotFoundException e){
			System.out.println("Sorry, that file is invalid. Please try again.");
		}
		String line = "";
		for(int row = 0; row < numRow; row++){
			line = imageInput.nextLine();
			for(int col = 0; col < numCol; col++){
				image[row][col] = line.charAt(col);
			}
		}
	}
	
	public char getChar(int row, int col){
		return image[row][col];
	}
	
	public void floodFill(int row, int col, char target, char replacement){
		if(image[row][col] != target || target == replacement){
			return;
		}
		image[row][col] = replacement;
		if(row < numRow - 1){
			floodFill(row+1, col, target, replacement);
			return;
		}
		if(row < numRow - 1){
			floodFill(row-1, col, target, replacement);
			return;
		}
		if(col < numCol - 1){
			floodFill(row, col-1, target, replacement);
			return;
		}
		if(col < numCol - 1){
			floodFill(row, col+1, target, replacement);
			return;
		}
	}
	
	public void save(String filename) throws IOException{
		PrintWriter saver = new PrintWriter(filename);
		saver.write(toString());
		saver.close();
	}
}