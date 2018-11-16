import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

//C:/Users/User/Desktop/puzzle1.txt

public class wordsearch {
	static String keyword = "ham";
	public static void main (String [] args){
		char [] []  puzzle = null;
		puzzle = fill(puzzle);
		printPuzzle(puzzle);
		play(keyword, puzzle);
	}
	
	public static char[][] fill(char [] [] puzzle){
		Scanner sc = new Scanner(System.in);
		Boolean validFile = false;
		while (!validFile){
			System.out.println("Input the file path: ");
			String fileLoc = sc.nextLine();
			File letters = new File(fileLoc);
			try{	
				Scanner fileData = new Scanner(letters);
				int rows = fileData.nextInt();
				int cols = fileData.nextInt();
				puzzle = new char [rows] [cols];
				for (int i = 0; i < rows; i++){
					for (int j = 0; j < cols; j++){
						String nextLetter = fileData.next();
						puzzle[i][j] = nextLetter.charAt(0);
					}
				}
				validFile = true;
			}catch(FileNotFoundException e){
				System.out.println("Invalid file path.");
			}
		}
		return puzzle;
	}
	
	public static char [] [] printPuzzle( char [] [] puzzle){
		for (int i = 0; i < puzzle.length; i++){
			for (int j = 0; j < puzzle[0].length; j++){
				System.out.print(puzzle[i][j] + " ");
			}
			System.out.println();
		}
		return puzzle;
	}
	

	public static void play(String word, char [] [] puzzle){
		System.out.println("The word being searched for is: " + keyword);
		for (int row = 0; row < puzzle.length; row++){
			for (int col = 0; col < puzzle[0].length; col++){
				if (puzzle [row][col] == word.charAt(0)){
					if(checkUp(puzzle, word, row, col)){
						System.out.println("The keyword was found going up, starting at " + row + " " + col);
					}
					if (checkDown(puzzle, word, row, col)){
						System.out.println("The keyword was found going down, starting at " + row + " " + col);
					}
					if (checkRight(puzzle, word, row, col)){
						System.out.println("The keyword was found going right, starting at " + row + " " + col);
					}
					if (checkLeft(puzzle, word, row, col)){
						System.out.println("The keyword was found going left, starting at " + row + " " + col);
					}
					else if (checkLeft(puzzle, word, row, col) && checkRight(puzzle, word, row, col) 
							&& checkDown(puzzle, word, row, col) && checkUp(puzzle, word, row, col)){
						System.out.println("The word was not found in the puzzle.");
					}
				}	
			}
		}
		
	}
	
	public static boolean checkUp(char [][] puzzle, String word, int row, int col){
		for (int i = 0; i < word.length(); i++){
			if (row < 0){
				return false;
			}
			if (puzzle [row][col] == word.charAt(i)){
				row--;
			}
			else{
				return false;
			}
		} return true;
	}

	public static boolean checkDown(char [][] puzzle, String word, int row, int col){
		for (int i = 0; i < word.length(); i++){
			if (row < 0){
				return false;
			}
			if (puzzle [row][col] == word.charAt(i)){
				row++;
			}
			else{
				return false;
			}
		} return true;
	}

	public static boolean checkRight(char [][] puzzle, String word, int row, int col){
		for (int i = 0; i < word.length(); i++){
			if (row < 0){
				return false;
			}
			if (puzzle [row][col] == word.charAt(i)){
				col++;
			}
			else{
				return false;
			}
		} return true;
	}

	public static boolean checkLeft(char [][] puzzle, String word, int row, int col){
		for (int i = 0; i < word.length(); i++){
			if (row < 0){
				return false;
			}
			if (row < 0 && puzzle [row][col] == word.charAt(i)){
				col--;
			}
			else{
				return false;
			}
		} return true;
	}
}