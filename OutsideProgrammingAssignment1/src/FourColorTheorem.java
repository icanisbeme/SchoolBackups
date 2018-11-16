import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
//C:\Users\User\Desktop\newMap.txt
public class FourColorTheorem {
	int [] colorMap = {1, 2, 3, 4};
	static int [][] mapArray = null;
	int numRows;
	int numCols;
	static int numRegions;
	Scanner input = new Scanner(System.in);

	public static void main (String[] args){
		System.out.println("Please input a map.");
		Scanner input = new Scanner(System.in);
		String filename = input.nextLine();
		System.out.println("Please input the number of regions");
		numRegions = input.nextInt();
		FourColorTheorem fourColorTheorem = new FourColorTheorem(filename, numRegions);
		System.out.println(fourColorTheorem);
		solve(numRegions);
		System.out.println(fourColorTheorem);
	}
/**
 * Function, to construct the adjacency matrix from the given file, unless the file is invalid, in which case
 * an error is thrown
 * Pre-conditions, a valid string and valid file are entered for the file name parameter, and that a valid integer
 * matching the adjacency matrix is given for numRegions
 * Post-conditions, a valid file is read and the mapArray is created
 * Response to abnormal behavoir: throw fileNotFoundException error
 * 
 * @param filename, the name of the file to be read
 * @param numRegions, the number of regions in the map
 */
	public FourColorTheorem(String filename, int numRegions){
		File file = new File(filename);
		mapArray = new int [numRegions][numRegions];
		try {
			Scanner infoMap = new Scanner(file);
			while(infoMap.hasNextLine()){
				for (int rows = 0; rows < numRegions; rows++){
					for (int cols = 0; cols < numRegions; cols++){
						mapArray[rows][cols] = infoMap.nextInt();
					}
				}
			}
		}catch (FileNotFoundException e){
			System.out.println("The file supplied is invalid.");
		}
	}
/**
 * Function, to take the given adjacency matrix and convert it to a text interpretation and return it
 * Pre-conditions, that mapArray is a valid adjacency matrix
 * Post-conditions, the result string is a fully formed matrix
 * Response to abnormal behavoir, error terminate
 */
	public String toString(){
		String result = "";
		for (int row = 0; row < mapArray[0].length; row++) {
			for (int col = 0; col < mapArray.length; col++) {
				result += mapArray[row][col] + " ";
			}
			result += "\n";
		}
		return result;
	}
/**
 * Function, to solve the adjcency matrix such that no regions next to each other are the same color
 * Pre-conditions, a valid adjcency matrix has been created
 * Post-conditions, the matrix is solved
 * 
 * @param numRegions, the number of regions in the map
 * @return returns true if the map is graded, false if it is not yet solved
 */
	public static boolean solve(int numRegions){
		boolean isSolved = false;
		int setRow;
		int setCol;
		for(int row = 0; row < numRegions-1; row++){
			for(int col = 0; col < numRegions-1; row++){
				if(mapArray[row][col] == 1){
					setRow = row;
					setCol = col;
					mapArray[0][setCol] = 1;
					if(mapArray[0][setCol] == 1){
						mapArray[0][setCol] = 2;
					} else if(mapArray[0][setCol] == 2){
						mapArray[0][setCol] = 3;
					} else if (mapArray[0][setCol] == 3){
						mapArray[0][setCol] = 4;
					}
				}
			}
		}
		
		return isSolved;
	}
/**
 * Function, to see if two regions are adjacent to another
 * Pre-conditions, a valid adjcacency matrix is available and a valid integer is given for the number of regions
 * Post-conditions, isAdjacent shows if the regions are adjacent
 * @param map, the map of region adjacencies
 * @param numRegions, the number of regions in the map
 * @return whether or not the regions are adjacent
 */
	private boolean adjacent(int[][] map, int numRegions){
		boolean isAdjacent = false;
		for(int rows = 1; rows < numRegions; rows++){
			for(int cols = 1; cols < numRegions; cols++){
				if(map[rows][cols] == 1){
					isAdjacent = true;
				}
			}
		}
		return isAdjacent;
	}

}